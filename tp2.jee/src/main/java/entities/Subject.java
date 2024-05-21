package entities;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import java.util.List;

/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s"),
    @NamedQuery(name="Subject.findAllByTitleAndAffiliation", query="SELECT s FROM Subject s WHERE s.subjectTitle = ?1 AND s.teacher.affiliation = ?2")
})
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int subjectId;

    private int hoursNbr;

    private String prerequisites;

    private String subjectTitle;

    private String targetPopu;

    //bi-directional many-to-many association to Student
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="enrollement",
        joinColumns={
            @JoinColumn(name="subjectId")
        },
        inverseJoinColumns={
            @JoinColumn(name="studentId")
        }
    )
    private List<Student> students;

    //bi-directional many-to-one association to Teacher
    @ManyToOne
    @JoinColumn(name="teacherId")
    private Teacher teacher;

    public Subject() {
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getHoursNbr() {
        return this.hoursNbr;
    }

    public void setHoursNbr(int hoursNbr) {
        this.hoursNbr = hoursNbr;
    }

    public String getPrerequisites() {
        return this.prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getSubjectTitle() {
        return this.subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getTargetPopu() {
        return this.targetPopu;
    }

    public void setTargetPopu(String targetPopu) {
        this.targetPopu = targetPopu;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
