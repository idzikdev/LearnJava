package strumienie;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Person {
    private String name;
    private String surname;
    private int age;

    public static void main(String[] args) {

    }
}
