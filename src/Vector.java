import java.util.Random;

public final class Vector {
    private final double x;
    private final double y;
    private final double z;

    // Конструктор
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Геттеры для получения координат
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    // Вычисление длины вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Скалярное произведение с другим вектором
    public double dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Векторное произведение с другим вектором
    public Vector crossProduct(Vector other) {
        double newX = this.y * other.z - this.z * other.y;
        double newY = this.z * other.x - this.x * other.z;
        double newZ = this.x * other.y - this.y * other.x;
        return new Vector(newX, newY, newZ);
    }

    // Вычисляет косинус угла между векторами
    public double cosineAngle(Vector other) {
        double dot = this.dotProduct(other);
        double magProduct = this.length() * other.length();

        if (magProduct == 0) {
            return 0;
        }

        return dot / magProduct;
    }

    // Сумма векторов
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Разность векторов
    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Статический метод для создания массива случайных векторов
    public static Vector[] generateRandomVectors(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть положительным числом");
        }

        Random random = new Random();
        Vector[] vectors = new Vector[n];

        for (int i = 0; i < n; i++) {
            double x = random.nextDouble() * 10 - 5; // от -5 до 5
            double y = random.nextDouble() * 10 - 5;
            double z = random.nextDouble() * 10 - 5;
            vectors[i] = new Vector(x, y, z);
        }

        return vectors;
    }
}