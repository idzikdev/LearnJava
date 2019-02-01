package funkcyjne;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App2 {


    public static void main(String[] args) {
        List<Student> result = new ArrayList<>(
                Arrays.asList(
                        new Student("Paweł", 38),
                        new Student("Jacek", 34),
                        new Student("Kasia", 26),
                        new Student("Tomasz", 39)
                )
        );

        Predicate<String> predicateKasia = student -> "Kasia".equals(student);
        Predicate<Student> predicateJacek = student -> "Jacek".equals(student.getName());
        Predicate<String> predicateA = student -> 'a'==(student.charAt(1));

        List<String> ll=result.stream()
                .map(s->s.getName())
                .filter(predicateA)
                .collect(Collectors.toList());



//        System.out.println(ll);
//        System.out.println(abc(result,predicateJacek));
        List<Integer> integers=new ArrayList<>(Arrays.asList( 43534534,5,235,55));


    }

    public static List<Student> abc(List<Student> list, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();

        for (Student item : list) {
            if (predicate.test(item)) result.add(item);
        }

        return result;
    }





}
