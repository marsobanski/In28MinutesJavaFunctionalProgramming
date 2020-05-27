package programming;

import java.util.List;
import java.util.function.BinaryOperator;
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
        Function<Integer, String> stringOutputFunction = x -> x + "";
        Function<Integer, Integer> squareFunctions2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        BinaryOperator<Integer> sumBinaryOperation = (x, y) -> x + y;
        BinaryOperator<Integer> sumBinaryOperation2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunctions)
                .forEach(sysoutConsumer);

    }
}


