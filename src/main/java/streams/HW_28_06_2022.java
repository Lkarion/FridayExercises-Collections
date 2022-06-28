package streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HW_28_06_2022 {
    /**
     * 1. Есть два класса Group {String title, List<Student>}, Student{String name, List<Double> payments}.
     * Необходимо написать метод, который вернет список всех студентов.
     * Учтите, что один и тот же студент может посещать несколько групп.
     */
    static class Group {
        private String title;
        private List<Student> students;

        public Group(String title, List<Student> students) {
            this.title = title;
            this.students = students;
        }
    }
    static class Student{
        private String name;
        private List<Double> payments;

        public Student(String name, List<Double> payments) {
            this.name = name;
            this.payments = payments;
        }
    }

    public static List<String> getAllStudentsNames(List<Group> groups) {

        Set<Student> s = groups.stream()
                .flatMap(group -> group.students
                                .stream())
                .collect(Collectors.toSet());

        return s.stream()
                .map(student -> student.name)
                .toList();
    }

    /**
     * 2. Есть два класса Group {String title, List<Student>}, Student{String name, List<Double> payments}.
     * Необходимо написать метод, который вернет сумму всех платежей, т.е. общий доход.
     */
    public static Double getSumTotalPayments(List<Group> groups) {

        return groups.stream()
                .flatMap(group -> group.students.stream())
                .distinct()
                .mapToDouble(student ->
                        student.payments.stream()
                                .reduce(0.0, Double::sum))

                .sum();
    }

    /**
     * 3. Есть два класса Group {String title, List<Student>}, Student{String name, List<Double> payments}.
     * Необходимо написать метод, который вернет студентов, сумма платежей которых меньше заданной суммы.
     */
    public static List<Student> getStudentsWithPaymentsLessThan(List<Group> groups, double sum) {

        return groups.stream()
                .flatMap(group -> group.students
                        .stream())
                .filter(student ->
                        student.payments
                                .stream()
                                .reduce(0.0, Double::sum) < sum)
                .distinct()
                .toList();
    }
    /**
     * 4. Используя Stream получить лист c первыми 20 числами Фибоначчи.
     */
    public static List<Long> getFibonacci(int quantity) {

        return Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]})
                .limit(quantity)
                .map(t -> t[0])
                .toList();
    }
}
