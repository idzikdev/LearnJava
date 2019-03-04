package strumienie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SearchForPalindrom {
    String text;

    public SearchForPalindrom(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SearchForPalindrom{" +
                "text='" + text + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        List<String> lista;
        lista = Files.readAllLines(Paths.get("src/main/java/strumienie/palindrom.txt"));
        lista.stream()
                .filter(text -> new StringBuilder(text).reverse().toString().equals(text))
                .forEach(text -> System.out.println(text));
    }
}
