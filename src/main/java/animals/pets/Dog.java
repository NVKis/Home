package animals.pets;


import animals.Animal;
import data.ColorData;

import java.util.Scanner;

public class Dog extends Animal {

    public Dog (String name, int age,float weight, ColorData colorData) {
        super(name, age, weight, colorData);

    }

    public Dog (Scanner scanner) {
        super(scanner);
    }

    @Override
    public void say() {
        System.out.println("Я говорю Гав");
    }
}
