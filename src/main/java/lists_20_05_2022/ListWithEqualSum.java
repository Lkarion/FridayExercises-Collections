package lists_20_05_2022;

import java.util.List;

public class ListWithEqualSum {
    ////1.Есть лист положительных целых чисел нечетной длины >=3.
    //    // Известно, что существует индекс элемента этого листа такой, что сумма всех элементов слева от него
    //    // равняется сумме всех элеменотов справа от него. Найти этот индекс.
    //    //3,2 1 4 1
    //
    //    //2.Найти минимальное количество платформ, требующихся для приема поездов на жд станции.
    //    //Дано время прибытия и отправки поездов .  List arrivals упорядочен
    //    public int minPlatforms(List arrivals,List departures){
    //        return 0;
    public static int getIndexEqualSum(List<Integer> list){

        if (list.size() < 3) return -1;

        int sumBefore = list.get(0), sumAfter = 0;
        for (int i = 2; i < list.size(); i++) {
            sumAfter += list.get(i);
        }

        for (int i = 1; i < list.size()-1; i++) {
            if (sumBefore == sumAfter) return i;
            else {
                sumBefore += list.get(i);
                sumAfter -= list.get(i+1);
            }
        }

        return -1;
    }
}
