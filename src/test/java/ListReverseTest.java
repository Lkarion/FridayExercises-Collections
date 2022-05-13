import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListReverseTest {

    List<Integer> l1 = new ArrayList<>();
    List<Integer> resList = new ArrayList<>();
    List<Integer> expList = new ArrayList<>();

    @Test
    void getReversedList() {
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);

        resList = ListReverse.getReversedList(l1);

        expList.add(4);
        expList.add(3);
        expList.add(2);
        expList.add(1);

        assertEquals(expList, resList);
    }

    @Test
    void getReversedList_SameNumbers() {
        l1.add(1);
        l1.add(1);

        resList = ListReverse.getReversedList(l1);

        expList.add(1);
        expList.add(1);

        assertEquals(expList, resList);
    }


}