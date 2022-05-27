package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IntMoreHalfLengthTest {

    int[] givenArr;


    @Test
    void getDominantInt_DominantExists() {
        givenArr = new int[]{1,2,3,1,1,1};
        assertEquals(1, IntMoreHalfLength.getDominantInt(givenArr));
    }
    @Test
    void getDominantInt_NoDominant() {
        givenArr = new int[]{1,2,3};
        assertEquals(-1, IntMoreHalfLength.getDominantInt(givenArr));
    }
    @Test
    void getDominantInt_EmptyArray() {
        givenArr = new int[]{};
        assertEquals(-1, IntMoreHalfLength.getDominantInt(givenArr));
    }
    @Test
    void getDominantInt_NullArray() {
        assertEquals(-1, IntMoreHalfLength.getDominantInt(givenArr));
    }
}