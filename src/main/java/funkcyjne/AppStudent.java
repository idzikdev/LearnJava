package funkcyjne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AppStudent {
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

    public static List<Student> getStudents(List<Student> list,Predicate<Student> predicate){
        List<Student> result=new ArrayList<>();
        for (Student student:list
        ) {
            if (predicate.test(student))result.add(student);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Student> students = createData();
        Predicate<Student> kasiaPredicate = student -> "Kasia".equals(student.getName());
        System.out.println("Studenci");
        System.out.println(students);
        System.out.println("Studenci z predykatem");
        System.out.println(getStudents(students,kasiaPredicate));
        Predicate<Student> equals20OrMoreandKasia=kasiaPredicate.and(kasiaPredicate);
        System.out.println(getStudents(students,equals20OrMoreandKasia));
    }
}
