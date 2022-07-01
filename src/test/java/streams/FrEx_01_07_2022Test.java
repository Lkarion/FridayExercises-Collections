package streams;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FrEx_01_07_2022Test {


    /**
     * 1.
     */
    @Test
    void addMoreThanSeventeen() {

        Address a1 = new Address("sjkdfb", "126h");
        Address a2 = new Address("sd", "sue22");
        Address a3 = new Address("ertotws", "3f4");
        Person p1 = new Person("Karl", 18, a1);
        Person p2 = new Person("Mike", 45, a2);
        Person p3 = new Person("Marina", 17, a3);
        List<Person> given = new ArrayList<>(List.of(p1, p2, p3));
        List<Address> exp = new ArrayList<>(List.of(a1, a2));

        assertEquals(exp, FrEx_01_07_2022.addMoreThanSeventeen(given));
    }

    /**
     * 2.
     */
    @Test
    void getNamesWithoutDuplicatesToSet() {
        Address a1 = new Address("sjkdfb", "126h");
        Address a2 = new Address("sd", "sue22");
        Address a3 = new Address("dflbg", "325");
        Person p1 = new Person("Karl", 17, a1);
        Person p2 = new Person("Mike", 45, a2);
        Person p3 = new Person("Marina", 17, a3);
        Person p4 = new Person("Karl", 17, a3);
        List<Person> given = new ArrayList<>(List.of(p1, p2, p3, p4));
        Set<String> exp = new HashSet<>(List.of("Karl", "Mike", "Marina"));

        assertEquals(exp, FrEx_01_07_2022.getNamesWithoutDuplicatesToSet(given));
    }

    @Test
    void getNamesWithoutDuplicatesToList() {
        Address a1 = new Address("sjkdfb", "126h");
        Address a2 = new Address("sd", "sue22");
        Address a3 = new Address("dflbg", "325");
        Person p1 = new Person("Karl", 17, a1);
        Person p2 = new Person("Mike", 45, a2);
        Person p3 = new Person("Marina", 17, a3);
        Person p4 = new Person("Karl", 17, a3);
        List<Person> given = new ArrayList<>(List.of(p1, p2, p3, p4));
        List<String> exp = new ArrayList<>(List.of("Karl", "Mike", "Marina"));

        assertEquals(exp, FrEx_01_07_2022.getNamesWithoutDuplicatesToList(given));
    }

    /**
     * 3.
     */
    @Test
    void getMapByAge() {

        Address a1 = new Address("sjkdfb", "126h");
        Address a2 = new Address("sd", "sue22");
        Person p1 = new Person("Karl", 17, a1);
        Person p2 = new Person("Mike", 45, a2);
        Person p3 = new Person("Marina", 17, a1);
        List<Person> given = new ArrayList<>(List.of(p1, p2, p3));
        Map<Integer, List<Person>> exp = new HashMap<>();
        exp.put(17, new ArrayList<>(List.of(p1, p3)));
        exp.put(45, new ArrayList<>(List.of(p2)));

        assertEquals(exp, FrEx_01_07_2022.getMapByAge(given));
    }

    /**
     * 4.
     */
    @Test
    void getAccounts_Normal() {

        Customer c1 = new Customer("Karl");
        Customer c2 = new Customer("Mike");
        BankAccount ba1 = new BankAccount("123451782L", c1);
        BankAccount ba2 = new BankAccount("424353256L", c2);
        BankAccount ba3 = new BankAccount("995540L", c1);
        List<BankAccount> given = new ArrayList<>(List.of(ba1, ba2, ba3));
        Map<Customer, List<BankAccount>> exp = new HashMap<>();
        exp.put(c1, new ArrayList<>(List.of(ba1, ba3)));
        exp.put(c2, new ArrayList<>(List.of(ba2)));

        assertEquals(exp, FrEx_01_07_2022.mapAccountsByCustomer(given));
    }

    /**
     * 5.
     */
    @Test
    void listOfAccountsWithStars() {

        Customer c1 = new Customer("Karl");
        Customer c2 = new Customer("Mike");
        BankAccount ba1 = new BankAccount("123451782L", c1);
        BankAccount ba2 = new BankAccount("424353256L", c2);
        BankAccount ba3 = new BankAccount("995540L", c1);
        List<BankAccount> given = new ArrayList<>(List.of(ba1, ba2, ba3));
        List<String> exp = new ArrayList<>(List.of("1234******", "4243******", "9955***"));

        assertEquals(exp, FrEx_01_07_2022.listOfAccountsWithStars(given));
    }

    /**
     * 6.
     */
    @Test
    void numberOfWords_Normal() {

        String given = "sdkjf1 qwg saufq iwql dfso sdf";

        assertEquals(3L, FrEx_01_07_2022.numberOfWords(given, "s"));
    }
    @Test
    void numberOfWords_Zero() {

        String given = "sdkjf1 qwg saufq iwql dfso sdf";

        assertEquals(0L, FrEx_01_07_2022.numberOfWords(given, "a"));
    }

    /**
     * 7.
     */
    @Test
    void isNumber_False() {
        String given = "wer4";

        assertFalse(FrEx_01_07_2022.isNumber(given));
    }
    @Test
    void isNumber_True() {
        String given = "24564";

        assertTrue(FrEx_01_07_2022.isNumber(given));
    }
}