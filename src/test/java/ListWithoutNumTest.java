import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListWithoutNumTest {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> resList = new ArrayList<>();
    List<Integer> expList = new ArrayList<>();

    @Test
    void getListWithoutNum() {
        l1.add(4);
        l1.add(0);
        l1.add(1);
        int n = 2;

        resList = ListWithoutNum.getListWithoutNum(l1, n);
        expList.add(0);
        expList.add(1);

        assertEquals(expList, resList);
    }
}