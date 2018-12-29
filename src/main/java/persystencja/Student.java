package persystencja;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Indeks indeks;
    @ManyToOne
    @ToString.Exclude
    private University university;
    @ManyToMany
    private Set<Classes> classes;
    public Student(String name){
        this.name=name;
    }
    public Student(String name,String indexNumber){
        this.name=name;
        this.indeks=new Indeks(indexNumber);
        this.classes=new HashSet<>();
    }

    public void addClasses(Classes classes){
        this.classes.add(classes);
    }
//    @Embedded
//    private Address address;
}
