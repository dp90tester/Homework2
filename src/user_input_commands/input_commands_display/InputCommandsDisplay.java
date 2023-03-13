package user_input_commands.input_commands_display;

import constants.menu_input_commands.MainMenuInputCommands;
import constants.menu_input_commands.SubMenuAnimalInputCommands;

import java.util.Arrays;

public final class InputCommandsDisplay {
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
