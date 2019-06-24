package chap3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Apple {
        private Integer weight = 0;
        private String color = "";
    }

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

    public static void main(String[] args) {
        // 初始化
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"), new Apple(120, "red")));

        // 1
        inventory.sort(new AppleComparator());
        System.out.println(inventory);
        inventory.set(1, new Apple(30, "green"));

        // 2
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(inventory);
        inventory.set(1, new Apple(20, "red"));

        // 3
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        inventory.set(1, new Apple(10, "red"));

        // 4
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }
}
