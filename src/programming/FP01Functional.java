package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

//        printAllNumbersInListFunctional(numbers);
//        printEvenNumbersInListFunctional(numbers);
        printSquaresOfEvenNumbersInListFunctional(numbers);
    }

//    private static void print(int number) {
//        System.out.println(number);
//    }

//    private static boolean isEven(int number) {
//        return number % 2 == 0;
//    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //What to do?
        numbers.stream()
                .forEach(System.out::println);
    }

    // number -> number % 2 == 0
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //What to do?
        numbers.stream()
                .filter(n -> n % 2 == 0) //Filter - only even numbers (lambda expression)
                .forEach(System.out::println);  //Methhod reference
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        //What to do?
        numbers.stream()
                .filter(n -> n % 2 == 0) //Filter - only even numbers (lambda expression)
                .map(n -> n * n)
                .forEach(System.out::println);  //Methhod reference
    }
}
