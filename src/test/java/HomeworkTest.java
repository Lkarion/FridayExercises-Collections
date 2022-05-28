import maps.NameNumberOccurrence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import set.SetDeleteDuplicates;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {


    /** 1
     *****************************************
     */

    List<String> givenList;
    List<String> expList;

    @BeforeEach
    void init(){
        givenList = new ArrayList<>();
        expList = new ArrayList<>();
    }

    @Test
    void removeAdjacent_Normal(){
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna","Maria","Ivan"}));
        expList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));

        assertEquals(expList, Homework.removeAdjacent(givenList));
    }

    @Test
    void removeAdjacent_NoDuplicatesGiven(){
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));
        expList.addAll(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));

        assertEquals(expList, Homework.removeAdjacent(givenList));
    }

    @Test
    void removeAdjacent_AllDuplicates(){
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Ivan"}));
        expList.addAll(Arrays.asList(new String[]{"Ivan"}));

        assertEquals(expList, Homework.removeAdjacent(givenList));
    }

    @Test
    void removeAdjacent_EmptyGivenList(){
        assertEquals(expList, Homework.removeAdjacent(givenList));
    }


    /**   2
     *****************************************
     */

    @Test
    void wordOccurrence() {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",1);
        map.put("c",1);
        givenList = new ArrayList<>(Arrays.asList(new String[]{"a","b","c"}));

        assertEquals(map, Homework.wordOccurrence(givenList));
    }
    @Test
    void wordOccurrence_2() {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",2);
        map.put("b",1);
        givenList = new ArrayList<>(Arrays.asList(new String[]{"a","b","a"}));

        assertEquals(map, Homework.wordOccurrence(givenList));
    }
    @Test
    void wordOccurrence_EmptyList() {
        Map<String,Integer> map = new HashMap<>();

        assertEquals(map, Homework.wordOccurrence(givenList));
    }



    /**   3
     *****************************************
     */

    @Test
    void getWordsInBothLists(){
        Set<String> setExp = new HashSet<>();
        setExp.add("Ivan");
        setExp.add("Anna");
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Anna","Karl"}));
        List<String> givenList2 = new ArrayList<>(Arrays.asList(new String[]{"Ivan","Maria","Piotr","Anna"}));

        assertEquals(setExp, Homework.getWordsInBothLists(givenList,givenList2));
    }
    @Test
    void getWordsInBothLists_NoSameWordsInLists(){
        Set<String> setExp = new HashSet<>();
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Anna","Karl"}));
        List<String> givenList2 = new ArrayList<>(Arrays.asList(new String[]{"Maria","Piotr"}));

        assertEquals(setExp, Homework.getWordsInBothLists(givenList,givenList2));
    }

    @Test
    void getWordsInBothLists_AllWordSame(){
        Set<String> setExp = new HashSet<>();
        setExp.add("Ivan");
        setExp.add("Anna");
        setExp.add("Karl");
        givenList.addAll(Arrays.asList(new String[]{"Ivan","Anna","Karl"}));
        List<String> givenList2 = new ArrayList<>(Arrays.asList(new String[]{"Karl","Ivan","Anna"}));

        assertEquals(setExp, Homework.getWordsInBothLists(givenList,givenList2));
    }


    @Test
    void getWordsInBothLists_1EmptyList(){
        Set<String> setExp = new HashSet<>();
        List<String> givenList2 = new ArrayList<>(Arrays.asList(new String[]{"Maria","Piotr"}));

        assertEquals(setExp, Homework.getWordsInBothLists(givenList,givenList2));
    }

    @Test
    void getWordsInBothLists_BothListsAreEmpty(){
        Set<String> setExp = new HashSet<>();
        List<String> givenList2 = new ArrayList<>();

        assertEquals(setExp, Homework.getWordsInBothLists(givenList,givenList2));
    }


    /**   4
     *****************************************
     */


    @Test
    void getNonUniquePersonSet() {
        List<Homework.Person> list = new ArrayList<>();
        Homework.Person p1 = new Homework.Person(12, "aaa");
        Homework.Person p2 = new Homework.Person(23, "bbb");
        Homework.Person p3 = new Homework.Person(56, "fff");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p3);

        assertEquals(p3, Homework.getNonUniquePersonSet(list));
    }
    @Test
    void getNonUniquePersonSet_2Elements(){
        List<Homework.Person> list = new ArrayList<>();
        Homework.Person p1 = new Homework.Person(12, "aaa");
        list.add(p1);
        list.add(p1);

        assertEquals(p1, Homework.getNonUniquePersonSet(list));
    }

    @Test
    void getNonUniquePersonSort() {
        List<Homework.Person> list = new ArrayList<>();
        Homework.Person p1 = new Homework.Person(12, "aaa");
        Homework.Person p2 = new Homework.Person(23, "bbb");
        Homework.Person p3 = new Homework.Person(56, "fff");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p3);

        assertEquals(p3, Homework.getNonUniquePersonSort(list));
    }
    @Test
    void getNonUniquePersonSort_2Elements(){
        List<Homework.Person> list = new ArrayList<>();
        Homework.Person p1 = new Homework.Person(12, "aaa");
        list.add(p1);
        list.add(p1);

        assertEquals(p1, Homework.getNonUniquePersonSort(list));
    }

    @Test
    void getNonUniquePersonMap() {
        List<Homework.Person> list = new ArrayList<>();
        Homework.Person p1 = new Homework.Person(12, "aaa");
        Homework.Person p2 = new Homework.Person(23, "bbb");
        Homework.Person p3 = new Homework.Person(56, "fff");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p3);

        assertEquals(p3, Homework.getNonUniquePersonMap(list));
    }
    @Test
    void getNonUniquePersonMap_2Elements(){
        List<Homework.Person> list = new ArrayList<>();
        Homework.Person p1 = new Homework.Person(12, "aaa");
        list.add(p1);
        list.add(p1);

        assertEquals(p1, Homework.getNonUniquePersonMap(list));
    }
    @Test
    void getNonUniquePersonMap_NonUniqueIsNull(){
        List<Homework.Person> list = new ArrayList<>();
        Homework.Person p1 = new Homework.Person(12, "aaa");
        list.add(p1);
        list.add(null);
        list.add(null);

        assertEquals(null, Homework.getNonUniquePersonMap(list));
    }




    /**   5
     *****************************************
     */

    @Test
    void isCycle_True(){
        givenList.addAll(Arrays.asList(new String[]{"word1", "word2", "word3", "word4"}));
        List<String> givenList2 = new ArrayList<>();
        givenList2.addAll(Arrays.asList(new String[]{"word3", "word4", "word1", "word2"}));

        assertTrue(Homework.isCycle(givenList, givenList2));
    }

    @Test
    void isCycle_False(){
        givenList.addAll(Arrays.asList(new String[]{"word1", "word2", "word3", "word4"}));
        List<String> givenList2 = new ArrayList<>();
        givenList2.addAll(Arrays.asList(new String[]{"word4", "word3", "word2", "word1"}));

        assertFalse(Homework.isCycle(givenList, givenList2));
    }

    @Test
    void isCycle_False_DifferentLengths(){
        givenList.addAll(Arrays.asList(new String[]{"word1", "word2", "word3", "word4"}));
        List<String> givenList2 = new ArrayList<>();
        givenList2.addAll(Arrays.asList(new String[]{"word4", "word3"}));

        assertFalse(Homework.isCycle(givenList, givenList2));
    }
    @Test
    void isCycle_False_NullLists(){
        givenList = null;
        List<String> givenList2 = null;

        assertFalse(Homework.isCycle(givenList, givenList2));
    }

}