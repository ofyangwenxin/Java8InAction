package chap2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }

    /**
     * 筛选绿苹果
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

//    public static List<Apple> filterApplesByColor(List)
}
