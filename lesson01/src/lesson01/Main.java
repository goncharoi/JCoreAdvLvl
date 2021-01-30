package lesson01;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        random.ints();
//формируем массив препятствий
        Rising[] risings = new Rising[random.nextInt(10)];
        for (int i = 0; i < risings.length; i++) {
            if (random.nextInt(100) > 50)
                risings[i] = new Stone(random.nextInt(4));
            else
                risings[i] = new Street(random.nextInt(100));
        }
//формируем массив участников (можно было тоже случайный, но захотелось так)
        Moving[] movings = {
                new Human(random.nextInt(100),random.nextInt(4)),
                new Cat(random.nextInt(100),random.nextInt(4)),
                new Robot(random.nextInt(100),random.nextInt(4)),
        };
//Каждое препятствие заставляет участника делать специфическое для препятствия действие
        for (Rising r:risings) {
            for (int i = 0; i < movings.length; i++) {
                if (movings[i] != null) 
                    if (!movings[i].chooseAction(r))
                        movings[i] = null;
            }
        }

    }
}
