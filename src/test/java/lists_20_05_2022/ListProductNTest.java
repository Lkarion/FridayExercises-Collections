package lists_20_05_2022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ListProductNTest {

    List<Integer> listGiven;

    @BeforeEach
    void init(){
        listGiven = new ArrayList<>();
    }

    @Test
    void containsProductDequeue_ProductExists() {
        listGiven.addAll(List.of(5,4,6));
        assertTrue(ListProductN.containsProductDequeue(listGiven,20));
    }
    @Test
    void containsProductDequeue_NoProduct() {
        listGiven.addAll(List.of(5,4,6));
        assertFalse(ListProductN.containsProductDequeue(listGiven,1));
    }
    @Test
    void containsProductDequeue_NoProduct_1Element() {
        listGiven.addAll(List.of(5));
        assertFalse(ListProductN.containsProductDequeue(listGiven,1));
    }
    @Test
    void containsProductDequeue_NoProduct_EmptyList() {
        assertFalse(ListProductN.containsProductDequeue(listGiven,1));
    }



    @Test
    void containsProduct_ProductExists() {
        listGiven.addAll(List.of(5,4,6));
        assertTrue(ListProductN.containsProduct(listGiven,20));
    }
    @Test
    void containsProduct_NoProduct() {
        listGiven.addAll(List.of(5,4,6));
        assertFalse(ListProductN.containsProduct(listGiven,1));
    }
    @Test
    void containsProduct_NoProduct_1Element() {
        listGiven.addAll(List.of(5));
        assertFalse(ListProductN.containsProduct(listGiven,1));
    }
    @Test
    void containsProduct_NoProduct_EmptyList() {
        assertFalse(ListProductN.containsProduct(listGiven,1));
    }

}