package funkcyjne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Data
final public class Student {
    private String name;
    private int age;

}
