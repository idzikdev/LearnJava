package persystencja;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Indeks {
    @Id
    private int id;
    private String number;
    @OneToOne(mappedBy = "indeks")
    private Student student;

    public Indeks (int id,String number){
        this.id=id;
        this.number=number;
    }
}
