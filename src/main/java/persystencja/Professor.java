package persystencja;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "professors")
public class Professor {
    @Id
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Embedded
    private Address address;
}
