package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetGetDuplicatesTest {

    List<String> givenList;
    List<String> expList;

    @BeforeEach
    void init(){
        givenList = new ArrayList<>();
        expList = new ArrayList<>();
    }

    @Test
    void getDuplicates_Normal() {
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna","Maria","Ivan"}));
        expList.addAll(Arrays.asList(new String[]{"Maria","Ivan"}));

        assertEquals(expList, SetGetDuplicates.getDuplicates(givenList));
    }
    @Test
    void getDuplicates_NoDuplicates() {
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));

        assertEquals(expList, SetGetDuplicates.getDuplicates(givenList));
    }
    @Test
    void getDuplicates_3Duplicates() {
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Ivan","Ivan"}));
        expList.addAll(Arrays.asList(new String[]{"Ivan"}));

        assertEquals(expList, SetGetDuplicates.getDuplicates(givenList));
    }
    @Test
    void getDuplicates_EmptyGivenList() {
        assertEquals(expList, SetGetDuplicates.getDuplicates(givenList));
    }
}