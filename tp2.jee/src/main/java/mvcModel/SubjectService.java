package mvcModel;
import java.util.*;



import entities.Subject;
import entities.Teacher;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

/**
 * Session Bean implementation class SubjectService
 */
@Stateless
@LocalBean
public class SubjectService {
@PersistenceContext(unitName="tp2.jee")
private EntityManager em;

    /**
     * Default constructor. 
     */
    public SubjectService() {
       
    	// TODO Auto-generated constructor stub
    }

    
    
    public List<Subject> getAllSujects()
    {
    List<Subject> subjects = new ArrayList<Subject>();
    TypedQuery<Subject> query =
    em.createNamedQuery("Subject.findAll",Subject.class);
    subjects = query.getResultList();
    return subjects;
    }
    
    
    public List<Subject> deleteSubjectById(int subjectId)
    {
    List<Subject> subjects = new ArrayList<Subject>();
    Subject sub = em.find(Subject.class, subjectId);
    if(sub!=null)
    em.remove(sub);
    TypedQuery<Subject> query =
    em.createNamedQuery("Subject.findAll",Subject.class);
    subjects = query.getResultList();
    return subjects;
    }
    
    public List<Subject> getAllSujectsByTitleAndAffiliation(String subjectTitle,
    		String teacherAffiliation)
    		{
    		List<Subject> subjects = new ArrayList<Subject>();
    		TypedQuery<Subject> query =
    		em.createNamedQuery("Subject.findAllByTitleAndAffiliation",Subject.class);
    		query.setParameter(1, subjectTitle);
    		query.setParameter(2, teacherAffiliation);
    		subjects = query.getResultList();
    		return subjects;
    		}
   
    public void ajoutmat(Subject sub) {
    em.persist(sub);
    }
    public void TeacherService() {
    
    }
    public List<Teacher> getAllTeachers(){
    	TypedQuery<Teacher> query = em.createNamedQuery("Teacher.findAll",Teacher.class);
    	return query.getResultList();
    }


    public Teacher getTeacherById(int teacherId) {
    return em.find(Teacher.class, teacherId);
    }
    
    List<Teacher> getTeacherBySubject(String subjectTitle){
    	TypedQuery<Teacher> query=em.createQuery("SELECT t from Teacher t where t.subject.title=:title",Teacher.class);
    	query.setParameter("title",subjectTitle);
    	return query.getResultList();
    			
    }



}