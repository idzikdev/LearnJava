package funkcyjne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class AppOptional {
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
        Supplier<List<Student>> listSupplier= AppSupplier::createData;
        Student student=listSupplier.get().get(2);
        Optional<String> name=Optional.ofNullable(student.getName());
        if (name.isPresent()){
            System.out.println(name.get());
        }
        name.ifPresent(i-> System.out.println(i));
        name.filter(i->i.equals("Kasia")).ifPresent(i-> System.out.println(i));
        name.map(i->i+"a").filter(i->i.length()>0).ifPresent(i-> System.out.println(i));
    }
}
