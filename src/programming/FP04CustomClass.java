package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

//        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
//        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
//        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));


        Comparator<Course> comparingByNumberOfStudentsIncreasing
                = Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsIncreasing)
                .collect(Collectors.toList()));
        /** [FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96] **/

        Comparator<Course> comparingByNumberOfStudentsDecreasing
                = Comparator.comparingInt(Course::getNoOfStudents)
                            .reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsDecreasing)
                .collect(Collectors.toList()));
        /**[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]**/

        Comparator<Course> comparingByNumberOfStudentsAndReviewScore
                = Comparator.comparingInt(Course::getNoOfStudents)
                            .thenComparing(Course::getReviewScore)
                            .reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviewScore)
                .collect(Collectors.toList()));
        /** [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]88? **/

        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviewScore)
                .limit(5)
                .collect(Collectors.toList()));
        /** [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98] **/

        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviewScore)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList()));
        /** [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95] **/

        System.out.println(courses);

        System.out.println(courses.stream()
                .takeWhile(c -> c.getReviewScore() >= 95)
                .collect(Collectors.toList()));
        /** [Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96] **/

        System.out.println(courses.stream()
                .dropWhile(c -> c.getReviewScore() >= 95)
                .collect(Collectors.toList()));
        /** [FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91] **/

        System.out.println(courses.stream()
                .max(comparingByNumberOfStudentsAndReviewScore));
        /** Optional[FullStack:14000:91] **/

        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNumberOfStudentsAndReviewScore));
        /** Optional.empty **/

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .findFirst());
//                .findAny
        /** Optional[Spring:20000:98] **/

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToDouble(Course::getNoOfStudents)
                .sum());
        /** 88000.0 **/

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average());
        /** OptionalDouble[22000.0] **/

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .count());
        /** 4 **/

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .max());
        /** OptionalInt[25000] **/

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .min());
        /** OptionalInt[20000] **/

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));
        /** {Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
         * FullStack=[FullStack:14000:91],
         * Microservices=[API:22000:97, Microservices:25000:96],
         * Framework=[Spring:20000:98, Spring Boot:18000:95]}
         **/

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        /** {Cloud=4, FullStack=1, Microservices=2, Framework=2} **/

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        /** {Cloud=Optional[Azure:21000:99],
         * FullStack=Optional[FullStack:14000:91],
         * Microservices=Optional[API:22000:97],
         * Framework=Optional[Spring:20000:98]}
         **/

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList()))));
        /** {Cloud=[AWS, Azure, Docker, Kubernetes],
         * FullStack=[FullStack],
         * Microservices=[API, Microservices],
         * Framework=[Spring, Spring Boot]} **/



    }
}
