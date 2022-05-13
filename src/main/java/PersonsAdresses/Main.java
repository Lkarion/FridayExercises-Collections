package PersonsAdresses;

import java.util.LinkedList;
import java.util.List;

public class Main {
    //1.Есть два класса: PersonsAdresses.Address  с полями улица и номер дома  и PersonsAdresses.Person с полями
    // имя  и PersonsAdresses.Address. Нужно написать метод, который по списку persons  возвращает
    // список их адресов

    //2. Есть список с именами Ivan, Maria, Stephan, John, Amalia. Написать
    // метод, возвращающий список в котором не содержатся имена исходного листа длиной 4

    //3.Есть два листа одинковой длины с числами. Написать метод, который вернет лист с элементами Yes or No
    //где значение на i-ом месте зависит от того, равны ли элемениы двух спсиков под номером i
    // {1,2,3,4} and {5,2,3,0}->{No,Yes,Yes,No}

    //4.Написать метод, реверсирующий лист целых чисел. возвращает его в обратном порядке. Можно решать любым
    // способом, какой вам нравится.
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
