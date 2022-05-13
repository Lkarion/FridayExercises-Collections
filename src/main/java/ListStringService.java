import java.util.ArrayList;
import java.util.List;

public class ListStringService {
    //7. написать метод, возвращающий строку, которая встречается  в листе раньше: самую короткую
    // или самую длинную. Если несколько строчек самые короткие или длинные, вернуть первую встретившуюся.
    // лист не пустой ( по желанию, можно также и пустой , но в этом случае надо бросить exception :))

    public static String getShortestOrLongestString(List<String> list){
        if (list.isEmpty()) throw new RuntimeException("List is Empty");

        String sShortest = list.get(0);
        String sLongest = list.get(0);
        int indexShortest = 0;
        int indexLongest = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() < sShortest.length()){
                sShortest = list.get(i);
                indexShortest = i;
            }
            else if (list.get(i).length() > sLongest.length()){
                sLongest = list.get(i);
                indexLongest = i;
            }
        }
        if (indexShortest < indexLongest) return sShortest;
        else return sLongest;
    }
}
