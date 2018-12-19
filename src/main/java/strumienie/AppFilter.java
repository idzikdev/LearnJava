package strumienie;

import funkcyjne.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppFilter {
    public static Stream<Student> createDataStream(){
        Student student1=new Student("Paweł",38);
        Student student2=new Student("Jacek",34);
        Student student3=new Student("Kasia",38);
        Student student4=new Student("Tomasz",39);
        return Stream.of(student1,student2,student3,student4);
    }
    public static void main(String[] args) throws IOException {
        Predicate<Student> over30= student -> student.getAge()>30;
        Consumer<String> println= System.out::println;
        Function<Student,String> getStudentName=Student::getName;

//        createDataStream().filter(over30).map(getStudentName).forEach(println);
        createDataStream().filter(over30).map(getStudentName).findFirst().ifPresent(System.out::println);
        System.out.println(createDataStream().map(getStudentName).anyMatch(name->name.equals("Kasia")));
        System.out.println(createDataStream().map(Student::getName).allMatch(s->new StringBuilder(s).reverse().equals(s)));
        System.out.println(Files.readAllLines(Paths.get("src/main/java/strumienie/palindrom.txt")).stream().map(String::toLowerCase).allMatch(s->new StringBuilder(s).reverse().equals(s)));
        //suma dziesięciu liczb losowych
        System.out.println(Stream.generate(Math::random).limit(10).reduce(0.0, (aDouble, aDouble2) -> aDouble+aDouble2));
        System.out.println(Stream.generate(Math::random).limit(10).reduce(0.0, Double::sum));
        //najstarszy student
        createDataStream().map(Student::getAge).max(Comparator.naturalOrder()).ifPresent(i-> System.out.println(i));
        createDataStream().map(Student::getAge).reduce(Integer::max).ifPresent(System.out::println);
        //lista wieku studentów
        System.out.println(createDataStream().map(Student::getAge).collect(Collectors.toList()));
        String wiek=createDataStream().map(Student::getAge).map(s->s.toString()).collect(Collectors.joining(","));
        System.out.println(wiek);
        //mapa
        Map<Integer, List<Student>> list=createDataStream().collect(Collectors.groupingBy(Student::getAge));
        list.forEach((integer, students) -> {
            System.out.println("Wiek "+integer);
            students.stream().map(Student::getName).forEach(println);
        });
        //primitywne
        IntStream intStream=createDataStream().map(Student::getAge).mapToInt(value -> value.intValue());
    }

}
