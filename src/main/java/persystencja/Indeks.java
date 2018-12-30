package persystencja;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "indeksy")
public class Indeks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String number;
    @OneToOne(mappedBy = "indeks")
    private Student student;

    public Indeks (String number){
        this.number=number;
    }
}
