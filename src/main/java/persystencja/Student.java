package persystencja;

import lombok.*;

import javax.persistence.*;

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
    @OneToOne
    @ToString.Exclude
    private Indeks indeks;
    public Student(String name){
        this.name=name;
    }
//    @Embedded
//    private Address address;
}
