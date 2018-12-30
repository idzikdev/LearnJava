package persystencja;

import javax.persistence.*;
import java.util.List;

public class AppJPQL {
    public static EntityManagerFactory factory= Persistence.createEntityManagerFactory("persystencja1");
    public static EntityManager manager=factory.createEntityManager();
    public static void createData(){
        manager.getTransaction().begin();
        Student jan=manager.merge(new Student("Jan","123456"));
        Student pawl=manager.merge(new Student("Paweł","3434"));
        Student jan2=manager.merge(new Student("Jan","123456"));
        manager.getTransaction().commit();
    }
    public static void main(String[] args) {
        createData();
        manager.createQuery("SELECT s FROM Student s").getResultList().forEach(System.out::println);
        List<Indeks> indeksy=manager.createQuery("SELECT s.indeks FROM Student s",Indeks.class).getResultList();

//        TypedQuery<Indeks> query=manager.createQuery("SELECT s.indeks FROM Student s WHERE s.name=:name",Indeks.class);
//        query.setParameter("name","Jan");
//        System.out.println(query.getSingleResult());

        TypedQuery<QueryResult> query1=manager.createQuery("SELECT new persystencja.QueryResult(s.name,s.indeks.number) FROM Student s",QueryResult.class);
        query1.getResultList().forEach(System.out::println);

        List<CountResult> results=manager.createQuery("SELECT new persystencja.CountResult(s.name, count(s)) from Student s group by s.name having s.name in ('Paweł','Jan') order by s.name",CountResult.class).getResultList();
        System.out.println(results);

        List<Student> students=manager.createNamedQuery("Student.getAll",Student.class).getResultList();
        System.out.println(students);
    }
}
