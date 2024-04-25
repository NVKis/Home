package animals.pets;

import animals.Animal;
import data.ColorData;

import java.util.Scanner;

public class Cat extends Animal {

    public Cat(String name, int age, float weight, ColorData colorData) {
        super(name, age, weight, colorData);
    }

    public Cat(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void say() {

        System.out.println("Я говорю мяу");
    }
}