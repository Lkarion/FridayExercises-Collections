package names;

import java.util.LinkedList;
import java.util.List;

public class NameService {
    //2. Есть список с именами Ivan, Maria, Stephan, John, Amalia. Написать
    // метод, возвращающий список в котором не содержатся имена исходного листа длиной 4

    public static List<String> getNamesNot4(List<String> list){
        List<String> resList = new LinkedList<>();
        for (String name: list) {
            if (name.length() != 4)
                resList.add(name);
        }
        return resList;
    }
}
