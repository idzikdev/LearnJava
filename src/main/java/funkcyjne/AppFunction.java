package funkcyjne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AppFunction {
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

    public static List<Student> getStudents(Supplier<List<Student>> list, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        List<Student> studentList=list.get();
        for (Student student : studentList
        ) {
            if (predicate.test(student)) result.add(student);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Student> students = createData();
        Predicate<Student> kasiaPredicate = student -> "Kasia".equals(student.getName());
        Consumer<String> print = string -> System.out.println(string);
        Supplier<List<Student>> listSupplier= AppSupplier::createData;
        Function<Student,String> getStudentName= Student::getName;
        consumeStudents(getStudents(listSupplier,kasiaPredicate),getStudentName,print);
    }

    public static void consumeStudents(List<Student> list, Function<Student,String> function,Consumer<String> consumer) {
        for (Student student : list
        ) {
            consumer.accept(function.apply(student));
        }
    }
}
