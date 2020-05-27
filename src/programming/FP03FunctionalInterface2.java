package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterface2 {



    public static void main(String[] args) {

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;


        Function<Integer, Integer> squareFunctions = x -> x * x;
        Function<Integer, String> stringOutputFunction = x -> x + "";


        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);


        BinaryOperator<Integer> sumBinaryOperation = (x, y) -> x + y;


        Supplier<Integer> randomIntegerSupplier =  () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
//        System.out.println(randomIntegerSupplier.get());


        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
//        System.out.println(unaryOperator.apply(10));


        BiPredicate<Integer, String> intStrBiPredicate = (x, y) -> x > y.length();
//        System.out.println(intStrBiPredicate.test(5, "dom"));
//        true

        BiFunction<Integer, String, String> intStrIntBiFunction = (x, y) -> x + y;
//        System.out.println(intStrIntBiFunction.apply(5, "dom"));
//        5dom ( y - Integer, x - String, result - String

        BiConsumer<Integer, String> intStrBiConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
//        intStrBiConsumer.accept(26, ".05");
//        26.05

//        Poniższe interfejsy są do wykorzystania na typach prostych
        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        System.out.println(intBinaryOperator.applyAsInt(4, 9));
//        IntConsumer
//        IntPredicate
//        IntConsumer
//        IntSupplier
//        IntToDoubleFunction
//        IntToLongFunction
//        IntUnaryOperator
    }
}


