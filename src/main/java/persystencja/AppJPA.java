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
        manager.getTransaction().begin();
        Student jan=manager.merge(new Student("Jan"));
        Indeks indeks=manager.merge(new Indeks("indeks1"));
        jan.setIndeks(indeks);
        jan=manager.merge(jan);
        indeks.setStudent(jan);
        manager.merge(indeks);
        manager.getTransaction().commit();
        System.out.println(jan);

        Indeks mergeIndeks=manager.merge(indeks);
        Indeks indx=manager.find(Indeks.class,mergeIndeks.getId());
        System.out.println(indx);
//        System.out.println(jan);
//        createStudent(jan);
//        createStudent(new Student(11,"Józef"));
//        createStudent(new Student(1,"Kasia"));
//        updateStudent(1);
//        removeStudent(11);
//        readStudents();
    }
}
