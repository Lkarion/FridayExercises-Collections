package streams;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class FrEx_08_07_2022 {
    /**
     * 1. Класс BankAccount имеет поле IBAN, а класс Person имеет поле name и поле List<BankAccount>.
     * Написать метод, возвращающий IBANs, в которых номера заменены * после третьего символа
     * [DE2********,DE5***********,]
     */

    public static List<String> listOfAccountsWithStarsNew(List<PersonNew> input) {

        return input.stream()
                .flatMap(personNew -> personNew.getBankAccounts()
                        .stream()
                        .map(bankAccountNew -> bankAccountNew.getIBAN()))
                .map(iban -> {
                    String res = iban.substring(0,4);
                    for (int i = 4; i < iban.length(); i++) {
                        res += "*";
                    }
                    return res;
                })
                .toList();
    }

    /**
     * 2. Класс Person имеет поля name and age. Написать метод, возвращающий общий
     *  возраст всех людей старше 17 лет. (2 способа)
     */

    public static int totalAgeOfPersonsAbove17(List<PersonNew> input) {

        return input.stream()
                .filter(personNew -> personNew.getAge() >= 17)
                .mapToInt(PersonNew::getAge)
                .sum();
    }

    /** 3. Класс Person имеет поля name and age. Написать метод, возвращающий имена тех, кто является
     *  совершеннолетним в Германии (старше 17 лет). При этом метод возвращает строку приметно такого
     *  содержания: in Germany Ivan and Petr are of legal age
     */

    public static String namesOfThoseWhoAbove17(List<PersonNew> input) {

        List<String> names = names(input);
        if (names == null || names.isEmpty()) return "in Germany nobody is of legal age";
        if (names.size() == 1) {
            return "in Germany " + names.get(0) + " is of legal age";
        }

        String res = "in Germany " + names.get(0) + " and ";
        for (int i = 1; i < names.size(); i++) {
            if (i == names.size()-1) {
                res += names.get(i) + " are of legal age";
            }
            res += names.get(i) + " and ";
        }

        return res;
    }

    public static List<String> names(List<PersonNew> input) {

        return input.stream()
                .filter(personNew -> personNew.getAge() >= 17)
                .map(PersonNew::getName)
                .toList();
    }
}

@AllArgsConstructor
@Getter
class BankAccountNew {
    private String IBAN;
}
@AllArgsConstructor
@Getter
class PersonNew {
    private String name;
    private int age;
    private List<BankAccountNew> bankAccounts;
}
