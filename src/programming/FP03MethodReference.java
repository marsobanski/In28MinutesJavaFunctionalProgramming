package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03MethodReference {

    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AMS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
//                .map(str -> str.toUpperCase())
                .map(String::toUpperCase) // można się tak odwoływać też do metod, które nie są statyczne
                .forEach(FP03MethodReference::print);

        Supplier<String> supplier = () -> new String();
        Supplier<String> supplier2 = String::new;
//        dwa sposoby na utowrzenie nowego obiektu
    }
}


