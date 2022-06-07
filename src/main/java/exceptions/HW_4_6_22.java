package exceptions;

import java.util.*;

public class HW_4_6_22 {
    /**
     * 1.
     * Есть List. Все элементы в нем должны быть целые числа, но некоторые данные повреждены
     * (например, содержат символы). Необходимо преобразовать данный список в List.
     * При этом сформировать детализированный список «ошибок» т.е. в каких ячейках и
     * какие значения не были распарсены.
     */
    public static Map<Integer,String> getErrors(List<String> list) {
        Map<Integer, String> errorsMap = new HashMap<>();
        if (list == null) return errorsMap;

        for (int i = 0; i < list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
            }catch (NumberFormatException exception){
                errorsMap.put(i, list.get(i));
            }
        }

        return errorsMap;
    }


    /**
     * 2.
     * У вас в программе создается User (User {String firstName, String lastName, int age,email}).
     * При этом, в конструктор приходит строка вида “John;Lennon;40;lennon@mail.com”
     * Система должна либо создавать объект, либо формировать Exception. При этом,
     * должна быть возможность получить все ошибки, которые привели к несозданию объекта.
     * Например:
     * Некорректный формат строки. В строке не хватает данных
     * Поле не задано (пустое)
     * email имеет неправильный формат: короче 4 символов или не содержит символ @.
     * Поле возраст некорректно
     * В строке больше полей, чем необходимо
     */
    static class User {
        String firstName;
        String lastName;
        int age;
        String email;

        public User(String str) throws Exception {

            List<String> errors = checkUser(str);
            if (errors.isEmpty()) {
                String[] strings = str.split(";");
                this.firstName = strings[0];
                this.lastName = strings[1];
                this.age = Integer.parseInt(strings[2]);
                this.email = strings[3];
            }
            else{
                errors.forEach(s -> System.out.println());
                throw new Exception("New User is NOT created");
            }
        }
        public User(String firstName, String lastName, int age, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this.hashCode() != o.hashCode()) return false;
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, age, email);
        }


    }

    public static List<String> checkUser(String str) {
        List<String> errorList = new ArrayList<>();
        String[] strings = str.split(";");
        if (strings.length > 4)
            errorList.add("В строке больше полей, чем необходимо");
        if (strings.length < 4)
            errorList.add("Некорректный формат строки. В строке не хватает данных");
        else {
            for (String s : strings) {
                if (s.equals(""))
                    errorList.add("Одно из полей не задано (пустое)");
            }
            if (strings[3].length() < 4 || !strings[3].contains("@") || !strings[3].contains("."))
                errorList.add("email имеет неправильный формат: " + strings[3]);
            try {
                Integer.parseInt(strings[2]);
            } catch (NumberFormatException e) {
                errorList.add("Поле возраст некорректно " + strings[2]);
            }
        }

        return errorList;
    }


    /**
     * 3.
     * Дан List. Каждый Record состоит из Person(int id, String name) и некого числового значения Long timecode.
     * Естественно, id – уникально. Известно, что каждому Person в списке соответствует две записи
     * (предположим, два этапа вакцинации). Но один Person имеет только одну запись (вторую вакцинацию пропустил).
     * Необходимо найти этого Person’а. Решите эту задачу всеми известными Вам способами
     */
    static class Person {
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (this.hashCode() != o.hashCode()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static Person findPerson(Map<Person, List<Long>> map) {
        for (Person p : map.keySet()) {
            if (map.get(p).size() == 1)
                return p;
        }
        throw new NoSuchElementException("Every Person is vaccinated");
    }

}
