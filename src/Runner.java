import actions.Flying;
import animals.Cat;
import animals.Dog;
import animals.Duck;
import animals.commonAnimal.Animal;
import constants.AnimalParameter;
import menuInputCommands.MainMenuInputCommands;
import menuInputCommands.SubMenuAnimalInputCommands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    /*
    Список для занесения созданных животных
    */
    static ArrayList<Animal> animalList = new ArrayList<>();

    /*
     Основной блок выполнения программы
    */
    public static void main(String[] args) {
        userActions();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Ввод команд пользователем
     */
    private static void userActions() {
        inputMainCommandsDisplay();         // Вывод сообщения с начальными командами
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Проверка на ввод данных
            try {
                String inputCommand = scanner.nextLine().toUpperCase().trim();
                switch (MainMenuInputCommands.valueOf(inputCommand)) {
                    case ADD:           // Переходим в саб-меню выбора животных, возврат в начальное меню через команду /back
                        userInputAnimalCommands(scanner);
                        break;
                    case LIST:          // Выводим список с добавленными животными и список команд основного меню
                        if ((animalList.size() > 0))
                            animalList.forEach(System.out::println);
                        else System.out.println("Список пока пуст");

                        inputMainCommandsDisplay();
                        break;
                    case EXIT:          // Выходим из программы
                        return;
                }
            } catch (IllegalArgumentException e) {
                System.out.print("\nНеверный ввод!");
                inputMainCommandsDisplay(); // Вывод команд главного меню
            }
        }

    }

    /**
     * Выбор животного пользователем
     */
    private static void userInputAnimalCommands(Scanner scanner) {
        inputAnimalCommandsDisplay();                        // Вывод списка команд с животным и команды /back
        while (true) {
            try {
                String inputAnimal = scanner.nextLine().toUpperCase().trim();
                switch (SubMenuAnimalInputCommands.valueOf(inputAnimal)) {
                    case CAT:
                        createAndAppendNewAnimal(scanner, new Cat()); // Создание Cat с параметрами, вывод его действий и добавление животного в список
                        break;
                    case DOG:
                        createAndAppendNewAnimal(scanner, new Dog()); // Создание Dog с параметрами, вывод его действий и добавление животного в список
                        break;
                    case DUCK:
                        createAndAppendNewAnimal(scanner, new Duck()); /* Создание Duck с параметрами, вывод его действий(+ c интерфейса Flying)
                                                               и добавление животного в список */
                        break;
                    case BACK:
                        inputMainCommandsDisplay();               // Возврат к главному меню при вводе /back
                        return;
                }
            } catch (IllegalArgumentException e) {
                System.out.print("\nНеверный ввод!");
                inputAnimalCommandsDisplay(); // Вывод списка команд с животным и команды /back
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Вывод сообщений
     */
    @SafeVarargs
    private static <T extends Enum<T>> void inputCommandsDisplay(String commandsMessage, T... enumCommands) {
        System.out.printf("\n%s", commandsMessage);
        Arrays.stream(enumCommands)
                .forEach(e -> System.out.printf("/%s ", e.toString().toLowerCase()));
        System.out.println();
    }

    /**
     * Вывод сообщения с начальными командами в консоль
     */
    private static void inputMainCommandsDisplay() {
        inputCommandsDisplay("Введите команду из списка: ", MainMenuInputCommands.values());
    }

    /**
     * Вывод сообщения со списком животным и команды /back
     */
    private static void inputAnimalCommandsDisplay() {
        inputCommandsDisplay("Введите животное из списка или вернитесь в главное меню: ", SubMenuAnimalInputCommands.values());
    }
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Заполнение данных о животном с указанием нужных параметров
     */
    private static void fillAnimalData(Scanner scanner, Animal animal) {
        // Установка параметра для животного (использовать класс констант AnimalParameter) с выводом сообщения, что вводить

        setAnimalParameter(scanner, animal, "Введите имя - ", AnimalParameter.NAME);
        setAnimalParameter(scanner, animal, "Введите возраст - ", AnimalParameter.AGE);
        setAnimalParameter(scanner, animal, "Введите вес - ", AnimalParameter.WEIGHT);
        setAnimalParameter(scanner, animal, "Введите цвет - ", AnimalParameter.COLOR);
    }

    /**
     * Вывод сообщения и назначение параметра для животного в зависимости от типа параметра
     *
     * @param scanner      - ввод данных
     * @param animal       - животное
     * @param inputMessage - Сообщение о вводимом параметре
     * @param parameter    - тип параметра
     */
    private static void setAnimalParameter(Scanner scanner, Animal animal, String inputMessage, String parameter) {
        System.out.printf("%s", inputMessage);
        switch (parameter) {
            case AnimalParameter.NAME:
                animal.setName(scanner.nextLine().trim());
                break;
            case AnimalParameter.AGE:
                int age = 0;
                while (age <= 0 || age > 100) {
                    try {
                        age = Integer.parseInt(scanner.nextLine().trim());
                        if (age <= 0 || age > 100) {
                            System.out.printf("Возраст не может быть меньше или равен 0 или больше 100 лет!\n%s", inputMessage);
                        }
                    } catch (NumberFormatException e) {
                        System.out.printf("Неверный ввод, %s", inputMessage.toLowerCase());
                    }
                }
                animal.setAge(age);
                break;
            case AnimalParameter.WEIGHT:
                double weight = 0;
                while (weight <= 0 || weight > 100) {
                    try {
                        weight = Double.parseDouble(scanner.nextLine().trim());
                        if (weight <= 0 || weight > 100) {
                            System.out.printf("Вес не может быть меньше или равен 0 или больше 100кг!\n%s", inputMessage);
                        }
                    } catch (NumberFormatException e) {
                        System.out.printf("Неверный ввод, %s", inputMessage.toLowerCase());
                    }
                }
                animal.setWeight(weight);
                break;
            case AnimalParameter.COLOR:
                animal.setColor(scanner.nextLine().trim());
                break;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Вывод действий, которые выполняет животное
     */
    private static void animalsActions(Animal animal) {
        System.out.println("-----------------------------------");
        animal.say();
        // Проверяем, если животное реализует интерфейс Flying и выводим доп действия для него
        if (animal instanceof Flying) {
            System.out.print("А еще - ");
            ((Flying) animal).fly();
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Добавление животного в общий список
     */
    private static void fillAnimalsList(Animal animal) {
        animalList.add(animal);
    }

    /**
     * Добавление указанного животного, вывод действий созданного животного
     */
    private static void createAndAppendNewAnimal(Scanner scanner, Animal animal) {
        fillAnimalData(scanner, animal);   // Заполнение данных о животном
        animalsActions(animal);   // Вывод действий, которые выполняет животное
        fillAnimalsList(animal);  // Добавление животного в общий список
        inputAnimalCommandsDisplay(); // Вывод сообщения со списком животным и команды /back
    }
}


