import java.util.*;

public class Homework {
    /**
     * Given a List . Implement a method that will remove all adjacent identical characters, leaving only one.
     * For example: {a,,b,c,c,b,a,a,a,f} -> {a,,b,c,a,f}
     */
    public static List<String> removeAdjacent(List<String> input){
        Set<String> set = new HashSet<>(input);
        return new ArrayList<>(set);
    }


    /**
     * Given a List of words. Implements the method that return the Map where key is a word and the
     * value is how many times the word appears in the list.
     */
    public static Map<String,Integer> wordOccurrence(List<String> list){
        Map<String,Integer> mapRes = new HashMap<>();
        list.forEach(s -> {
            if (mapRes.containsKey(s)) {
                mapRes.replace(s,mapRes.get(s)+1);
            }else mapRes.put(s,1);
        });
        return mapRes;
    }


    /**
     * Given two lists of String. Implement the method that returns a set of strings that are present in both lists.
     */
    public static Set<String> getWordsInBothLists(List<String> list1, List<String> list2){
        Set<String> set = new HashSet<>();

        list1.forEach(s -> {
            if (list2.contains(s)) set.add(s);
        });

        return set;
    }


    /**
     * Given a List . Person has unique int id and name. All persons in the list except one are unique.
     * Implement a method that finds a non-unique Person in the list. Implement this task all ways
     * you know and evaluate the time and space complexity of each way.
     */

    static class Person implements Comparable<Person>{
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Person p) {
            return this.id - p.id != 0 ?
                    this.id - p.id :
                    this.name.compareTo(p.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    /**
     * Complexity O(n^2)
     * Requires to create objects SET and Person
     */
    public static Person getNonUniquePersonSet(List<Person> input){
        Set<Person> set = new HashSet<>();
        for (Person p: input) {
            if (set.contains(p))
                return p;
            else set.add(p);
        }
        return null;
    }


    /**
     * Complexity depends on sorting (in the worst way O(n^2)). After sorting complexity is O(n)
     * no extra variables (except those in sorting method), but have to go through method GET many times
     */
    public static Person getNonUniquePersonSort(List<Person> input){
        Collections.sort(input);
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i).equals(input.get(i-1)))
                return input.get(i);
        }
        return null;
    }

    /**
     * Complexity is O(n^2)
     * Requires to create an object MAP and other objects
     */
    public static Person getNonUniquePersonMap(List<Person> input){
        Map<Person, Integer> map = new HashMap<>();
        input.forEach(p -> {
            if (map.containsKey(p))
                map.replace(p,map.get(p)+1);
            else map.put(p,1);
        });

        for (Person p: map.keySet()) {
            if (map.get(p) > 1) {
                return p;
            }
        }
        return null;
    }


    /**
     * Given two lists of String. Implement the method that checks if one list is cyclic version of the other.
     * For example:
     * {word1, word2, word3, word4} , { word3, word4, word1, word2} -> true
     * {word1, word2, word3, word4} , { word4, word3, word2, word1} -> false
     */
    public static boolean isCycle(List<String> list1, List<String> list2){
        if (list1 == null
            || list2 == null
            || list1.size() != list2.size())
            return false;

        for (int i = 1; i < list1.size()-1; i++) {// number of rotations
            String firstElement = list1.get(0);
            for (int j = 0; j < list1.size()-1; j++) {
                list1.set(j, list1.get(j+1)); // left rotation
            }
            list1.set(list1.size()-1, firstElement);
            if (list1.equals(list2)) return true;
        }
        return false;
    }
    public static boolean isCycleBuiltIn(List<String> list1, List<String> list2){
        if (list1 == null
                || list2 == null
                || list1.size() != list2.size())
            return false;

        for (int i = 0; i < list1.size()-1; i++) {
            Collections.rotate(list1,1);
            if (list1.equals(list2)) return true;
        }
        return false;
    }
}
