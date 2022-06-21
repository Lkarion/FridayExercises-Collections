package lambdas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HW_20_06_2022Test {

    @Test
    void getMap_String() {
        List<String> input = new ArrayList<>(List.of("hi", "hi", "hello"));
        Map<String, Integer> mapExp = new HashMap<>();
        mapExp.put("hi",2);
        mapExp.put("hello",1);

        assertEquals(mapExp, HW_20_06_2022.getMap(input));
    }
    @Test
    void getMap_NullList() {
        List<String> input = null;
        Map<String, Integer> mapExp = new HashMap<>();

        assertEquals(mapExp, HW_20_06_2022.getMap(input));
    }
    @Test
    void getMap_ListIsEmpty() {
        List<String> input = new ArrayList<>();
        Map<String, Integer> mapExp = new HashMap<>();

        assertEquals(mapExp, HW_20_06_2022.getMap(input));
    }
    /*@Test
    void getMap_NullElement() {
        List<String> input = new ArrayList<>(List.of("hi", null, "hello"));
        Map<String, Integer> mapExp = new HashMap<>();
        mapExp.put("hi",1);
        mapExp.put(null,1);
        mapExp.put("hello",1);

        assertThrows(NullPointerException.class, () -> HW_20_06_2022.getMap(input));
    }*/
    @Test
    void getMap_AllElementsSame() {
        List<String> input = new ArrayList<>(List.of("hi", "hi", "hi"));
        Map<String, Integer> mapExp = new HashMap<>();
        mapExp.put("hi",3);

        assertEquals(mapExp, HW_20_06_2022.getMap(input));
    }
    @Test
    void getMap_Double() {
        List<Double> input = new ArrayList<>(List.of(67.0, 54.7, 4.9, 4.9));
        Map<Double, Integer> mapExp = new HashMap<>();
        mapExp.put(67.0,1);
        mapExp.put(54.7,1);
        mapExp.put(4.9,2);

        assertEquals(mapExp, HW_20_06_2022.getMap(input));
    }
}