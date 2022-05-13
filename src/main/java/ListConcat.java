import java.util.ArrayList;
import java.util.List;

public class ListConcat {
    //5.Обьединить два списка в один
    public static List<Integer> getConcatList(List<Integer> l1, List<Integer> l2) {
        List<Integer> resList = new ArrayList<>();
        for (Integer elem: l1) {
            resList.add(elem);
        }
        for (Integer elem: l2) {
            resList.add(elem);
        }
        return resList;
    }
}
