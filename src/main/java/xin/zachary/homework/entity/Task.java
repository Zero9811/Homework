package xin.zachary.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native",strategy="native")
    private int id;
    @Column
    private String taskName;
    @Column
    private String teacherHomeworkName;
    @Column
    private String teacherUsername;
    @Column
    private Date date;
    @Column
    private String address;

    public Task() {
    }

    public Task(int id, String taskName, int teacherHomeworkId, String teacherUsername, Date date, String address) {
        this.id = id;
        this.taskName = taskName;
        this.teacherHomeworkName = teacherHomeworkName;
        this.teacherUsername = teacherUsername;
        this.date = date;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getTeacherHomeworkName() {
        return teacherHomeworkName;
    }

    public void setTeacherHomeworkName(String teacherHomeworkName) {
        this.teacherHomeworkName = teacherHomeworkName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", teacherHomeworkId=" + teacherHomeworkName +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }
}

