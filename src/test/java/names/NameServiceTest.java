package names;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceTest {

    List<String> list = new LinkedList<>();
    List<String> listRes = new LinkedList<>();
    List<String> listExp = new LinkedList<>();


    @Test
    void getNamesNot4_NoSuchNames() {
        list.add("Maria");
        list.add("Ian");
        list.add("Claudia");

        listRes = NameService.getNamesNot4(list);

        listExp.add("Maria");
        listExp.add("Ian");
        listExp.add("Claudia");

        assertEquals(listExp, listRes);
    }
    @Test
    void getNamesNot4_NormalCase() {
        list.add("Maria");
        list.add("Ivan");
        list.add("Claudia");

        listRes = NameService.getNamesNot4(list);

        listExp.add("Maria");
        listExp.add("Claudia");

        assertEquals(listExp, listRes);
    }
    @Test
    void getNamesNot4_AllNames4() {
        list.add("Mary");
        list.add("Ivan");
        list.add("Karl");

        listRes = NameService.getNamesNot4(list);

        assertEquals(listExp, listRes);
    }
}