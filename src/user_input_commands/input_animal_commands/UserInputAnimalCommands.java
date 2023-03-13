package user_input_commands.input_animal_commands;

import animals.Cat;
import animals.Dog;
import animals.Duck;
import constants.menu_input_commands.SubMenuAnimalInputCommands;
import user_input_commands.input_animal_commands.input_animal.CreateNewAnimal;
import user_input_commands.input_commands_display.InputCommandsDisplay;

import java.util.Scanner;

public final class UserInputAnimalCommands {
    public static void userInputAnimalCommands(Scanner scanner) {

        InputCommandsDisplay.inputAnimalCommandsDisplay();

        SubMenuAnimalInputCommands subMenuAnimalInputCommands;
        while (true) {
            while (true) {
                try {
                    subMenuAnimalInputCommands = SubMenuAnimalInputCommands.valueOf(scanner.nextLine().toUpperCase().trim());
                    break;
                } catch (IllegalArgumentException e) {
                    InputCommandsDisplay.inputAnimalCommandsDisplay();
                }
            }

            switch (subMenuAnimalInputCommands) {
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
        }
    }
}
