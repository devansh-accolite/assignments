package model;

import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @Column(name = "courseId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer courseId;
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "studentId")
    private int studentId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getStudentId() { return studentId; }

    public void setStudentId(int studentId) { this.studentId = studentId; }
}
