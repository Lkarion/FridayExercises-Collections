package maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MostOftenElementTest {

    List<Integer> listGiven;
    List<String> listStrGiven;
    List<String> listStrExp;

    @BeforeEach
    void init(){
        listGiven = new ArrayList<>();
        listStrGiven = new ArrayList<>();
        listStrExp = new ArrayList<>();
    }

    // 3.
    @Test
    void anagramList_EmptyName() {
        listStrGiven.add("Ivan");
        assertEquals(listStrExp, MostOftenElement.anagramList("", listStrGiven));
    }
    @Test
    void anagramList_NullName() {
        listStrGiven.add("Ivan");
        assertEquals(listStrExp, MostOftenElement.anagramList(null, listStrGiven));
    }
    @Test
    void anagramList_EmptyList() {
        assertEquals(listStrExp, MostOftenElement.anagramList("Ivan", listStrGiven));
    }
    @Test
    void anagramList_NullList() {
        assertEquals(listStrExp, MostOftenElement.anagramList("Ivan", null));
    }
    @Test
    void anagramList_1Anagram() {
        listStrGiven.add("Ivan");
        listStrExp.add("Ivan");
        assertEquals(listStrExp, MostOftenElement.anagramList("Ivan", listStrGiven));
    }
    @Test
    void anagramList_NoAnagram() {
        listStrGiven.add("Karl");
        listStrGiven.add("Maria");
        assertEquals(listStrExp, MostOftenElement.anagramList("Ivan", listStrGiven));
    }
    @Test
    void anagramList_AllAreAnagrams() {
        listStrGiven.add("Karl");
        listStrGiven.add("Klar");
        listStrGiven.add("rakl");

        listStrExp.add("Karl");
        listStrExp.add("Klar");
        listStrExp.add("rakl");
        assertEquals(listStrExp, MostOftenElement.anagramList("Karl", listStrGiven));
    }

    // 1.
    @Test
    void findMaxOccuredElt_1Elem() {
        listGiven.add(1);
        assertEquals(1, MostOftenElement.findMaxOccuredElt(listGiven));
    }
    @Test
    void findMaxOccuredElt_2DifferentElements() {
        listGiven.add(1);
        listGiven.add(2);
        assertEquals(1, MostOftenElement.findMaxOccuredElt(listGiven));
    }
    @Test
    void findMaxOccuredElt_SameElements() {
        listGiven.add(1);
        listGiven.add(1);
        assertEquals(1, MostOftenElement.findMaxOccuredElt(listGiven));
    }
    @Test
    void findMaxOccuredElt_NormalCase() {
        listGiven.add(1);
        listGiven.add(1);
        listGiven.add(2);
        listGiven.add(-11);
        listGiven.add(2);
        listGiven.add(2);
        assertEquals(2, MostOftenElement.findMaxOccuredElt(listGiven));
    }

    // 2.
    @Test
    void findSingleNumber_1Element() {
        listGiven.add(1);
        assertEquals(1, MostOftenElement.findSingleNumber(listGiven));
    }
    @Test
    void findSingleNumber_3SameElements() {
        listGiven.add(1);
        listGiven.add(1);
        listGiven.add(1);
        assertEquals(1, MostOftenElement.findSingleNumber(listGiven));
    }
    @Test
    void findSingleNumber_DifferentElements() {
        listGiven.add(1);
        listGiven.add(1);
        listGiven.add(2);
        listGiven.add(3);
        listGiven.add(3);
        assertEquals(2, MostOftenElement.findSingleNumber(listGiven));
    }
    @Test
    void findSingleNumber_2ElementsWithoutCouple() {
        listGiven.add(1);
        listGiven.add(1);
        listGiven.add(2);
        listGiven.add(3);
        assertEquals(3, MostOftenElement.findSingleNumber(listGiven));
    }
}