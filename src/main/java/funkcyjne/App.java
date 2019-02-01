package funkcyjne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Student> result = new ArrayList<>(
                Arrays.asList(
                        new Student("Paweł", 38),
                        new Student("Jacek", 34),
                        new Student("Kasia", 26),
                        new Student("Tomasz", 39)
                )
        );
        List<Integer> integers=new ArrayList<>(
                Arrays.asList(12345,54354,12344,232434)
        );
        List<Integer> lista=integers.stream()
                .map(s->new StringBuilder(String.valueOf(s)).length())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(lista);
    }
}
