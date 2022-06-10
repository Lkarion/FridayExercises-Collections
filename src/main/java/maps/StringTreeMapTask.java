package maps;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * // написать метод, принимающий лист слов , а возвращающий Treemap, ключами которого являются
 *     // буквы а значениями - листы слов, начинающихся с данной буквы и расположенных в лексикографи-
 *     //ческом порядке.
 *     //{hello,world,hell}-> {h:[hell,hello], w:[world]}
 */
public class StringTreeMapTask {
    public static TreeMap<Character, TreeSet<String>> getTreeMap(List<String> list){
        TreeMap<Character, TreeSet<String>> mapRes = new TreeMap<>();
        if (list.isEmpty() || list == null)
            return mapRes;
        list.forEach(str -> {
            if (mapRes.containsKey(str.charAt(0))){
                mapRes.get(str.charAt(0)).add(str);
            }else{
                TreeSet<String> value = new TreeSet<>();
                value.add(str);
                mapRes.put(str.charAt(0), value);
            }

        });
        return mapRes;
    }
}
