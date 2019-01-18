package strumienie;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zadania {
    public static int sumaCyfr(int number) {
        int result = 0;
        String value = String.valueOf(number);
        for (int i = 0; i < value.length(); i++) {
            result = result + Integer.valueOf(value.charAt(i) + "");
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> plik = Files.readAllLines(Paths.get("src/main/java/strumienie/data.txt"));
        List<Person> people = new ArrayList<>();
        for (String s : plik
        ) {
            String[] line = s.split((","));
            people.add(new Person()
                    .builder()
                    .name(line[0])
                    .surname(line[1])
                    .age(Integer.valueOf(line[2]))
                    .build());
        }
        System.out.println("Osoby");
        System.out.println(people);

        System.out.println();
        System.out.println("Zadanie 1");
//       Znajdź średnią wartość wieku wszystkich osób.

        people.stream()
                .mapToInt(s -> s.getAge())
                .average()
                .ifPresent(result -> System.out.println(result));


        System.out.println();
        System.out.println("Zadanie 2");
//        Znajdź najstarszego człowieka i dopisz do jego imienia prefix Geek.

        people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .ifPresent(s -> System.out.println("Geek " + s.getName()))
        ;
        System.out.println();
        System.out.println("Zadanie 3");
//        Utwórz nowego człowieka ze wszystkich ludzi w następujący sposób:
//          imię to pierwsze litery innych,
//          nazwisko to ostatnie litery innych,
//          wiek to suma lat pozostałych ludzi.

        people.stream()
                .map(s -> new Person()
                        .builder()
                        .name(s.getName().substring(0, 1))
                        .surname(s.getSurname().substring(0, 1))
                        .age(s.getAge()).build())
                .reduce((s, i) -> new Person()
                        .builder()
                        .name(s.getName() + i.getName().charAt(i.getName().length() - 1))
                        .surname(s.getSurname() + s.getName().charAt(i.getSurname().length() - 1))
                        .age(s.getAge() + i.getAge())
                        .build())
                .ifPresent(s -> System.out.println(s));


        System.out.println();
        System.out.println("Zadanie 4");
//        Utwórz listę lat ludzi na podstawie listy ludzi.

        Map<Integer, List<Person>> lista = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        for (Map.Entry<Integer, List<Person>> element : lista.entrySet()
        ) {
            System.out.println("WIEK= " + element.getKey() + " "
                    + element.getValue());
        }


        System.out.println();
        System.out.println("Zadanie 5");
//        Znajdź człowieka, którego suma cyfr
//        lat jest taka sama jak suma liter w imieniu.
        people.stream()
                .filter(s -> s.getName().length() == sumaCyfr(s.getAge()))
                .forEach(s -> System.out.println(s));

        System.out.println();
        System.out.println("Zadanie 6");
//        Posortuj ludzi malejąco.
        people.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()) * -1)
                .forEach(s -> System.out.println(s));


        System.out.println();
        System.out.println("Zadanie 7");
//        Usuń ludzi, którzy występują podwójnie.
//        Następnie podaj ilu takich ludzi było (dokumentacja)

        System.out.println(people.size() - people.stream()
                .distinct()
                .count());

        System.out.println();
        System.out.println("Zadanie 8");
//        Na podstawie ludzi utwórz klasę Animal : imię, wiek.
//                Imie – złączenie imie i nazwisko człowieka,
//                a wiek to wiek podzielony przez 10

        people.stream()
                .map(s -> new Animal()
                        .builder().name(s.getName() + " " + s.getSurname())
                        .age(s.getAge() / 10)
                        .build())
                .forEach(s -> System.out.println(s));


        System.out.println();
        System.out.println("Zadanie 9");
//      Zamień wiek ludzi na psie lata n*6-2,
//      a następnie wyświetl tych ludzi,
//      których wiek przekracza 50 po zamianie

        people.stream()
                .map(s -> new Person().builder()
                        .name(s.getName()).surname(s.getSurname())
                        .age(s.getAge() * 6 - 2).build())
                .filter(s -> s.getAge() > 50)
                .forEach(s -> System.out.println(s));


        System.out.println();
        System.out.println("Zadanie 10");
//        Zgrupuj ludzi,
//        których suma liter w imieniu i nazwisku jest taka sama

        Map<Integer, List<Person>> lista2 = people.stream()
                .collect(Collectors.groupingBy
                        (s -> s.getName().length() + s.getSurname().length()
                        ));
        System.out.println(lista2);

        System.out.println();
        System.out.println("Zadanie 11");
//        Zgrupuj wszystkich ludzi po nazwiskach.
//         Wyświetl najpopularniejsze nazwisko

        List<String> lista3=people.stream()
                .map(s -> s.getSurname())
                .collect(Collectors.toList());
        System.out.println(lista3);
    }
}
