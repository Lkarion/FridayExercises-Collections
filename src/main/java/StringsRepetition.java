import java.util.*;

public class StringsRepetition {
    /**
     * Задача на повторение:
     * Given a String, write method to check if all its characters are unique.
     * The string consists only of English letters.
     * Solve the task at least by two different ways:
     *
     * by using methods of String class
     * by using ascii value of characters.
     */
    public static void main(String[] args) {
        String s = "asdfwr";
        System.out.println(isUnique(s));
        System.out.println(isUniqueSorting(s));
        System.out.println(isUniqueASCII(s));
    }

    public static boolean isUnique(String str){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size() == str.length();
    }


    public static boolean isUniqueSorting(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);

        for (int i = 0; i < charArr.length-1; i++) {
            if (charArr[i] == charArr[i+1]) return false;
        }
        return true;
    }


    public static boolean isUniqueASCII(String str){
        char MAX_CHAR = 256;
        if (str.length() > MAX_CHAR)
            return false;

        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars, false);

        for (int i = 0; i < str.length(); i++) {
            int index = (int)str.charAt(i);

            if (chars[index] == true)
                return false;

            chars[index] = true;
        }
        return true;
    }
}
