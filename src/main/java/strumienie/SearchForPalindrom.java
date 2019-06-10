package strumienie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SearchForPalindrom {


    public static void main(String[] args) throws IOException {
      List<String> arr = Files.readAllLines(Paths.get("C:\\projekty\\LearnJava\\src\\main\\java\\strumienie\\palindrom.txt")) ;
        arr.stream()
                .filter(wiersz->new StringBuilder(wiersz).reverse().toString().equals(wiersz))
                .forEach(System.out::println);

    }
}
