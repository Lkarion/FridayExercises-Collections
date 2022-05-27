package maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MapBooleanTest {

    List<String> list;
    Map<String, Boolean> expMap;

    @BeforeEach
    void init(){
        expMap = new HashMap<>();
    }

    @Test
    void wordmultiple_AllFalse() {
        list = new ArrayList<>(Arrays.asList(new String[]{"a","b","c"}));
        expMap.put("a", false);
        expMap.put("b", false);
        expMap.put("c", false);

        assertEquals(expMap, MapBoolean.wordmultiple(list));
    }
    @Test
    void wordmultiple_AllTrue() {
        list = new ArrayList<>(Arrays.asList(new String[]{"a","b","a","c","b","c"}));
        expMap.put("a", true);
        expMap.put("b", true);
        expMap.put("c", true);

        assertEquals(expMap, MapBoolean.wordmultiple(list));
    }
    @Test
    void wordmultiple_3Occurrence() {
        list = new ArrayList<>(Arrays.asList(new String[]{"a","a","a"}));
        expMap.put("a", true);

        assertEquals(expMap, MapBoolean.wordmultiple(list));
    }

}