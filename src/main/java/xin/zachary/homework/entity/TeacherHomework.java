package xin.zachary.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "teacher_homework")
public class TeacherHomework {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native",strategy="native")
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String contentType;
    @Column
    private Date date;
    @Column
    private String teacher_username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTeacher_username() {
        return teacher_username;
    }

    public void setTeacher_username(String teacher_username) {
        this.teacher_username = teacher_username;
    }
}

