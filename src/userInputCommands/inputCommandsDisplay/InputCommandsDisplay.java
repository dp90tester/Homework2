package userInputCommands.inputCommandsDisplay;

import constants.menuInputCommands.MainMenuInputCommands;
import constants.menuInputCommands.SubMenuAnimalInputCommands;

import java.util.Arrays;

public abstract class InputCommandsDisplay {
    private static void inputCommandsDisplay(String commandsMessage, Enum<?>[] enumCommands) {
        System.out.printf("\n%s", commandsMessage);
        Arrays.stream(enumCommands)
                .forEach(e -> System.out.printf("/%s ", e.toString().toLowerCase()));
        System.out.println();
    }

    public static void inputMainCommandsDisplay() {
        inputCommandsDisplay("Введите команду из списка: ", MainMenuInputCommands.values());
    }

    public static void inputAnimalCommandsDisplay() {
        inputCommandsDisplay("Введите животное из списка или вернитесь в главное меню: ", SubMenuAnimalInputCommands.values());
    }
}
