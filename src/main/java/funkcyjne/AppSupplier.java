package funkcyjne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AppSupplier {
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
        Consumer<Student> printName = student -> System.out.println(student.getName());
        Consumer<Student> printAge = student -> System.out.println(student.getAge());
        Consumer<Student> printNameAndAge = printName.andThen(printAge);
        Supplier<List<Student>> listSupplier= AppSupplier::createData;
        consumeStudents(getStudents(listSupplier, kasiaPredicate), printNameAndAge);
    }

    public static void consumeStudents(List<Student> list, Consumer<Student> consumer) {
        for (Student student : list
        ) {
            consumer.accept(student);
        }
    }
}
