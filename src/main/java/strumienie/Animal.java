package strumienie;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Animal {
    private String name;
    private int age;
}
