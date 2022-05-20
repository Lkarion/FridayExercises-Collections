package lists_20_05_2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    List<Integer> actual = new ArrayList<>();

    @Test
    void ListWithEqualsSum(){
        actual.addAll(List.of(3,2,1,4,1));
        assertEquals(2, ListWithEqualSum.getIndexEqualSum(actual));
    }

    @Test
    void ListWithEqualsSum_NoSuchIndex(){
        actual.addAll(List.of(3,2,1,1,4,1));
        assertEquals(-1, ListWithEqualSum.getIndexEqualSum(actual));
    }


}