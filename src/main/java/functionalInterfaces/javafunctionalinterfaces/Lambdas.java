package functionalInterfaces.javafunctionalinterfaces;

import java.util.function.*;

public class Lambdas {
    /**
     * 1.конкатинировать строки a и b=ab
     */
    BiFunction<String, String, String> stringConcate = (s1, s2) -> s1.concat(s2);
    /**
     * 2.ecли длина строки = 3 вернуть true иначе false
     * 3.ecли длина строки четная, вернуть true иначе false
     */
    Predicate<String> checkLength3 = str -> str.length() == 3;
    Predicate<String> checkLengthEven = str -> str.length() % 2 == 0;

    /**
     * 4.вернуть строку в верхнем регистре
     * 5.если длина строки 4 вернуть четыре звездочки иначе вернуть строку без изменений
     */
    Function<String, String> t = str -> str.toUpperCase();
    Function<String, String> t1 = str ->
            str.length() == 4
                    ? str = "****"
                    : str;

    /**
     * 6.распечатать строку в виде !строка!
     */
    Consumer<String> p = str -> System.out.println("!" + str + "!");

    /**
     * 7. печатает "Hello World"
     */
    Supplier p1 = () -> "Hello World";

}
