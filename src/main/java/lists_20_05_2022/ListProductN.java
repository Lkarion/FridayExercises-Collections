package lists_20_05_2022;

import java.util.*;

public class ListProductN {
    public static boolean containsProductDequeue(List<Integer> list, int n){
        Deque<Integer> dq = new LinkedList<>();
        list.forEach(i -> dq.add(i));

        while( ! dq.isEmpty() ) {
            int first = dq.poll();
            for (int i : dq) {
                if (first * i == n)
                    return true;
            }
        }
        return false;
    }
    public static boolean containsProduct(List<Integer> list, int n){
        Collections.sort(list);
        int i=0;
        int j= list.size()-1;
        while(i<j){
            if(list.get(i)*list.get(j) > n) j--;
            else if(list.get(i)*list.get(j) < n) i++;
            else return true;
        }
        return false;
    }
}
