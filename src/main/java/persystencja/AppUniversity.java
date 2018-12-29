package persystencja;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppUniversity {
    public static EntityManagerFactory factory= Persistence.createEntityManagerFactory("persystencja");
    public static EntityManager manager=factory.createEntityManager();

    public static void main(String[] args) {
        manager.getTransaction().begin();
        Student jan=manager.merge(new Student("Jan","123456"));
        University umcs=manager.merge(new University("UMCS"));
        jan.setUniversity(umcs);
        umcs.addStudent(jan);
        manager.merge(jan);
        manager.merge(umcs);
        manager.getTransaction().commit();
        University university=manager.find(University.class,umcs.getId());
        System.out.println(university);
    }
}
