package persystencja;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "university")
    private Set<Student> students;
    public University(String name) {
        this.students=new HashSet<>();
        this.name = name;
    }
    public void addStudent(Student student){
        students.add(student);
    }
}
