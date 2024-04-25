package factory;

import animals.berds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.Animal;
import data.AnimalData;
import exeptions.AnimalNotSupported;

import java.util.Scanner;

public class AnimalFactory {

    private Scanner scanner = null;

    public AnimalFactory(Scanner scanner) {
        this.scanner =scanner;
    }


    //приписываем метод, который будет возвращать заданные объекты, прописанные уже в AnimalData,
    // разбиваем их и определяем исключение
    public Animal create(AnimalData animalData) throws AnimalNotSupported {

        switch (animalData) {
            case CAT: {

                return new Cat(scanner);
            }
            case DOG: {
                return new Dog(scanner);
            }

            case DUCK: {
                return new Duck(scanner);
            }


        }

        // определяем исключение

        throw new AnimalNotSupported (animalData);
    }
}
