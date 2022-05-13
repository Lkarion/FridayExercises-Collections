import PersonsAdresses.Address;
import PersonsAdresses.AddressListGetter;
import PersonsAdresses.Person;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    Address a1 = new Address("Frunze", 120);
    Address a2 = new Address("Landstrasse", 10);
    Address a3 = new Address("Kalka", 45);
    Address a4 = new Address("Allee", 25);
    Address a5 = new Address("Mikale", 65);
    Address a6 = new Address("Pushkina", 253);


    Person p1 = new Person("Peter", a1);
    Person p2 = new Person("Vasya", a2);
    Person p3 = new Person("Maria", a3);
    Person p4 = new Person("Ivan", a4);
    Person p5 = new Person("Karl", a5);
    Person p6 = new Person("Mike", a6);

    List<Person> listP = new LinkedList<>();
    List<Address> listAddress = new LinkedList<>();
    List<Address> listExp = new LinkedList<>();

    @Test
    void test_AddressListGetter_EmptyList(){
        listAddress = AddressListGetter.getAddressList(listP);

        assertEquals(listExp, listAddress);
    }
    @Test
    void test_AddressListGetter(){
        listP.add(p1);
        listP.add(p2);
        listP.add(p3);

        listAddress = AddressListGetter.getAddressList(listP);

        listExp.add(a1);
        listExp.add(a2);
        listExp.add(a3);

        assertEquals(listExp, listAddress);
    }

}