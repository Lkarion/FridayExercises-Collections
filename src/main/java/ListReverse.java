import java.util.ArrayList;
import java.util.List;

public class ListReverse {
    //4.Написать метод, реверсирующий лист целых чисел. возвращает его в обратном порядке. Можно решать любым
    // способом, какой вам нравится.

    public static List<Integer> getReversedList (List<Integer> list){
        List<Integer> resList = new ArrayList<>();
        for (int i = list.size()-1; i >= 0 ; i--) {
            resList.add(list.get(i));
        }
        return resList;
    }
}
