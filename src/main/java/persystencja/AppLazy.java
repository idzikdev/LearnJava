package persystencja;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppLazy {
    public static EntityManagerFactory factory= Persistence.createEntityManagerFactory("mysql");
    public static EntityManager manager=factory.createEntityManager();
    public static void createData(){
        manager.getTransaction().begin();
        Student jan=manager.merge(new Student("Jan","123456"));
        Student pawel=manager.merge(new Student("Paweł","3434"));
        University umcs=manager.merge(new University("UMCS"));
        umcs.addStudent(jan);
        umcs.addStudent(pawel);
        manager.merge(umcs);
        manager.getTransaction().commit();
        manager.clear();
    }
    public static void main(String[] args) {
        createData();
        manager.createQuery("from University").getResultList().forEach(System.out::println);
    }
}
