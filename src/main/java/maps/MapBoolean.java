package maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBoolean {
    /**
     * //2 Дан не пустой массив строк, вернуть мапу Map<String,Boolean>  где каждая строка является ключом,
     *      *         // а значением является true  если строка в массиве встречается больше одного раза и false  если
     *      *         // только один раз
     *      *         // wordmultiple(["a","b","a","c","b"])->{a:true,b:true, c:false
     *      *         // }
     */
    public static Map<String,Boolean> wordmultiple(List<String> list){
        Map<String,Boolean> mapRes = new HashMap<>();
        list.forEach(s -> {
            if (mapRes.containsKey(s)) {
                mapRes.replace(s,true);
            }else mapRes.put(s,false);
        });
        return mapRes;
    }
}
