package maps;

import java.util.HashMap;
import java.util.Map;

public class MapAB {
    /**
     * //1. Дана Map<String,String>. написать метод, возвращающий мапу такую, что если в исходной мапе
     *         // есть ключи "a" и "b" то нужно создать новый ключ "ав" с суммой значений от ключей а и в. Если нет
     *         // то ничего не нужно менять
     *         //mapAB({"a":"Hi","b":"There"}->{"a":"Hi","ab":HiThere, "b":"There"}
     *         //mapAB({"a":"Hi"}-> {a:Hi}
     */
    public static Map<String, String> mapAB(Map<String, String> map){
        if (map.containsKey("a") && map.containsKey("b")){
            Map<String, String> newMapAB = new HashMap<>(map);
            newMapAB.put("ab", map.get("a").concat(map.get("b")));
            return newMapAB;
        }
        return map;
    }
}
