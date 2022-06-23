package functionalInterfaces;

import org.w3c.dom.ls.LSOutput;

public class Lambdas {
    /**
     * Написать следующие лямбды и интерфейсы, которые они будут использовать:
     * <p>
     * интерфейсы: Cheсkable, Printable, Producable,StringConcate,Transformable (для некоторых выражений
     * используется один и тот же интерфейс)
     */
    public static void main(String[] args) {
        /**
         * 1.конкатинировать строки a и b=ab
         */
        StringConcate sc = (s1, s2) -> s1.concat(s2);
        System.out.println("Concatenating");
        System.out.println(sc.concat("a", "b"));
        /**
         * 2.ecли длина строки = 3 вернуть true иначе false
         * 3.ecли длина строки = 4 вернуть true иначе false
         */
        Checkable checkLength3 = str -> str.length() == 3;
        System.out.println("Checkable 3");
        System.out.println(checkLength3.check("vfss"));
        Checkable checkLength4 = str -> str.length() == 4;
        System.out.println("Checkable 4");
        System.out.println(checkLength4.check("sddf"));

        /**
         * 4.вернуть строку в верхнем регистре
         * 5.если длина строки 4 вернуть четыре звездочки иначе вернуть строку без изменений
         */
        Transformable t = str -> str.toUpperCase();
        System.out.println("Transformable to Upper case");
        System.out.println(t.transform("hEllo"));
        Transformable t1 = str ->
                checkLength4.check(str)
                        ? str = "****"
                        : str;
        System.out.println("Transformable with length 4");
        System.out.println(t1.transform("werr"));
        System.out.println(t1.transform("we"));

        /**
         * 6.распечатать строку в виде !строка!
         */
        Printable p = str -> System.out.println("!" + str + "!");
        System.out.println("Printable");
        p.print("something");
        /**
         * 7. печатает "Hello World"
         */
        Producable p1 = () -> "Hello World";
        System.out.println("Producable");
        System.out.println(p1.produce());
    }
}
