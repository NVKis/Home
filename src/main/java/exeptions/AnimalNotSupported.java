package exeptions;

import data.AnimalData;

public class AnimalNotSupported extends Exception {

    public AnimalNotSupported (AnimalData animalData){
        super(String.format("Animal %S not supported", animalData.name()));
    }

}