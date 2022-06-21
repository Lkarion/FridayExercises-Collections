package lambdas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HW_20_06_2022 {
    /**
     * Реализовать обобщенный метод, который получая лист возвращает map, где ключом является объект,
     * а значением, сколько раз этот объект встречается в исходном листе.
     * Ограничение: для перебора использовать forEach(), для добавления значений в map метод map.merge()
     */

    public static <T> Map<T, Integer> getMap(List<T> input){
        Map<T, Integer> mapRes = new HashMap<>();

        if (input == null || input.isEmpty()) return mapRes;

        input.forEach(t -> mapRes.merge(t, 1, (prev, one) -> prev + one));

        return mapRes;
    }
}
