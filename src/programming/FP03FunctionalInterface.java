package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterface {



    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        Function<Integer, Integer> squareFunctions = x -> x * x;
        Function<Integer, Integer> squareFunctions2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        };


        Consumer<Integer> sysoutConsumer = System.out::println;

        numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .forEach(System.out::println);

    }
}


