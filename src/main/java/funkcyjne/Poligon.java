package funkcyjne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Poligon {



    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student("Paweł", 38),
                        new Student("Jacek", 34),
                        new Student("kajak", 26),
                        new Student("Tomasz", 39)
                )
        );
        list.stream()
                .map(student -> student.getName())
                .filter(name -> new StringBuilder(name).reverse().toString().equals(name))
                .forEach(name -> System.out.println(name));

        list.stream()
                .mapToInt(lata -> lata.getAge())
                .reduce((a,b)-> a+b)
                .ifPresent(wiek -> System.out.println(wiek));

        list.stream()
                .map(s->new kot(s.getName().charAt(0)+"",s.getAge()*7))
                .mapToInt(s-> s.getAge())
                .average()
                .ifPresent(srednia -> System.out.println(srednia));








    }
}
