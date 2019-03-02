package xin.zachary.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Mistakes {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native",strategy="native")
    private int id;
    @Column
    private String studentUsername;
    @Column
    private int taskId;
    @Column
    private Date date;
    @Column
    private double multipleChoice;
    @Column
    private double clozeTest;
    @Column
    private double readingComprehension;
    @Column
    private double errorCorrection;
    @Column
    private double composition;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(double multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public double getClozeTest() {
        return clozeTest;
    }

    public void setClozeTest(double clozeTest) {
        this.clozeTest = clozeTest;
    }

    public double getReadingComprehension() {
        return readingComprehension;
    }

    public void setReadingComprehension(double readingComprehension) {
        this.readingComprehension = readingComprehension;
    }

    public double getErrorCorrection() {
        return errorCorrection;
    }

    public void setErrorCorrection(double errorCorrection) {
        this.errorCorrection = errorCorrection;
    }

    public double getComposition() {
        return composition;
    }

    public void setComposition(double composition) {
        this.composition = composition;
    }

    @Override
    public String toString() {
        return "Mistakes{" +
                "id=" + id +
                ", studentUsername='" + studentUsername + '\'' +
                ", taskId=" + taskId +
                ", date=" + date +
                ", multipleChoice=" + multipleChoice +
                ", clozeTest=" + clozeTest +
                ", readingComprehension=" + readingComprehension +
                ", errorCorrection=" + errorCorrection +
                ", composition=" + composition +
                '}';
    }
}

