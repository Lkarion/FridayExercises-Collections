package maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameNumberOccurrence {
    /**
     * //3.Дан список имен, где некоторые имена повторяются. написать метод, который по имени вернет количество
     *      *         // вхождений этого имени в список
     *      *         // int nameByNumberOccurrence(List<String> list, String name) Vasia->3
     */
    public static int nameByNumberOccurrence(List<String> list, String name){
        if (list == null || name == null) return 0;
        Map<String,Integer> mapRes = new HashMap<>();
        list.forEach(s -> {
            if (mapRes.containsKey(s)) {
                mapRes.replace(s, mapRes.get(s)+1);
            }else mapRes.put(s,1);
        });
        return mapRes.containsKey(name) ? mapRes.get(name) : 0;
    }
}
