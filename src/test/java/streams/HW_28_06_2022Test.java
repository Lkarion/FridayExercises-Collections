package streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HW_28_06_2022Test {

    HW_28_06_2022.Student s1;
    HW_28_06_2022.Student s2;
    HW_28_06_2022.Student s3;
    HW_28_06_2022.Student s4;
    HW_28_06_2022.Student s5;
    List<HW_28_06_2022.Student> students1;
    List<HW_28_06_2022.Student> students2;
    List<HW_28_06_2022.Student> students3;
    HW_28_06_2022.Group group1;
    HW_28_06_2022.Group group2;
    HW_28_06_2022.Group group3;

    List<HW_28_06_2022.Group> groupsGiven;

    @Test
    void getAllStudentsNames() {

        s1 = new HW_28_06_2022.Student("John", new ArrayList<>(List.of(345.0, 232.0)));
        s2 = new HW_28_06_2022.Student("Mike", new ArrayList<>(List.of(3452.2)));
        s3 = new HW_28_06_2022.Student("Marina", new ArrayList<>(List.of(23.3, 3645.4, 232.0)));
        s4 = new HW_28_06_2022.Student("Karl", new ArrayList<>(List.of(345.0, 425.0, 232.0)));
        s5 = new HW_28_06_2022.Student("Karl", new ArrayList<>(List.of(565.0, 32.0)));
        students1 = new ArrayList<>(List.of(s1,s3));
        students2 = new ArrayList<>(List.of(s2,s3));
        students3 = new ArrayList<>(List.of(s1,s4,s5));
        group1 = new HW_28_06_2022.Group("JWD25", students1);
        group2 = new HW_28_06_2022.Group("JWD26", students2);
        group3 = new HW_28_06_2022.Group("JWD27", students3);

        groupsGiven = new ArrayList<>(List.of(group1, group2, group3));
        // List<String> exp = new ArrayList<>(List.of("John", "Marina", "Mike", "Karl", "Karl"));
        List<String> exp = new ArrayList<>(List.of("Karl", "Mike", "Karl", "Marina", "John"));

        assertEquals(exp, HW_28_06_2022.getAllStudentsNames(groupsGiven));
    }

    @Test
    void getSumTotalPayments() {
        s1 = new HW_28_06_2022.Student("John", new ArrayList<>(List.of(1.0, 1.0)));
        s2 = new HW_28_06_2022.Student("Mike", new ArrayList<>(List.of(1.0, 1.0)));
        s3 = new HW_28_06_2022.Student("Marina", new ArrayList<>(List.of(1.0, 1.0)));
        s4 = new HW_28_06_2022.Student("Karl", new ArrayList<>(List.of(1.0, 1.0)));
        students1 = new ArrayList<>(List.of(s1,s3));
        students2 = new ArrayList<>(List.of(s2,s3));
        students3 = new ArrayList<>(List.of(s1,s4));
        group1 = new HW_28_06_2022.Group("JWD25", students1);
        group2 = new HW_28_06_2022.Group("JWD26", students2);
        group3 = new HW_28_06_2022.Group("JWD27", students3);

        groupsGiven = new ArrayList<>(List.of(group1, group2, group3));

        assertEquals(8.0, HW_28_06_2022.getSumTotalPayments(groupsGiven));
    }

    @Test
    void getStudentsWithPaymentsLessThan() {
        s1 = new HW_28_06_2022.Student("John", new ArrayList<>(List.of(5.0, 1.0)));
        s2 = new HW_28_06_2022.Student("Mike", new ArrayList<>(List.of(5.0, 1.0)));
        s3 = new HW_28_06_2022.Student("Marina", new ArrayList<>(List.of(1.0, 1.0)));
        s4 = new HW_28_06_2022.Student("Karl", new ArrayList<>(List.of(1.0, 1.0)));
        students1 = new ArrayList<>(List.of(s1,s3));
        students2 = new ArrayList<>(List.of(s2,s3));
        students3 = new ArrayList<>(List.of(s1,s4));
        group1 = new HW_28_06_2022.Group("JWD25", students1);
        group2 = new HW_28_06_2022.Group("JWD26", students2);
        group3 = new HW_28_06_2022.Group("JWD27", students3);

        groupsGiven = new ArrayList<>(List.of(group1, group2, group3));

        assertEquals(new ArrayList<>(List.of(s3,s4)),
                HW_28_06_2022.getStudentsWithPaymentsLessThan(groupsGiven, 4.0));
    }

    @Test
    void getFibonacci() {

        List<Long> expected = new ArrayList<>(List.of(0L, 1L));

        assertEquals(expected, HW_28_06_2022.getFibonacci(2));
    }
    @Test
    void getFibonacci_20() {

        List<Long> expected = new ArrayList<>(List.of(
                0L, 1L, 1L, 2L, 3L,
                5L, 8L, 13L, 21L, 34L,
                55L, 89L, 144L, 233L, 377L,
                610L, 987L, 1597L, 2584L, 4181L));

        assertEquals(expected, HW_28_06_2022.getFibonacci(20));
    }
    @Test
    void getFibonacci_0() {

        assertEquals(Collections.emptyList(), HW_28_06_2022.getFibonacci(0));
    }
}