package user_input_commands.input_animal_commands.input_animal;

import animals.animal_actions.Flying;
import animals.common_animal.Animal;
import constants.AnimalParameter;
import user_input_commands.input_commands_display.InputCommandsDisplay;
import validation.AnimalParameterValidation;

import java.util.ArrayList;
import java.util.Scanner;

public final class CreateNewAnimal {
    public static ArrayList<Animal> animalList = new ArrayList<>();

    public static void createNewAnimal(Scanner scanner, Animal animal) {
        fillAnimalData(scanner, animal);
        animalsActions(animal);
        InputCommandsDisplay.inputAnimalCommandsDisplay();
        animalList.add(animal);
    }

    public static void fillAnimalData(Scanner scanner, Animal animal) {
        setAnimalParameter(scanner, animal, "Введите имя - ", AnimalParameter.NAME);
        setAnimalParameter(scanner, animal, "Введите возраст - ", AnimalParameter.AGE);
        setAnimalParameter(scanner, animal, "Введите вес - ", AnimalParameter.WEIGHT);
        setAnimalParameter(scanner, animal, "Введите цвет - ", AnimalParameter.COLOR);
    }

    private static void animalsActions(Animal animal) {
        System.out.println("-----------------------------------");

        animal.say();
        if (animal instanceof Flying) {
            System.out.print("А еще - ");
            ((Flying) animal).fly();
        }

        System.out.println("-----------------------------------");
    }


    private static void setAnimalParameter(Scanner scanner, Animal animal, String inputMessage, AnimalParameter animalParameter) {
        System.out.printf("%s", inputMessage);
        switch (animalParameter) {
            case NAME:
                animal.setName(scanner.nextLine().trim());
                break;
            case AGE:
                int age = (int) AnimalParameterValidation.validateNumberParameter(scanner, inputMessage,60);
                animal.setAge(age);
                break;
            case WEIGHT:
                double weight =  AnimalParameterValidation.validateNumberParameter(scanner, inputMessage,50);
                animal.setWeight(weight);
                break;
            case COLOR:
                animal.setColor(scanner.nextLine().trim());
                break;
        }
    }
}