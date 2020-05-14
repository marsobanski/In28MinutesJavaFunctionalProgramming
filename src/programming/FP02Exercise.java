package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercise {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AMS", "PCF", "Azure", "Docker", "Kubernetes");

        List<Integer> list = courses.stream()
                .map(n -> n.length())
                .collect(Collectors.toList());

        System.out.println(list);

    }
}
