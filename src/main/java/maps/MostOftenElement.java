package maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//написать метод, возвращающий элемент из списка, встречающийся наибольшее количество раз
// 1,5, -10,1-> 1
// public int findMaxOccuredElt(List<Integer> numbers)

public class MostOftenElement {
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
