package maps;

import java.util.*;

public class MostOftenElement {


    //3. Написать метод, который принимает список имен и их анаграмм и имя по
    // которому он выдает список всех его анаграмм, включая само имя
    //  public List<String>anagramList(String str, List<String>strings)
    //{"ivan","airam","vani","vian","maria","kolya"}, ivan -> {ivan,vani,vian}

    public static List<String> anagramList(String str, List<String>strings) {

        if (str == null
                || str.equals("")
                || strings == null
                || strings.isEmpty()) return Collections.emptyList();

        Map<String, List<String>> map = new HashMap<>();
        strings.forEach(name -> {
            List<String> anagrams = new ArrayList<>();
            strings.forEach(s -> {
                if (isAnagram(s, str))
                    anagrams.add(s);
            });
            map.put(name, anagrams);
        });

        for (String key : map.keySet()) {
            if (key.equals(str)) {
                return map.get(key);
            }
        }
            return Collections.emptyList();
    }

    public static boolean isAnagram(String strToCheck, String strGiven){
        if (strToCheck.length() != strGiven.length()) return false;
        
        char[] arrStrtoCheck = strToCheck.toLowerCase().toCharArray();
        char[] arrStrGiven = strGiven.toLowerCase().toCharArray();
        Arrays.sort(arrStrtoCheck);
        Arrays.sort(arrStrGiven);

        return Arrays.equals(arrStrGiven,arrStrtoCheck);
    }

    //написать метод, возвращающий элемент из списка, встречающийся наибольшее количество раз
// 1,5, -10,1-> 1
// public int findMaxOccuredElt(List<Integer> numbers)
    public static int findMaxOccuredElt(List<Integer> list) {

        Map<Integer,Integer> mapRes = new HashMap<>();
        for (Integer i: list) {
            if (mapRes.containsKey(i)) {
                mapRes.replace(i, mapRes.get(i)+1);
            }else mapRes.put(i,1);
        }
        int max = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;
        for (int key: mapRes.keySet()) {
            if (mapRes.get(key) > max) {
                max = mapRes.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }


    //написать метод, возвращающий элемент из списка не имеющий пары
//public int findSingleNumber(List<Integer>numbers)
// 1,2,1->2,  1,1,1->1

    public static int findSingleNumber(List<Integer> list){
        if (list == null || list.isEmpty()) return 0;
        Map<Integer, Boolean> map = new HashMap<>();
        list.forEach(e -> {
            if (map.containsKey(e)) {
                if (map.get(e)) // true means the element has a couple
                    map.replace(e, false); // we got a new element without a couple yet
                else map.replace(e,true);
            }else map.put(e, false);
        });

        int res = Integer.MIN_VALUE;
        for (int key: map.keySet()) {
            if ( !map.get(key) ) {
                res = key;
            }
        }
        return res;
    }
}
