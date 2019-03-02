package xin.zachary.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native",strategy="native")
    private int id;
    @Column
    private String username;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private int age;

    public Teacher() {
    }

    public Teacher(int id, String username, String name, String gender) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

