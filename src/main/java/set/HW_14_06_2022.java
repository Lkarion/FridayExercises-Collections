package set;

import java.util.*;
import java.util.stream.Collectors;

public class HW_14_06_2022<T> {
    /**
     * Реализовать метод который принимает любой лист и:
     *
     * возвращает лист без дубликатов
     * возвращает лист без дубликатов, при этом сохраняя порядок элементов (т.е. если элемент e1 шел раньше элемента
     * e2 в исходном листе, в результирующем должно быть так же
     * Реализовать данную задачу всеми известными вам способами
     */
    public List<T> removeDuplicates(List<T> input){
        if (input == null || input.isEmpty()) return Collections.emptyList();

        Set<T> set = new HashSet<>();
        input.forEach(element -> set.add(element));

        return new ArrayList<>(set);
    }

    // O(n^2)
    public List<T> removeDuplicatesKeepingOrder_List(List<T> input){
        if (input == null || input.isEmpty())
            return Collections.emptyList();

        List<T> output = new ArrayList<>();
        input.forEach(element -> {
            if ( !output.contains(element) )
                output.add(element);
        });

        return output;
    }

    public List<T> removeDuplicatesKeepingOrder_Stream(List<T> input){
        if (input == null || input.isEmpty())
            return Collections.emptyList();

        return input.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
