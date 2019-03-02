package xin.zachary.homework.serviceimpl;

import org.springframework.stereotype.Service;
import xin.zachary.homework.entity.StudentHomework;
import xin.zachary.homework.service.StudentHomeworkService;

@Service("studentHomeworkService")
public class StudentHomeworkServiceImpl extends BaseServiceImpl<StudentHomework> implements StudentHomeworkService {
}
