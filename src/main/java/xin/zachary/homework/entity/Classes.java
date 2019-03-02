package xin.zachary.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Classes {
    //id生成策略按照用时间戳
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String overview;
    @Column
    private int studentNumbers;
    @Column
    private Date date;
    @Column
    private String teacherUsername;

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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getStudentNumbers() {
        return studentNumbers;
    }

    public void setStudentNumbers(int studentNumbers) {
        this.studentNumbers = studentNumbers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", studentNumbers=" + studentNumbers +
                ", date=" + date +
                ", teacherUsername='" + teacherUsername + '\'' +
                '}';
    }
}
