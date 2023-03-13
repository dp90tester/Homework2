package validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class AnimalParameterValidation {

    public static double validateNumberParameter(Scanner scanner, String inputMessage, int maxValue) {
        double number;
        while (true) {
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number <= 0 || number > maxValue)
                    throw new InputMismatchException();
                break;
            } catch (NumberFormatException e) {
                System.out.printf("Неверный ввод, %s", inputMessage.toLowerCase());
            } catch (InputMismatchException e) {
                System.out.printf("Значение не может быть меньше/равно 0 или больше %d\n%s", maxValue, inputMessage);
            }
        }
        return number;
    }
}
