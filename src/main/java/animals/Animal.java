package animals;

import animals.utils.EnumConverter;
import animals.utils.Validators;

import data.ColorData;

import java.util.Scanner;



public abstract class Animal{


    private String name;
    private int age;
    private float weight;
    private ColorData colorData;

    private Scanner scanner = null;

    public Animal (Scanner scanner) {
        this.scanner = scanner;

    }


    private Validators validators = new Validators();
    private EnumConverter enumConverter = new EnumConverter();



    public Animal(String name, int age,float weight, ColorData colorData) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.colorData = colorData;
    }


    // описание методов get (получить) для всех описанных полей
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public float getWeight() {
        return this.weight;
    }

    public ColorData getColorData() {
        return this.colorData;
    }

// описание методов set(установить) для всех описанных полей

    public void setName()
    {
        String name = "";
        while (true)
        {
            System.out.println("Введите имя животного");
            name = scanner.next().trim();
            if (validators.isStringChars(name))
            {
                break;
            }
            System.out.println("Вы ввели неверное имя животного");
        }

        this.name = name;
    }

    //
    public void setAge() {
        String ageStr = "";
        while (true) {

            System.out.println("Введите возраст животного");
            ageStr = scanner.next().trim();
            if (validators.isStringNumber(ageStr) && Integer.parseInt(ageStr) > 0) {
                break;
            }
            System.out.println("Введён неверный возраст");
        }

        this.age = Integer.parseInt(ageStr);
    }

    public void setWeight() {
        String weightStr = "";

        while (true) {
            System.out.println("Введите вес животного");
            weightStr = scanner.next().trim();
            if (!validators.isStringChars(weightStr) && Float.parseFloat(weightStr) > 0) {
                break;
            }
            System.out.println("Вы ввели неверный вес животного");
        }
        this.weight = Float.parseFloat(weightStr);
    }

    public void setColorData() {
        String colorDataStr = "";
        while (true)
        {
            System.out.printf("Введите цвет животного из %s\n", enumConverter.getNamesFromEnum(ColorData.class,  ","));
            colorDataStr = scanner.next().toUpperCase().trim();
            if (validators.checkValueInEnum(ColorData.class, colorDataStr)) {
                break;
            }
            System.out.println(String.format("Введённый цвет животного %s не существует", colorDataStr));

        }

        this.colorData = ColorData.valueOf(colorDataStr);
    }
    // прописываем методы из задания say,go,eat,drink
    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    // @Override  // переопределение

    public String toString() {

        // прописываем шаблон String.format для выражения с нужными полями
        return String.format("Привет! меня зовут %s, мне %d %s , я вешу - %.2f кг, мой цвет - %s",
                name,
                age,
                this.getPage1(),
                weight,
                colorData.getName());
    }

    // опишем метод "Падежа" подстановки в шаблон слов: лет, год/года
    private String getPage1() {
        int ostatok = age % 10;

        if(age >= 11 && age <= 14) {
            return "лет";
        }

        if(ostatok == 1) {
            return "год";
        }

        if(ostatok >= 5) {
            return "лет";
        }

        if(ostatok >= 2) {
            return "года";
        }


        return "лет";
    }
}
