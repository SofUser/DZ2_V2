import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Демонстрация конструктора
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        System.out.println("Вектор v1 = " + v1);
        System.out.println("Вектор v2 = " + v2);

        // 2. Демонстрация вычисления длины вектора
        System.out.printf("Длина v1 = %.2f\n", v1.length());
        System.out.printf("Длина v2 = %.2f\n", v2.length());

        // 3. Демонстрация скалярного произведения
        double dotProduct = v1.dotProduct(v2);
        System.out.printf("v1 ⋅ v2 = %.2f\n", dotProduct);

        // 4. Демонстрация векторного произведения
        Vector crossProduct = v1.crossProduct(v2);
        System.out.println("v1 × v2 = " + crossProduct);

        // 5. Демонстрация угла между векторами (косинус угла)
        double cosine = v1.cosineAngle(v2);
        System.out.printf("Косинус угла между v1 и v2 = %.4f\n", cosine);
        double angleRad = Math.acos(cosine);
        double angleDeg = Math.toDegrees(angleRad);
        System.out.printf("Угол между векторами = %.2f°\n", angleDeg);

        // 6. Демонстрация суммы и разности
        Vector sum = v1.add(v2);
        Vector diff = v1.subtract(v2);
        System.out.println("v1 + v2 = " + sum);
        System.out.println("v1 - v2 = " + diff);

        // 7. Демонстрация неизменяемости (immutable)
        System.out.println("Исходный v1 = " + v1);
        System.out.println("После операций v1 = " + v1 + " (не изменился!)");

        // 8. Статический метод для генерации случайных векторов
        int n = getNumberOfVectors(scanner);
        Vector[] randomVectors = Vector.generateRandomVectors(n);

        System.out.println("Сгенерированные векторы:");
        for (int i = 0; i < randomVectors.length; i++) {
            System.out.printf("Вектор %d: %s (длина = %.2f)\n",
                                i + 1, randomVectors[i], randomVectors[i].length());
        }

        scanner.close();
    }

    private static int getNumberOfVectors(Scanner scanner) {
        while (true) {
            System.out.print("Введите количество векторов для генерации (N): ");
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Ошибка! Число должно быть положительным.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
    }
}