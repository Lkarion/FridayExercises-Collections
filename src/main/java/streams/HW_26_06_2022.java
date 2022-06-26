package streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class HW_26_06_2022 {

     /**
     * 2022-06-22
     * Дан map<email, Person>. Необходимо проверить, что для всех записей email указанный в ключе соответствует email указанному у user-a
     * Дан map<email, Person>. Необходимо сформировать список email-ов десяти уникальных пользователей, чей возраст попадает в заданный интервал.
     * Дан List<Double>. Необходимо найти значение элемента максимально близкого к некоторому заданному значению N.
     */
     public static boolean isCorrectEmail(HashMap<String, Person> mapInput) {
          return mapInput.keySet().stream()
                  .allMatch(key -> key.equals(mapInput.get(key).email));
     }


     public static List<String> getEmailList(HashMap<String, Person> mapInput, int minAge, int maxAge, int limit) {
          return mapInput.keySet().stream()
                  .filter(key -> mapInput.get(key).age >= minAge && mapInput.get(key).age <= maxAge)
                  .map(key -> mapInput.get(key).email)
                  .distinct()
                  .limit(limit)
                  .collect(Collectors.toList());
     }

     public static Double getClosestElement (List<Double> input, Double n) {
          if (input == null || n == null) throw new NullPointerException("smth is null!");

          return input.stream()
                  .min(Comparator.comparingDouble(d -> Math.abs(d-n)))
                  .orElseThrow(() -> new NoSuchElementException("No element found"));
     }


     static class Person {
          String name;
          int age;
          String email;
          String phone;

          public Person(String name, int age, String email, String phone) {
               this.name = name;
               this.age = age;
               this.email = email;
               this.phone = phone;
          }
     }

}
