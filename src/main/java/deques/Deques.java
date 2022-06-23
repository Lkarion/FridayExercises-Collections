package deques;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deques {
    //В ресторан периодически попадает заказ. У заказа есть время, когда он был
    // сделан (milliseconds from 1970 1 Jan).  Для каждого заказа необходимо
    // установить количество заказов, сделанных за 15 (20,N) минут до него


    /**
     * @param orderTimes - массив отсортированных по времени моментов, когда происходили заказы
     * @param minutes
     * @return для соответствующего заказа. количество заказов, сделанных в предыдущие minutes минут
     * public int[] countOrderNumber(long[]orderTimes,int minutes)
     */
    public int[] countOrderNumber(long[] orderTimes, int minutes) {
        int[] res = new int[orderTimes.length];
        Deque<Long> queue = new ArrayDeque<>();
        long millis = minutes * 60L * 1000;

        int i = 0;
        for (long orderTime : orderTimes) {
            queue.addLast(orderTime);
            while (orderTime - queue.getFirst() > millis)
                queue.removeFirst();

            res[i++] = queue.size() - 1;
        }

        return res;



    }
}
