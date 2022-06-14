package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HW_14_06_2022Test {
    List<Integer> inputInt;
    List<Integer> outputInt;
    List<String> inputStr;
    List<String> outputStr;
    HW_14_06_2022<Integer> objInt = new HW_14_06_2022<>();
    HW_14_06_2022<String> objStr = new HW_14_06_2022<>();

    @BeforeEach
    void init(){
        inputInt = new ArrayList<>();
        outputInt = new ArrayList<>();
        inputStr = new ArrayList<>();
        outputStr = new ArrayList<>();
    }

    @Test
    void removeDuplicates_Integer_DuplicatesNormalCase() {
        inputInt.addAll(Arrays.asList(1,3,2,2,4,1));
        outputInt.addAll(Arrays.asList(1,2,3,4));

        assertEquals(outputInt, objInt.removeDuplicates(inputInt));
    }
    @Test
    void removeDuplicates_Integer_AllElementsAreSame() {
        inputInt.addAll(Arrays.asList(2,2,2));
        outputInt.add(2);

        assertEquals(outputInt, objInt.removeDuplicates(inputInt));
    }
    @Test
    void removeDuplicates_Integer_NullList() {
        assertEquals(outputInt, objInt.removeDuplicates(null));
    }


    @Test
    void removeDuplicates_Strings_DuplicatesNormalCase() {
        inputStr.addAll(Arrays.asList("hi","by","hi","hi again"));
        outputStr.addAll(Arrays.asList("hi","by","hi again"));

        assertEquals(outputStr, objStr.removeDuplicates(inputStr));
    }
    @Test
    void removeDuplicates_String_NullElement() {
        inputStr.addAll(Arrays.asList("hi",null,"hi","hi again"));
        outputStr.addAll(Arrays.asList(null,"hi","hi again"));

        assertEquals(outputStr, objStr.removeDuplicates(inputStr));
    }
    @Test
    void removeDuplicates_String_2NullElements() {
        inputStr.addAll(Arrays.asList("hi",null,"hi",null,"hi again"));
        outputStr.addAll(Arrays.asList(null,"hi","hi again"));

        assertEquals(outputStr, objStr.removeDuplicates(inputStr));
    }


    /**
     * ********************  List  ****************************
     */
    @Test
    void removeDuplicatesKeepingOrder_List(){
        inputInt.addAll(Arrays.asList(1,3,2,2,4,1));
        outputInt.addAll(Arrays.asList(1,3,2,4));

        assertEquals(outputInt, objInt.removeDuplicatesKeepingOrder_List(inputInt));
    }
    /**
     * ********************  Stream  ****************************
     */
    @Test
    void removeDuplicatesKeepingOrder_Stream(){
        inputInt.addAll(Arrays.asList(1,3,2,2,4,1));
        outputInt.addAll(Arrays.asList(1,3,2,4));

        assertEquals(outputInt, objInt.removeDuplicatesKeepingOrder_Stream(inputInt));
    }
}