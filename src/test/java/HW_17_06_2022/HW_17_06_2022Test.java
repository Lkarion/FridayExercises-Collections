package HW_17_06_2022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HW_17_06_2022Test {

    HW_17_06_2022.Address a1 = new HW_17_06_2022.Address("12345", "Moscow", "MoscowStr", "123");
    HW_17_06_2022.Person p1 = new HW_17_06_2022.Person("Ivan", "Ivanov", "ivan@web.de", "0123456", a1);
    HW_17_06_2022.Address a2 = new HW_17_06_2022.Address("56758", "Berlin", "QwetyStr", "43");
    HW_17_06_2022.Person p2 = new HW_17_06_2022.Person("Zigmund", "Zigmundov", "zigmund@web.de", "123421233", a2);
    HW_17_06_2022.Address a3 = new HW_17_06_2022.Address("2331", "NY", "NYStr", "52");
    HW_17_06_2022.Person p3 = new HW_17_06_2022.Person("Mike", "Mikeson", "mik@web.de", "8198378", a3);
    HW_17_06_2022.Address a4 = new HW_17_06_2022.Address("54223", "Paris", "ParisStr", "2");
    HW_17_06_2022.Person p4 = new HW_17_06_2022.Person("Amelie", "Joujou", "jou@web.de", "5432167", a4);

    List<HW_17_06_2022.Person> personList;
    List<String> listStringExpected;
    List<HW_17_06_2022.Address> listAddressExpected;

    @BeforeEach
    void init(){
        personList = new ArrayList<>(List.of(p1, p2, p3, p4));
        listStringExpected = new ArrayList<>();
        listAddressExpected = new ArrayList<>();
    }


    // get list of names
    @Test
    void getListOfSmthFromPerson_Names() {
        listStringExpected.add(p1.fName.concat(" "+ p1.lName));
        listStringExpected.add(p2.fName.concat(" "+ p2.lName));
        listStringExpected.add(p3.fName.concat(" "+ p3.lName));
        listStringExpected.add(p4.fName.concat(" "+ p4.lName));
        HW_17_06_2022.PersonServable psNames = person -> person.fName.concat(" "+ person.lName);
        assertEquals(listStringExpected, HW_17_06_2022.getListOfSmthFromPerson(personList, psNames));
    }

    // get list of e-mails
    @Test
    void getListOfSmthFromPerson_EMails() {
        listStringExpected.add(p1.email);
        listStringExpected.add(p2.email);
        listStringExpected.add(p3.email);
        listStringExpected.add(p4.email);
        HW_17_06_2022.PersonServable psEMails = person -> person.email;
        assertEquals(listStringExpected, HW_17_06_2022.getListOfSmthFromPerson(personList, psEMails));
    }


    // get list of phones
    @Test
    void getListOfSmthFromPerson_Phones() {
        listStringExpected.add(p1.phone);
        listStringExpected.add(p2.phone);
        listStringExpected.add(p3.phone);
        listStringExpected.add(p4.phone);
        HW_17_06_2022.PersonServable psPhones = person -> person.phone;
        assertEquals(listStringExpected, HW_17_06_2022.getListOfSmthFromPerson(personList, psPhones));
    }
    // get list of Addresses
    @Test
    void getListOfSmthFromPerson_Addresses() {
        listAddressExpected.add(p1.address);
        listAddressExpected.add(p2.address);
        listAddressExpected.add(p3.address);
        listAddressExpected.add(p4.address);
        HW_17_06_2022.PersonServable psAddresses = person -> person.address;
        assertEquals(listAddressExpected, HW_17_06_2022.getListOfSmthFromPerson(personList, psAddresses));
    }




















    @Test
    void getListOfSmthFromSomewhere() {
    }

    // get list of names
    @Test
    void getListOfSmthFromSomewhere_Names() {
        listStringExpected.add(p1.fName.concat(" "+ p1.lName));
        listStringExpected.add(p2.fName.concat(" "+ p2.lName));
        listStringExpected.add(p3.fName.concat(" "+ p3.lName));
        listStringExpected.add(p4.fName.concat(" "+ p4.lName));
        HW_17_06_2022.Servable<String, HW_17_06_2022.Person> sNames = person -> person.fName.concat(" "+ person.lName);
        assertEquals(listStringExpected, HW_17_06_2022.getListOfSmthFromSomewhere(personList, sNames));
    }

    // get list of e-mails
    @Test
    void getListOfSmthFromSomewhere_EMails() {
        listStringExpected.add(p1.email);
        listStringExpected.add(p2.email);
        listStringExpected.add(p3.email);
        listStringExpected.add(p4.email);
        HW_17_06_2022.Servable<String, HW_17_06_2022.Person> sEMails = person -> person.email;
        assertEquals(listStringExpected, HW_17_06_2022.getListOfSmthFromSomewhere(personList, sEMails));
    }


    // get list of phones
    @Test
    void getListOfSmthFromSomewhere_Phones() {
        listStringExpected.add(p1.phone);
        listStringExpected.add(p2.phone);
        listStringExpected.add(p3.phone);
        listStringExpected.add(p4.phone);
        HW_17_06_2022.Servable<String, HW_17_06_2022.Person> sPhones = person -> person.phone;
        assertEquals(listStringExpected, HW_17_06_2022.getListOfSmthFromSomewhere(personList, sPhones));
    }
    // get list of Addresses
    @Test
    void getListOfSmthFromSomewhere_Addresses() {
        listAddressExpected.add(p1.address);
        listAddressExpected.add(p2.address);
        listAddressExpected.add(p3.address);
        listAddressExpected.add(p4.address);
        HW_17_06_2022.Servable<HW_17_06_2022.Address, HW_17_06_2022.Person> sAddresses = person -> person.address;
        assertEquals(listAddressExpected, HW_17_06_2022.getListOfSmthFromSomewhere(personList, sAddresses));
    }

    // get string from int
    @Test
    void getListOfSmthFromSomewhere_StrFromInt() {
        List<Integer> expected = new ArrayList<>(List.of(3,2,5));
        listStringExpected.addAll(List.of("qwe", "hi", "hello"));
        HW_17_06_2022.Servable<Integer, String> strToIntLengths = s -> s.length();
        assertEquals(expected, HW_17_06_2022.getListOfSmthFromSomewhere(listStringExpected, strToIntLengths));
    }

}