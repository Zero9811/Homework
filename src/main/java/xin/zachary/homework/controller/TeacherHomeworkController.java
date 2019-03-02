package xin.zachary.homework.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import xin.zachary.homework.entity.Task;
import xin.zachary.homework.entity.TeacherHomework;
import xin.zachary.homework.serviceimpl.TaskServiceImpl;
import xin.zachary.homework.serviceimpl.TeacherHomeworkServiceImpl;
import xin.zachary.homework.util.ZipUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
public class TeacherHomeworkController {

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private TeacherHomeworkServiceImpl teacherHomeworkService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request, MultipartFile file, int taskId, HttpSession session) throws Exception {

        System.out.println("测试是否得到了文件： "+file.getOriginalFilename());
        System.out.println("测试是否得到了任务名： "+taskId);
        //文件不为空，写入目录,学生和老师上传的目录不一样
        if(!file.isEmpty() && session.getAttribute("usertype").equals("teacher")){
            String path = request.getServletContext().getContextPath()+"/teacherUpload/";
            System.out.println(path);
            String fileName = file.getOriginalFilename();
            File filePath = new File(path,fileName);
            //目录不存在时创建目录
            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            //文件存在时，先删除文件
            File existFile = new File(path+File.separator+fileName);
            if(existFile.exists())
                existFile.delete();
            //将文件写入
            file.transferTo(new File(path+File.separator+fileName));

            //将记录存进数据库
            Task task = (Task) taskService.queryById(taskId).get(0);
            task.setTeacherHomeworkName(fileName);
            taskService.update(task);

            List list =teacherHomeworkService.queryByName(fileName);
            if(list.size()==0) {//不存在时写入
                TeacherHomework teacherHomework = new TeacherHomework();
                teacherHomework.setName(fileName);
                teacherHomework.setAddress(path + fileName);
                teacherHomework.setDate(new Date());
                teacherHomework.setContentType(file.getContentType());
                teacherHomework.setTeacher_username((String) session.getAttribute("username"));
                teacherHomeworkService.saveOrUpdate(teacherHomework);
            }else {//存在时更新
                TeacherHomework teacherHomework = (TeacherHomework) list.get(0);
                teacherHomework.setName(fileName);
                teacherHomework.setAddress(path + fileName);
                teacherHomework.setDate(new Date());
                teacherHomework.setContentType(file.getContentType());
                teacherHomework.setTeacher_username((String) session.getAttribute("username"));
                teacherHomeworkService.saveOrUpdate(teacherHomework);
            }

            return "success";
        }
        else if(!file.isEmpty() && session.getAttribute("usertype").equals("student")){
            String path = request.getServletContext().getContextPath()+"/studentUpload/"+taskId+"/";
            System.out.println(path);
            String fileName = file.getOriginalFilename();
            File filePath = new File(path,fileName);
            //目录不存在时创建目录
            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            //文件存在时，先删除文件
            File existFile = new File(path+File.separator+fileName);
            if(existFile.exists())
                existFile.delete();
            //将文件写入
            file.transferTo(new File(path+File.separator+fileName));

            return "success";
        }
            return "error";
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpSession session,HttpServletRequest request, Model model,int taskId) throws Exception {

        Task task = (Task) taskService.queryById(taskId).get(0);
        //路径
        if(session.getAttribute("usertype").equals("student")) {
            String path = request.getServletContext().getContextPath() + "/teacherUpload/";
            File file = new File(path + File.separator + task.getTeacherHomeworkName());

            HttpHeaders headers = new HttpHeaders();
            //解决乱码问题
            String downloadFileName = new String(task.getTeacherHomeworkName().getBytes("UTF-8"), "iso-8859-1");
            //以attachment的方式打开
            headers.setContentDispositionFormData("attachment", downloadFileName);
            //application/octet-stream ： 二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
        }
        else{
            String path = request.getServletContext().getContextPath()+"/studentUpload/"+taskId+"/";

            ZipUtil zipUtil = new ZipUtil();
            if(zipUtil.fileToZip(path,path,String.valueOf(taskId))){
                System.out.println("现在的路径是："+path);
                String fileName = taskId+".zip";
                System.out.println("下载的文件名是"+fileName);
                File file = new File(path+File.separator + fileName);

                HttpHeaders headers = new HttpHeaders();
                //解决乱码问题
                String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
                //以attachment的方式打开
                headers.setContentDispositionFormData("attachment", downloadFileName);
                //application/octet-stream ： 二进制流数据（最常见的文件下载）。
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
            }
            else return null;
        }
    }
}
