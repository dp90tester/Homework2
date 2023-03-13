package animals;

import animals.animal_actions.Flying;
import animals.common_animal.Animal;

public class Duck extends Animal implements Flying {
    /**
     * Метод интерфейса Flying
     */
    @Override
    public void fly() {
        System.out.println("Я лечу");
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }
}
