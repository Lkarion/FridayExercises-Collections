import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListStringServiceTest {

    List<String> list = new ArrayList<>();
    String res;
    String exp;

    @Test
    void getShortestOrLongestString() {
        list.add("aaa");
        list.add("cccc");
        res = "aaa";
        exp = ListStringService.getShortestOrLongestString(list);

        assertEquals(exp, res);
    }
    @Test
    void getShortestOrLongestString_SameLength() {
        list.add("aaa");
        list.add("ccc");
        res = "aaa";
        exp = ListStringService.getShortestOrLongestString(list);

        assertEquals(exp, res);
    }
    @Test
    void getShortestOrLongestString_EmptyList() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ListStringService.getShortestOrLongestString(list);
        });
    }
}