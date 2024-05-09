package org.example;

import animals.Animal;
import animals.berds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.utils.EnumConverter;
import animals.utils.Validators;
import data.AnimalData;
import data.ColorData;
import data.CommandData;


import exeptions.AnimalNotSupported;
import factory.AnimalFactory;
import java.util.*;




public class Main {


    public static void main(String[] args) throws AnimalNotSupported {



        //пропишем команду сканер для ввода данных в консоле
        Scanner scanner = new Scanner(System.in);
        Validators validators = new Validators();
        EnumConverter enumConverter = new EnumConverter();
        //  CommandData[] commandsData = CommandData.values();// создаём массив из команд из enum CommandData

        List<Animal> animals = new ArrayList<>();

        while (true) {
            // для автоматического вывода команд исп-ем String.join с объектом
            System.out.printf("Введите команду из списка: %s\n", enumConverter.getNamesFromEnum(CommandData.class, "/"));

            String commandStr = scanner.nextLine().toUpperCase().trim();  //считываем введённоое значение


            if (!validators.checkValueInEnum(CommandData.class, commandStr)) {
                System.out.println(String.format("Комманда %s не существует", commandStr));
                continue;
            }

            CommandData commandData = CommandData.valueOf(commandStr);

            switch (commandData)
            {

                case ADD: {
                    String animalTypeStr = "";
                    while (true)
                    {
                        System.out.printf("Введите тип животного %s\n", enumConverter.getNamesFromEnum(AnimalData.class, "/"));
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if (validators.checkValueInEnum(AnimalData.class, animalTypeStr))
                        {
                            break;
                        }
                        System.out.printf("Введённого типа животного %s не существует\n", animalTypeStr);

                    }

                    Animal animal = new AnimalFactory(scanner).create(AnimalData.valueOf(animalTypeStr));

                    animal.setName();      // вызов setName (валидация для Name внутри set)
                    animal.setAge();       // вызов setAge (валидация для Age внутри set)
                    animal.setWeight();    // вызов setWeight (валидация для Weight внутри set)
                    animal.setColorData(); // вызов setColorData (валидация для ColorData внутри set)

                    animal.say();

                    animals.add(animal);
                    scanner.nextLine();

                    break;
                }

                case LIST: {
                    if (animals.isEmpty()) {
                        System.out.println("Список животных пуст");
                        break;
                    }

                    animals.forEach((Animal animal) -> System.out.println(animal.toString()));


                    break;
                }

                case EXIT:
                    System.exit(0);
            }


        }


    }
}

