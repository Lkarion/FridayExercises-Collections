import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsRepetitionTest {

    @Test
    void isUnique_True(){
        assertTrue(StringsRepetition.isUnique("qwe"));
    }
    @Test
    void isUnique_False(){
        assertFalse(StringsRepetition.isUnique("qqwe"));
    }
    @Test
    void isUnique_True_EmptyString(){
        assertTrue(StringsRepetition.isUnique(""));
    }


}