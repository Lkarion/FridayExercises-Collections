package maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AutoTaskTest {
    Auto auto1 = new Auto("Volvo", "c60", 50000);
    Auto auto2 = new Auto("Mercedes", "bmers600", 60000);
    Auto auto3 = new Auto("Mercedes", "amers600", 40000);
    Auto auto4 = new Auto("Volvo", "c60", 10000);

    TreeMap<String, TreeSet<Auto>> mapExp;
    List<Auto> listGiven;
    //Mercedes - [auto3,auto2]
    //Volvo - [auto4,auto1]

    @BeforeEach
    void init(){
        mapExp = new TreeMap<>();
        listGiven = new ArrayList<>();
    }

    @Test
    void getTreeMap() {
        listGiven.addAll(Arrays.asList(auto1,auto2,auto3,auto4));
        mapExp.put("Volvo", new TreeSet<>(List.of(auto4,auto1)));
        mapExp.put("Mercedes", new TreeSet<>(List.of(auto2,auto3)));

        assertEquals(mapExp, AutoTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_1Element() {
        listGiven.addAll(Arrays.asList(auto1));
        mapExp.put("Volvo", new TreeSet<>(List.of(auto1)));

        assertEquals(mapExp, AutoTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_2SameElements() {
        listGiven.addAll(Arrays.asList(auto1,auto1));
        mapExp.put("Volvo", new TreeSet<>(List.of(auto1,auto1)));

        assertEquals(mapExp, AutoTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_EmptyListGiven() {
        assertEquals(mapExp, AutoTask.getTreeMap(listGiven));
    }
    @Test
    void getTreeMap_NullListGiven() {
        assertEquals(mapExp, AutoTask.getTreeMap(listGiven));
    }
}