package HW_17_06_2022;

import java.util.*;

public class HW_17_06_2022 {
    /**
     * 1) В программе задан список Person{ String fName, String lName, String email, String phone, Address address}.
     * Address{String postcode, String city, String street, String house}
     * Реализовать следующие функции:
     * -получить список всех ФИО
     * -получить список всех e-mail
     * -получить список всех телефонов
     * -получить список всех адресов в виде строки адреса
     * Естественно, все вышеперечисленные функции может и должен реализовать один метод, в который
     * в качестве параметра должен приходить список Person и реализация необходимого способа обработки.
     * Ограничения: не использовать стандартные Java интерфейсы, все необходимые классы и интерфейсы
     * описывать и реализовывать самостоятельно. Не использовать stream.
     */

    static class Person {
        String fName;
        String lName;
        String email;
        String phone;
        Address address;

        public Person(String fName, String lName, String email, String phone, Address address) {
            this.fName = fName;
            this.lName = lName;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }
    }

    static class Address {
        String postcode;
        String city;
        String street;
        String house;

        public Address(String postcode, String city, String street, String house) {
            this.postcode = postcode;
            this.city = city;
            this.street = street;
            this.house = house;
        }

        @Override
        public String toString() {
            return "{ postcode='" + postcode + '\'' +
                    ", city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    ", house='" + house + '}';
        }
    }

    interface PersonServable<T> {
        T servePerson(Person person);
    }

    public static <T> List<T> getListOfSmthFromPerson(List<Person> personList, PersonServable<T> function) {
        List<T> res = new ArrayList<>();
        personList.forEach(person -> res.add(function.servePerson(person)));

        return res;
    }



    /**
     * 2) *Решить задачу №1 в общем виде: т.е. есть список объектов типа A необходимо получить
     * список объектов типа B. Проверить, получив из листа Person лист объектов Address,
     * из листа String лист Integer с длинами строк.
     */
    interface Servable<T1, T2> {
        T1 servePerson(T2 object);
    }

    public static <T1, T2> List<T1> getListOfSmthFromSomewhere(List<T2> input, Servable<T1, T2> function) {
        List<T1> res = new ArrayList<>();
        input.forEach(o -> res.add(function.servePerson(o)));

        return res;
    }



    /**
     * 3) Реализовать обобщенный метод, который принимает любую коллекцию и возвращает максимальный элемент
     * из этой коллекции.
     */
    interface MaxGetable<T extends Collections, E> {
        E getmax(T collection);
    }
}
