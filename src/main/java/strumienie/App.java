package strumienie;

import funkcyjne.AppSupplier;
import funkcyjne.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static List<Student> createData() {
        List<Student> result = new ArrayList<>(
                Arrays.asList(
                        new Student("Paweł", 38),
                        new Student("Jacek", 34),
                        new Student("Kasia", 26),
                        new Student("Tomasz", 39)
                )
        );
        return result;
    }

    public static void main(String[] args) {
        Supplier<List<Student>> supplier= AppSupplier::createData;
        Predicate<Student> over30=student -> student.getAge()>=30;
        Function<Student,String> getStudentName= student -> student.getName();
        Consumer<String> print=s -> System.out.println(s);
        Consumer<Student> printName=s-> System.out.println(s.getName());
        Consumer<List<Student>> printConsumer=s-> System.out.println(s);
        List<Student> students=supplier.get();
        students.stream().filter(over30).map(getStudentName).forEach(print);
        Stream.of("A","B","C").forEach(print);
        List<Student> studentList=createData();
        studentList.stream().filter(over30).map(getStudentName).forEach(print);
        Supplier<List<Student>> listSupplier= AppSupplier::createData;
        Stream.generate(listSupplier).limit(4).forEach(printConsumer);
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
        Stream.iterate(0,i->i+2).limit(20).forEach(System.out::println);
        IntStream.rangeClosed(5,100).filter(i->i%2==0).forEach(System.out::println);
    }
}
