package animals.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import data.CommandData;
public class Validators {


    public <T extends Enum<T>> boolean  checkValueInEnum(Class<T> enumType, String value) {
        for (T val: enumType.getEnumConstants()) {
            if(val.name().equals(value)) {
                return true;
            }
        }

        return false;
    }

    // проверка на заполняемость строки буквами
    public boolean isStringChars(String str) {
        Pattern pattern = Pattern.compile( "^[a-zA-Z]+$"); // создать объект Pattern с помощью
        //  статического метода compile(), устанавливающий
        //  шаблон для сравнения
        Matcher matcher = pattern.matcher(str); // вызываем метод matcher который в качестве параметра принимает строку,
        // где надо проводить поиск, и возвращает объект Matcher:
        return matcher.find(); //возвращает true, если есть совпадение с шаблоном
    }

    // проверка на заполняемость строки цифрами
    public boolean isStringNumber(String str) {
        Pattern pattern = Pattern.compile( "^[0-9]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}

