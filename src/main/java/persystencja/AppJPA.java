package persystencja;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppJPA {
    public static EntityManagerFactory factory= Persistence.createEntityManagerFactory("persystencja");
    public static EntityManager manager=factory.createEntityManager();

    public static void createStudent(Student student){
        manager.getTransaction().begin();
        manager.persist(student);
        manager.getTransaction().commit();
    }

    public static void readStudent(){
        Student student=manager.find(Student.class,15);
        System.out.println(student);
    }

    public static void readStudents(){
        String query="FROM Student";
        List<Student> studenci=manager.createQuery(query).getResultList();
        studenci.forEach(System.out::println);
    }

    public static void updateStudent(int id){
        Student student=manager.find(Student.class,id);
        student.setName("Tomasz");
        manager.getTransaction().begin();
        manager.merge(student);
        manager.getTransaction().commit();
    }

    public static void removeStudent(int id){
        Student student=manager.find(Student.class,id);
        manager.getTransaction().begin();
        manager.remove(student);
        manager.getTransaction().commit();
    }

    public static void main(String[] args) {
        createStudent(new Student(15,"Jan"));
        createStudent(new Student(11,"Józef"));
        createStudent(new Student(1,"Kasia"));
        updateStudent(1);
        //removeStudent(11);
        readStudents();
    }
}
