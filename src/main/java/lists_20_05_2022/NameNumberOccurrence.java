package lists_20_05_2022;

import java.util.List;

public class NameNumberOccurrence {
    /**
     * //3.Дан список имен, где некоторые имена повторяются. написать метод, который по имени вернет количество
     *      *         // вхождений этого имени в список
     *      *         // int nameByNumberOccurrence(List<String> list, String name) Vasia->3
     */
    public static int nameByNumberOccurrence(List<String> list, String name){
        if (list == null || name == null) return 0;
        int count = 0;
        for (String s: list) {
            if (s.equals(name))
                count++;
        }
        /*list.forEach(s -> {
            if (s.equals(name)) {
                count++;
            }
        });*/
        return count;
    }
}
