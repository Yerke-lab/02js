import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Рэкс", 3, "Золотистый ретривер");
        animals[1] = new Cat("Барсик", 5, false);
        animals[2] = new Dog("Лайка", 2, "Лабрадор");

        // Вывод информации о каждом объекте
        for (Animal animal : animals) {
            System.out.println("Имя: " + animal.getName());
            System.out.println("Возраст: " + animal.getAge());

            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.println("Порода: " + dog.getBreed());
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println("Персидский: " + cat.isPersian());
            }

            // Вызов метода makeSound(), если он присутствует
            try {
                Method makeSoundMethod = animal.getClass().getMethod("makeSound");
                makeSoundMethod.invoke(animal);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                // Обработка исключений, если метод makeSound() не найден или не может быть вызван
                System.out.println("Не может издавать звук " + animal.getName());
            }

            System.out.println();
        }
    }
}
