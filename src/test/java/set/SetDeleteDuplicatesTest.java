package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetDeleteDuplicatesTest {
    List<String> givenList;
    List<String> expList;

    @BeforeEach
    void init(){
        givenList = new ArrayList<>();
        expList = new ArrayList<>();
    }

    @Test
    void removeDuplicates_Normal(){
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna","Maria","Ivan"}));
        expList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));

        assertEquals(expList, SetDeleteDuplicates.removeDuplicates(givenList));
    }

    @Test
    void removeDuplicates_NoDuplicatesGiven(){
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));
        expList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));

        assertEquals(expList, SetDeleteDuplicates.removeDuplicates(givenList));
    }

    @Test
    void removeDuplicates_AllDuplicates(){
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Ivan"}));
        expList.addAll(Arrays.asList(new String[]{"Ivan"}));

        assertEquals(expList, SetDeleteDuplicates.removeDuplicates(givenList));
    }

    @Test
    void removeDuplicates_EmptyGivenList(){
        assertEquals(expList, SetDeleteDuplicates.removeDuplicates(givenList));
    }

}