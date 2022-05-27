package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetGetDuplicates {
/**
 * //5.C использованием множеств написать метод, возвращающий повторяющиеся элементы из списка
 *      *         // List<String> getDuplicates(List<String>input
 *      *         // {Ivan,Maria,Piotr,Anna,Maria,Ivan}->{Ivan,Maria}
 */

public static List<String> getDuplicates(List<String> input){
    Set<String> set = new HashSet<>();
    List<String> listRes = new ArrayList<>();
    input.forEach(s -> {
        if (set.contains(s) && !listRes.contains(s))
            listRes.add(s);
        else set.add(s);
    });

    return listRes;
}
}
