package maps;

import java.util.*;

/**
 * есть класс автомобиль, в котором есть три поля: марка, модель,цена.
 * Написать метод, который принимает лист автомобилей, а возвращает Treemap,
 * ключами которого являются марки автомобилей а значениями будут TreeSet
 * автомобилей в котором автомобили расположены в лексикографическом порядке
 * относительно модели, причем дешевые вперед если модели одинаковые
 * auto1 -> Volvo, c60, 50000
 * auto2 -> Mercedes, bmers600, 60000
 * auto3 -> Mercedes, amers600, 40000
 * auto4 -> Volvo, c60, 10000
 * Mercedes - [auto3,auto2]
 * Volvo - [auto4,auto1]
 */
public class AutoTask {
    public static TreeMap<String, TreeSet<Auto>> getTreeMap(List<Auto> list){
        TreeMap<String, TreeSet<Auto>> mapRes = new TreeMap<>();
        if (list.isEmpty() || list == null)
            return mapRes;
        list.forEach(auto -> {
            if (mapRes.containsKey(auto.mark)){
                mapRes.get(auto.mark).add(auto);
            }else{
                TreeSet<Auto> value = new TreeSet<>();
                value.add(auto);
                mapRes.put(auto.mark, value);
            }

        });
        return mapRes;
    }
}

class Auto implements Comparable<Auto> {
    String mark;
    String model;
    double price;

    public Auto(String mark, String model, double price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    @Override
    public int compareTo(Auto auto) {
        if(model.equals(auto.model)) {
            if (price - auto.price > 0) {
                return 1;
            } else if (price - auto.price < 0) {
                return -1;
            } else return 0;
        }else return model.compareTo(auto.model);
    }

}
