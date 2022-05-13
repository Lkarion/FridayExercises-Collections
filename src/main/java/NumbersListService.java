import java.util.ArrayList;
import java.util.List;

public class NumbersListService {
    //3.Есть два листа одинковой длины с числами. Написать метод, который вернет лист с элементами Yes or No
    //где значение на i-ом месте зависит от того, равны ли элемениы двух спсиков под номером i
    // {1,2,3,4} and {5,2,3,0}->{No,Yes,Yes,No}

    public static List<String> getListYesNo(List<Integer> l1, List<Integer> l2) {
        List<String> resList = new ArrayList<>();
        if (l1.size() == l2.size())
            for (int i = 0; i < l1.size(); i++) {
                if (l1.get(i) == l2.get(i))
                    resList.add("Yes");
                else resList.add("No");
            }
        return resList;
    }
}
