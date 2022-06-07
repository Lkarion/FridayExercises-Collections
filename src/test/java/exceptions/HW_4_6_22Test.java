package exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HW_4_6_22Test {
    List<String> listGiven;
    Map<Integer,String> mapExp;
    Map<HW_4_6_22.Person, List<Long>> mapGiven;

    @BeforeEach
    void init(){
        listGiven = new ArrayList<>();
        mapExp = new HashMap<>();
        mapGiven = new HashMap<>();
    }


    // 1.
    @Test
    void getErrors_NoErrors() {
        listGiven.addAll(List.of("3","4"));
        assertEquals(mapExp, HW_4_6_22.getErrors(listGiven));
    }
    @Test
    void getErrors_WithError() {
        listGiven.addAll(List.of("3","4","o"));
        mapExp.put(2,"o");
        assertEquals(mapExp, HW_4_6_22.getErrors(listGiven));
    }
    @Test
    void getErrors_AllErrors() {
        listGiven.addAll(List.of("d","w"));
        mapExp.put(0,"d");
        mapExp.put(1,"w");
        assertEquals(mapExp, HW_4_6_22.getErrors(listGiven));
    }
    @Test
    void getErrors_EmptyList() {
        assertEquals(mapExp, HW_4_6_22.getErrors(listGiven));
    }
    @Test
    void getErrors_NullList() {
        assertEquals(mapExp, HW_4_6_22.getErrors(null));
    }
    @Test
    void getErrors_NullValues() {
        listGiven.add("d");
        listGiven.add(null);
        listGiven.add("1");

        mapExp.put(0,"d");
        mapExp.put(1,null);

        assertEquals(mapExp, HW_4_6_22.getErrors(listGiven));
    }







    // 2.
    @Test
    void checkUser_Normal() throws Exception {
        String str = "John;Lennon;40;lennon@mail.com";
        HW_4_6_22.User userExpected = new HW_4_6_22.User("John","Lennon",40,"lennon@mail.com");

        assertEquals(userExpected,new HW_4_6_22.User(str));
    }
    @Test
    void checkUser_ThrowsException(){
        String str = "John;40;";

        assertThrows(Exception.class, () -> new HW_4_6_22.User(str));
    }
    @Test
    void checkUser_ErrorsList_NoName(){
        String str = "John;;40;lennon@mail.com";
        List<String> errors = new ArrayList<>(List.of("Одно из полей не задано (пустое)"));

        assertEquals(errors, HW_4_6_22.checkUser(str));
    }
    @Test
    void checkUser_ErrorsList_Age() {
        String str = "John;Lennon;4oo;lennon@mail.com";
        List<String> errors = new ArrayList<>(List.of("Поле возраст некорректно 4oo"));

        assertEquals(errors, HW_4_6_22.checkUser(str));
    }
    @Test
    void checkUser_ErrorsList_NoEmail() {
        String str = "John;Lennon;40;";
        List<String> errors = new ArrayList<>(List.of("Некорректный формат строки. В строке не хватает данных"));

        assertEquals(errors, HW_4_6_22.checkUser(str));
    }
    @Test
    void checkUser_ErrorsList_WrongEmail() {
        String str = "John;Lennon;40;laj@sd";
        List<String> errors = new ArrayList<>(List.of("email имеет неправильный формат: laj@sd"));

        assertEquals(errors, HW_4_6_22.checkUser(str));
    }
    @Test
    void checkUser_ErrorsList_MoreData() {
        String str = "John;Lennon;40;lennon@mail.com;ExtraData";
        List<String> errors = new ArrayList<>(List.of("В строке больше полей, чем необходимо"));

        assertEquals(errors, HW_4_6_22.checkUser(str));
    }
    @Test
    void checkUser_ErrorsList_2Errors() {
        String str = "John;;4oo;lennon@mail.com";
        List<String> errors = new ArrayList<>(List.of("Одно из полей не задано (пустое)", "Поле возраст некорректно 4oo"));

        assertEquals(errors, HW_4_6_22.checkUser(str));
    }







    // 3.
    @Test
    void findPerson() {
        HW_4_6_22.Person p1 = new HW_4_6_22.Person(123,"Karl");
        mapGiven.put(p1, new ArrayList<>(List.of(1245L)));
        assertEquals(p1, HW_4_6_22.findPerson(mapGiven));
    }
    @Test
    void findPerson_Exception() {
        HW_4_6_22.Person p1 = new HW_4_6_22.Person(123,"Karl");
        mapGiven.put(p1, new ArrayList<>(List.of(1245L,4L)));
        assertThrows(NoSuchElementException.class, () -> HW_4_6_22.findPerson(mapGiven));
    }
}