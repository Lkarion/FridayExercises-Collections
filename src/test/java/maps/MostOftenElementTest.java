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

    @BeforeEach
    void init(){
        listGiven = new ArrayList<>();
    }

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