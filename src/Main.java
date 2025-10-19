import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание векторов.
        Vector v1 = createVectorFromInput(scanner, "первого");
        Vector v2 = createVectorFromInput(scanner, "второго");
        // Демонстрация операций.
        demonstrateVectorOperations(v1, v2);
        // Генерация случайных векторов.
        demonstrateRandomVectors(scanner);

        scanner.close();
        System.out.println("\nПрограмма завершена.");
    }

    private static Vector createVectorFromInput(Scanner scanner, String vectorName) {
        double x = 0, y = 0, z = 0;

        System.out.println("\nВведите координаты " + vectorName + " вектора:");

        x = getDoubleInput(scanner, "X");
        y = getDoubleInput(scanner, "Y");
        z = getDoubleInput(scanner, "Z");

        return new Vector(x, y, z);
    }

    private static double getDoubleInput(Scanner scanner, String coordinate) {
        while (true) {
            System.out.print(coordinate + " = ");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Ошибка! Введите число.");
                scanner.next();
            }
        }
    }

    private static void demonstrateVectorOperations(Vector v1, Vector v2) {
        System.out.println("Вектор 1: " + v1);
        System.out.println("Вектор 2: " + v2);

        // Длина векторов
        System.out.printf("Длина вектора 1: %.2f\n", v1.length());
        System.out.printf("Длина вектора 2: %.2f\n", v2.length());

        // Скалярное произведение
        System.out.printf("Скалярное произведение: %.2f\n", v1.dotProduct(v2));

        // Векторное произведение
        Vector cross = v1.crossProduct(v2);
        System.out.println("Векторное произведение: " + cross);

        // Косинус угла
        double cosine = v1.cosineAngle(v2);
        System.out.printf("Косинус угла между векторами: %.2f\n", cosine);

        // Сумма и разность
        System.out.println("Сумма векторов: " + v1.add(v2));
        System.out.println("Разность векторов: " + v1.subtract(v2));
    }

    private static void demonstrateRandomVectors(Scanner scanner) {
        int n = 0;
        while (n <= 0) {
            System.out.print("Введите количество случайных векторов для генерации (>0): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Ошибка! Число должно быть положительным.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next(); // очистка некорректного ввода
            }
        }

        Vector[] randomVectors = Vector.generateRandomVectors(n);
        System.out.println("\nСгенерированные случайные векторы:");
        for (int i = 0; i < randomVectors.length; i++) {
            System.out.println((i + 1) + ". " + randomVectors[i]);
        }

        // Демонстрация операций с первыми двумя векторами
        if (n >= 2) {
            System.out.println("\nОперации с первыми двумя случайными векторами:");
            demonstrateVectorOperations(randomVectors[0], randomVectors[1]);
        }
    }
}