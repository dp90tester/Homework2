import constants.menu_input_commands.MainMenuInputCommands;
import user_input_commands.input_animal_commands.UserInputAnimalCommands;
import user_input_commands.input_animal_commands.input_animal.CreateNewAnimal;
import user_input_commands.input_commands_display.InputCommandsDisplay;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputCommandsDisplay.inputMainCommandsDisplay();
        MainMenuInputCommands mainMenuInputCommands;

        while (true) {
            while (true) {
                try {
                    mainMenuInputCommands = MainMenuInputCommands.valueOf(scanner.nextLine().toUpperCase().trim());
                    break;
                } catch (IllegalArgumentException e) {
                    InputCommandsDisplay.inputMainCommandsDisplay();
                }
            }

            switch (mainMenuInputCommands) {
                case ADD:
                    UserInputAnimalCommands.userInputAnimalCommands(scanner);
                    break;
                case LIST:
                    if (CreateNewAnimal.animalList.size() > 0) CreateNewAnimal.animalList.forEach(System.out::println);
                    else System.out.println("Список пока пуст");
                    InputCommandsDisplay.inputMainCommandsDisplay();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
            }
        }
    }
}


