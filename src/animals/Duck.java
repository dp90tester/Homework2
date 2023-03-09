package animals;

import animals.animalActions.Flying;
import animals.commonAnimal.Animal;

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
