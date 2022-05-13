import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersListServiceTest {

    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    List<String> resList = new ArrayList<>();
    List<String> expList = new ArrayList<>();

    //{1,2,3,4} and {5,2,3,0}->{No,Yes,Yes,No}

    @Test
    void getListYesNo_Normal() {
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);

        l2.add(5);
        l2.add(2);
        l2.add(3);
        l2.add(0);

        resList = NumbersListService.getListYesNo(l1,l2);

        expList.add("No");
        expList.add("Yes");
        expList.add("Yes");
        expList.add("No");

        assertEquals(expList, resList);
    }

    @Test
    void test_getListYesNo_EmptyLists(){
        resList = NumbersListService.getListYesNo(l1,l2);

        assertEquals(expList,resList);
    }
    @Test
    void test_getListYesNo_ListsOfDifferentSize(){
        l2.add(2);
        resList = NumbersListService.getListYesNo(l1,l2);

        assertEquals(expList,resList);
    }
}