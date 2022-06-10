package maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StringTreeMapTaskTest {
    TreeMap<Character, TreeSet<String>> mapExp;
    List<String> listGiven;

    @BeforeEach
    void init(){
        mapExp = new TreeMap<>();
        listGiven = new ArrayList<>();
    }

    @Test
    void getTreeMap() {
        listGiven.addAll(Arrays.asList("hello","world","hell"));
        mapExp.put('h', new TreeSet<>(List.of("hello","hell")));
        mapExp.put('w', new TreeSet<>(List.of("world")));

        assertEquals(mapExp, StringTreeMapTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_1Element() {
        listGiven.addAll(Arrays.asList("hello"));
        mapExp.put('h', new TreeSet<>(List.of("hello")));

        assertEquals(mapExp, StringTreeMapTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_2SameElements() {
        listGiven.addAll(Arrays.asList("hello","hello"));
        mapExp.put('h', new TreeSet<>(List.of("hello","hello")));

        assertEquals(mapExp, StringTreeMapTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_EmptyListGiven() {
        assertEquals(mapExp, StringTreeMapTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_NullListGiven() {
        assertEquals(mapExp, StringTreeMapTask.getTreeMap(listGiven));
    }
}