package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FrEx_01_07_2022 {

    /**
     * 1.есть Класс Address с полями street and houseNumber и класс Person c полями name, age
     * and Address. Написать метод, возвращающий адреса тех кто старше 17 лет
     * List<Address> addMoreThanSeventeen(List<Person>input)
     * @param input
     * @return
     */
    public static List<Address> addMoreThanSeventeen(List<Person> input) {

        return input.stream()
                .filter(p -> p.age > 17)
                .map(person -> person.address)
                .toList();
    }

    /**
     * 2. Написать метод, возвращающий список имен без дупликатов двумя способами:
     * в Set и в List-е
     * @param input
     * @return
     */
    public static Set<String> getNamesWithoutDuplicatesToSet(List<Person> input) {

        return input.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet());
    }
    public static List<String> getNamesWithoutDuplicatesToList(List<Person> input) {

        return input.stream()
                .map(person -> person.name)
                .distinct()
                .toList();
    }

    /**
     * 3. Есть лист Persons из первой задачи. Написать метод, возвращающий map, где возраст это ключ,
     * а список персонов - значение
     * @param input
     * @return
     */
    public static Map<Integer, List<Person>> getMapByAge(List<Person> input) {

        return input.stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }

    /**
     * 4. Есть класс Customer с полем имя и класс BankAccount c полями IBAN and Customer.
     * Написать метод, возвращающий мапу, где customer это ключ, а список его счетов value
     * public static Map<Customer,List<BankAccount>mapAccountsByCustomer(List <BankAccount>input)
     *  Ivanov=[Account{IBAN="DE123455",owner=Ivanov, BankAccount{IBAN="DE456767_owner=Ivanov], Sidorov
     */

    public static Map<Customer, List<BankAccount>> mapAccountsByCustomer(List<BankAccount> input) {

        return input.stream()
                .collect(Collectors.groupingBy(BankAccount::getCustomer));
    }

    /**
     * 5. написать метод, возвращающий список IBANNs из класса BankAccount где после третьего символа стоят звездочки
     *   List<String> listOfAccountsWithStars(List<BankAccount>input)
     * @param input
     * @return
     */
    public static List<String> listOfAccountsWithStars(List<BankAccount> input) {

        return input.stream()
                .map(bankAccount -> bankAccount.getIBAN())
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
     * 6. Метод принимает строку состоящую из слов , разделенных пробелом и букву.
     * Возвращает количество слов, начинающихся с этой буквы
     *  public static long numberOfWords(String input, String w)
     * @param input
     * @return
     */
    public static long numberOfWords(String input, String w) {

        String[] words = input.split(" ");
        return Arrays.stream(words)
                .filter(word -> word.startsWith(w))
                .count();
    }

    /**
     * 7. Метод проверяет, является ли строка числом
     *  *  public static boolean isNumber(String input)
     * @param input
     * @return
     */
    public static boolean isNumber(String input) {

        return input.chars()
                .allMatch(i -> Character.isDigit(i));
    }



}

class Address {
    String street;
    String houseNumber;

    public Address(String street, String houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}

class Person {
    String name;
    int age;
    Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}

class Customer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BankAccount {
    String IBAN;
    Customer customer;

    public BankAccount(String IBAN, Customer customer) {
        this.IBAN = IBAN;
        this.customer = customer;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Customer getCustomer() {
        return customer;
    }
}