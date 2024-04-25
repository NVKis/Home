package animals.berds;


import animals.Animal;
import data.ColorData;

import java.util.Scanner;

public class Duck extends Animal implements IFlying {

    public Duck (String name, int age,float weight, ColorData colorData) {
        super(name, age, weight, colorData);
    }

    public Duck(Scanner scanner) {
        super(scanner);
    }
    @Override
    public void say() {
        System.out.println("Я крякаю кря-кря");
    }

    @Override
    public void flay() {
        System.out.println("Я лечу и крякаю");

    }
}
