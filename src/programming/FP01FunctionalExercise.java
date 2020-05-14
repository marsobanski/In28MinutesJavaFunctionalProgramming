package programming;

import java.util.List;

public class FP01FunctionalExercise {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AMS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
                .map(c -> c.length())
                .forEach(System.out::println);

    }
}
