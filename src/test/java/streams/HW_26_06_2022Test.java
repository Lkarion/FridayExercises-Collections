package streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class HW_26_06_2022Test {

    HW_26_06_2022.Person p1 = new HW_26_06_2022.Person("Vasya", 25, "fh@web.de", "873287");
    HW_26_06_2022.Person p2 = new HW_26_06_2022.Person("Mike", 36, "sgf@web.de", "754");
    HW_26_06_2022.Person p3 = new HW_26_06_2022.Person("Mickey", 45, "ys@web.de", "2567");
    HW_26_06_2022.Person p4 = new HW_26_06_2022.Person("Lina", 27, "xcv@web.de", "346");
    HW_26_06_2022.Person p5 = new HW_26_06_2022.Person("Vasya", 25, "fh@web.de", "873287");

    HashMap<String, HW_26_06_2022.Person> inputMap;
    List<String> expected;

    @Test
    void isCorrectEmail_Normal_True() {
        inputMap = new HashMap<>();
        inputMap.put("fh@web.de", p5);
        inputMap.put("xcv@web.de", p4);

        assertTrue(HW_26_06_2022.isCorrectEmail(inputMap));
    }
    @Test
    void isCorrectEmail_Normal_False() {
        inputMap = new HashMap<>();
        inputMap.put("fh@web.de", p5);
        inputMap.put("xcv@web.de", p5);

        assertFalse(HW_26_06_2022.isCorrectEmail(inputMap));
    }




    // --------------------------------

    @Test
    void getEmailList_Normal_LessThanLimit() {
        inputMap = new HashMap<>();
        inputMap.put("fh@web.de", p5);
        inputMap.put("xcv@web.de", p4);
        inputMap.put("xcv@web.de", p4);

        expected = new ArrayList<>(List.of("fh@web.de", "xcv@web.de"));

        assertEquals(expected, HW_26_06_2022.getEmailList(inputMap,10, 100, 3));
    }

    @Test
    void getEmailList_Normal_EqualsLimit() {
        inputMap = new HashMap<>();
        inputMap.put("fh@web.de", p5);
        inputMap.put("xcv@web.de", p4);
        inputMap.put("xcv@web.de", p4);
        inputMap.put("ys@web.de", p3);

        expected = new ArrayList<>(List.of("fh@web.de", "xcv@web.de", "ys@web.de"));

        assertEquals(expected, HW_26_06_2022.getEmailList(inputMap,10, 100, 3));
    }
    @Test
    void getEmailList_Normal_MoreThanLimit() {
        inputMap = new HashMap<>();
        inputMap.put("fh@web.de", p5);
        inputMap.put("xcv@web.de", p4);
        inputMap.put("xcv@web.de", p4);
        inputMap.put("ys@web.de", p3);
        inputMap.put("fh@web.de", p1);
        inputMap.put("sgf@web.de", p2);
        inputMap.put("ys@web.de", p3);

        expected = new ArrayList<>(List.of("fh@web.de", "sgf@web.de", "xcv@web.de"));

        assertEquals(expected, HW_26_06_2022.getEmailList(inputMap,24, 40, 3));
    }
    @Test
    void getEmailList_Normal_AllElementsSame() {
        inputMap = new HashMap<>();
        inputMap.put("fh@web.de", p5);
        inputMap.put("fh@web.de", p5);
        inputMap.put("fh@web.de", p5);


        expected = new ArrayList<>(List.of("fh@web.de"));

        assertEquals(expected, HW_26_06_2022.getEmailList(inputMap,10, 100, 3));
    }
    @Test
    void getEmailList_Normal_EmptyResult() {
        inputMap = new HashMap<>();
        inputMap.put("fh@web.de", p5);
        inputMap.put("fh@web.de", p5);
        inputMap.put("fh@web.de", p5);


        expected = new ArrayList<>();

        assertEquals(expected, HW_26_06_2022.getEmailList(inputMap,10, 11, 30));
    }




    // _______________________________________


    @Test
    void getClosestElement_Normal() {
        List<Double> input = new ArrayList<>(List.of(0.2, 4.5, 3.1));

        assertEquals(3.1, HW_26_06_2022.getClosestElement(input, 3.0));
    }

    @Test
    void getClosestElement_NormalEqualNumber() {
        List<Double> input = new ArrayList<>(List.of(0.2, 3.1, 4.5, 3.0));

        assertEquals(3.0, HW_26_06_2022.getClosestElement(input, 3.0));
    }
    @Test
    void getClosestElement_Normal_NegativeNumbers() {
        List<Double> input = new ArrayList<>(List.of(0.2, -3.1, 4.5, 3.2));

        assertEquals(3.2, HW_26_06_2022.getClosestElement(input, 3.0));
    }

    @Test
    void getClosestElement_EmptyList() {
        List<Double> input = new ArrayList<>();

        assertThrows(NoSuchElementException.class, () -> HW_26_06_2022.getClosestElement(input, 3.2));
    }

    @Test
    void getClosestElement_Null_N() {
        List<Double> input = new ArrayList<>(List.of(5.2,-3.2));

        assertThrows(NullPointerException.class, () -> HW_26_06_2022.getClosestElement(input, null));
    }

    @Test
    void getClosestElement_NullList() {

        assertThrows(NullPointerException.class, () -> HW_26_06_2022.getClosestElement(null, 3.2));
    }
}