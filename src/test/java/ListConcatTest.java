import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListConcatTest {

    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    List<Integer> resList = new ArrayList<>();
    List<Integer> expList = new ArrayList<>();

    @Test
    void getConcatList() {
        l1.add(1);
        l1.add(2);
        l2.add(3);
        l2.add(4);

        resList = ListConcat.getConcatList(l1,l2);

        expList.add(1);
        expList.add(2);
        expList.add(3);
        expList.add(4);

        assertEquals(expList, resList);
    }

}