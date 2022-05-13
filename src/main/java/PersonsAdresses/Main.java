package PersonsAdresses;

import java.util.LinkedList;
import java.util.List;

public class Main {
    //1.Есть два класса: PersonsAdresses.Address  с полями улица и номер дома  и PersonsAdresses.Person с полями
    // имя  и Persons Adresses.Address. Нужно написать метод, который по списку persons  возвращает
    // список их адресов

    public static void main(String[] args) {
        Person p1 = new Person("Peter", new Address("Frunze", 120));
        Person p2 = new Person("Vasya", new Address("Landstrasse", 10));
        Person p3 = new Person("Maria", new Address("Kalka", 45));
        Person p4 = new Person("Ivan", new Address("Allee", 25));
        Person p5 = new Person("Karl", new Address("Mikale", 65));
        Person p6 = new Person("Mike", new Address("Pushkina", 253));

        List<Person> listP = new LinkedList<>();
        listP.add(p1);
        listP.add(p2);
        listP.add(p3);
        listP.add(p4);
        listP.add(p5);
        listP.add(p6);

        List<Address> listAddress = new LinkedList<>();
        listAddress = AddressListGetter.getAddressList(listP);

        listAddress.forEach(a -> System.out.println(a));
    }
}
