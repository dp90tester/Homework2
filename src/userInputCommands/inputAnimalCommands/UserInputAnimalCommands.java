package userInputCommands.inputAnimalCommands;

import animals.*;
import constants.menuInputCommands.SubMenuAnimalInputCommands;
import userInputCommands.inputAnimalCommands.inputAnimal.CreateNewAnimal;
import userInputCommands.inputCommandsDisplay.InputCommandsDisplay;

import java.util.Scanner;

public abstract class UserInputAnimalCommands {
    public static void userInputAnimalCommands(Scanner scanner) {

        InputCommandsDisplay.inputAnimalCommandsDisplay();
        while (true) {
            try {
                String inputAnimal = scanner.nextLine().toUpperCase().trim();
                switch (SubMenuAnimalInputCommands.valueOf(inputAnimal)) {
                    case CAT:
                        Cat cat = new Cat();
                        CreateNewAnimal.createNewAnimal(scanner, cat);
                        break;
                    case DOG:
                        Dog dog = new Dog();
                        CreateNewAnimal.createNewAnimal(scanner, dog);
                        break;
                    case DUCK:
                        Duck duck = new Duck();
                        CreateNewAnimal.createNewAnimal(scanner, duck);
                        break;
                    case BACK:
                        InputCommandsDisplay.inputMainCommandsDisplay();
                        return;
                }
            } catch (IllegalArgumentException e) {
                System.out.print("\nНеверный ввод!");
                InputCommandsDisplay.inputAnimalCommandsDisplay();
            }
        }
    }
}
