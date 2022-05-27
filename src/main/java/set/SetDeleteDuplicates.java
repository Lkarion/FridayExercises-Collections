package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDeleteDuplicates {
    /**
     * //4. С использованием множеств написать метод, который вернет список без повторяющихся элементов
     *         // List<String> removeDuplicates(List<String>input)
     *         // {Ivan,Maria,Piotr,Anna,Maria,Ivan}->{Ivan,Maria,Piotr;Anna}
     */
    public static List<String> removeDuplicates(List<String> input){
        Set<String> set = new HashSet<>();
        input.forEach(s -> set.add(s));

        return new ArrayList<>(set);
    }
}
