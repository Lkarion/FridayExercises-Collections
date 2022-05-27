package lists_20_05_2022;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NameNumberOccurrenceTest {

    List<String> list;

    @Test
    void nameByNumberOccurrence_1() {
        list = new ArrayList<>(Arrays.asList(new String[]{"a","b","c"}));

        assertEquals(1, NameNumberOccurrence.nameByNumberOccurrence(list,"a"));
    }
    @Test
    void nameByNumberOccurrence_2() {
        list = new ArrayList<>(Arrays.asList(new String[]{"a","a","c"}));

        assertEquals(2, NameNumberOccurrence.nameByNumberOccurrence(list,"a"));
    }
    @Test
    void nameByNumberOccurrence_0() {
        list = new ArrayList<>(Arrays.asList(new String[]{"a","b","c"}));

        assertEquals(0, NameNumberOccurrence.nameByNumberOccurrence(list,"Vasya"));
    }
    @Test
    void nameByNumberOccurrence_EmptyList() {
        list = new ArrayList<>(Arrays.asList());

        assertEquals(0, NameNumberOccurrence.nameByNumberOccurrence(list,"Vasya"));
    }
    @Test
    void nameByNumberOccurrence_NullName() {
        list = new ArrayList<>(Arrays.asList());

        assertEquals(0, NameNumberOccurrence.nameByNumberOccurrence(list,null));
    }
    @Test
    void nameByNumberOccurrence_NullList() {
        list = null;

        assertEquals(0, NameNumberOccurrence.nameByNumberOccurrence(list,"a"));
    }
}