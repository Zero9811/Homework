package xin.zachary.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Grades {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native",strategy="native")
    private int id;
    @Column
    private String studentUsername;
    @Column
    private int taskId;
    @Column
    private double grade;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
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

    public void setCalculateGrade(){
        grade = multipleChoice+clozeTest+readingComprehension+errorCorrection+composition;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", studentUsername='" + studentUsername + '\'' +
                ", taskId=" + taskId +
                ", grade=" + grade +
                ", multipleChoice=" + multipleChoice +
                ", clozeTest=" + clozeTest +
                ", readingComprehension=" + readingComprehension +
                ", errorCorrection=" + errorCorrection +
                ", composition=" + composition +
                '}';
    }
}