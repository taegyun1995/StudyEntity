package moderJava.동작파라미터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.*;
import static moderJava.동작파라미터.Color.GREEN;
import static moderJava.동작파라미터.Color.RED;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(GREEN, 80),
                new Apple(GREEN, 150),
                new Apple(RED, 120)
        );

        List<Apple> greenApples = filterGreenApples(inventory);

        List<Apple> redApples = filterApplesByColor(inventory, RED);
        List<Apple> applesByWeight = filterApplesByWeight(inventory, 100);

        List<Apple> apples = filterApples(inventory, GREEN, 100, true);

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples2 = filterApples(inventory, new AppleGreenColorPredicate());

        List<Apple> redApples2 = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        List<Apple> result = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        List<Apple> redApples3 = filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        // version1
        inventory.sort(
                (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())
        );
        // version2
        inventory.sort(
                comparing(Apple::getWeight)
        );

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (GREEN.equals(a.getColor())) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (a.getColor().equals(color)) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (a.getWeight() > weight) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if ((flag && a.getColor().equals(color)) || (!flag && a.getWeight() > weight)) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (p.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

}