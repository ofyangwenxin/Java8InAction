package chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Finding {
    public static void main(String[] args) {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(someNumbers);
        Optional<Integer> firstSquare = someNumbers.stream()
                .map(x -> x * x)
                .findFirst();
        if (firstSquare.isPresent()) {
            System.out.println(firstSquare.get());
        }

        Optional<Integer> anySquare = someNumbers.stream()
                .map(x -> x * x)
                .findAny();
        if (anySquare.isPresent()) {
            System.out.println(anySquare.get());
        }
    }
}
