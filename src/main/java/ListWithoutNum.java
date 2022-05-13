import java.util.ArrayList;
import java.util.List;

public class ListWithoutNum {
    //6. Есть лист целых чисел. Написать метод, возвращающий лист без элементов больше заданного.

    public static List<Integer> getListWithoutNum(List<Integer> list, int n){
        List<Integer> resList = new ArrayList<>();
        for (Integer elem: list) {
            if (elem <= n) resList.add(elem);
        }
        return resList;
    }

}
