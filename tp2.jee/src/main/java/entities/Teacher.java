package entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity

@NamedQueries({
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t"),
@NamedQuery(name="Teacher.findById",query="SELECT t FROM Teacher t WHERE t.id=:id"),
@NamedQuery(name="Teacher.findBySubject" ,  query =" SELECT t from Teacher t where t.subject.title =:title")
})



public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacherId;

	private String affiliation;

	private String firstName;

	private String name;

	private String tel;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
	private List<Subject> subjects;

	public Teacher() {
	}

	public int getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getAffiliation() {
		return this.affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Subject addSubject(Subject subject) {
		getSubjects().add(subject);
		subject.setTeacher(this);

		return subject;
	}

	public Subject removeSubject(Subject subject) {
		getSubjects().remove(subject);
		subject.setTeacher(null);

		return subject;
	}

}