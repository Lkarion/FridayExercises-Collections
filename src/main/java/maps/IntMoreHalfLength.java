package maps;

import java.util.HashMap;
import java.util.Map;

public class IntMoreHalfLength {
    /**
     * //Есть массив с положительными целыми числами. найти элемент(если он есть), который встречается
     *         // в массиве > length/2  (доминантный). В противном случае вернуть -1
     * @param arr
     * @return
     */
    public static int getDominantInt(int[] arr){
        int res =-1;
        if (arr == null) return res;
        Map<Integer,Integer> mapRes = new HashMap<>();
        for (Integer i: arr) {
            if (mapRes.containsKey(i)) {
                mapRes.replace(i, mapRes.get(i)+1);
            }else mapRes.put(i,1);
        }
        for (int key: mapRes.keySet()) {
            if (mapRes.get(key) > arr.length/2)
                return (int)key;
        }
        return res;
    }

}
