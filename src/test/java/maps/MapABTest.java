package maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapABTest {

    Map<String, String> givenMap;
    Map<String, String> expMap;

    @BeforeEach
    void init(){
        givenMap = new HashMap<>();
        expMap = new HashMap<>();
    }

    @Test
    void mapAB_withAB() {
        givenMap.put("a", "Hi");
        givenMap.put("b", "There");
        expMap.put("a", "Hi");
        expMap.put("ab", "HiThere");
        expMap.put("b", "There");

        assertEquals(expMap, MapAB.mapAB(givenMap));
    }
    @Test
    void mapAB_NoAB() {
        givenMap.put("a", "Hi");
        givenMap.put("v", "There");
        expMap.put("a", "Hi");
        expMap.put("v", "There");

        assertEquals(expMap, MapAB.mapAB(givenMap));
    }
    @Test
    void mapAB_EmptyMap() {
        assertEquals(expMap, MapAB.mapAB(givenMap));
    }
    @Test
    void mapAB_1Element() {
        givenMap.put("a", "Hi");
        expMap.put("a", "Hi");

        assertEquals(expMap, MapAB.mapAB(givenMap));
    }
}