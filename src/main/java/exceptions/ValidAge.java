package exceptions;

//4. Написать метод "validate"  который принимает возраст человека и бросает "InvalidAgeException"
// "age is not valid to vote"
// если возраст меньше 18 а в противном случае выводит на экран надпись "welcome to vote"
//В методе main вызвать этот метод и поймать эту exception.

public class ValidAge {
    public static void main(String[] args) {
        try {
            checkAge(17);
        }catch (InvalidAgeException e){
            e.printStackTrace();
        }
    }
    public static String checkAge(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("age is not valid to vote");
        else return "welcome to vote";
    }
}

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
    }
}
