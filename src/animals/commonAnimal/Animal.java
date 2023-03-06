package animals.commonAnimal;

public class Animal {
    String name, color;
    int age;
    double weight;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    /**
     * Переопределяем метод toString() для вывода информации о животном в консоль
     */
    @Override
    public String toString() {
        int lastDigit             = age % 10;
        int previousLastDigit = age / 10 % 10;
        String stringAge;

        if (previousLastDigit == 1) {
            stringAge = "лет";
        }
        else {
            switch (lastDigit) {
                case 1:
                    stringAge = "год";
                    break;
                case 2:
                case 3:
                case 4:
                    stringAge = "года";
                    break;
                default:
                    stringAge = "лет";
            }
        }

        return "Привет! меня зовут "
                + getName() + ", мне "
                + getAge() + " " + stringAge + ", я вешу - "
                + getWeight() + "кг, мой цвет - "
                + getColor();
    }
}
