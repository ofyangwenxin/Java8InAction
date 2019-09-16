package chap5;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapping {

    public static void main(String[] args) {
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        streamOfwords.forEach(System.out::println);
    }
}
