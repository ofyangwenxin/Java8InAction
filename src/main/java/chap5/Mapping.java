package chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> wordString = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        wordString.stream().map(Arrays::toString)
                .forEach(System.out::println);

        System.out.println("------------");

        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        System.out.println("------------");

        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        System.out.println("------------");

        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> pairs = number1.stream()
                .flatMap(i -> number2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        List<int[]> pairs2 = number1.stream()
                .flatMap(i -> number2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
    }
}
