import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Меню заданий:\n" +
                        "1. Шаблоны\n" +
                        "2. Структурные шаблоны\n" +
                        "3. Список\n" +
                        "4. Мап\n" +
                        "5. Сет\n" +
                        "6. Очередь\n" +
                        "7. Стрим (1)\n" +
                        "8. Стрим (2)\n" +
                        "0. Выход\n");

                System.out.print("Выберите задание из меню, которое хотите запустить: ");
                int task_menu = scanner.nextInt();
                System.out.println();

                if (task_menu == 0) {
                    break;
                }

                switch (task_menu) {
                    // Шаблоны
                    case 1:
                        System.out.println("=== Демонстрация работы класса Дробь ===");

                        try {
                            System.out.print("Введите числитель: ");
                            int num = scanner.nextInt();

                            System.out.print("Введите знаменатель: ");
                            int den = scanner.nextInt();

                            Fraction f1 = new Fraction(num, den);
                            System.out.println("Создана дробь: " + f1);

                            System.out.println("\nУстановим новый числитель (например, 5):");
                            f1.setNumerator(5);
                            System.out.println("Теперь дробь: " + f1);

                            System.out.println("\nУстановим новый знаменатель (например, 2):");
                            f1.setDenominator(2);
                            System.out.println("Теперь дробь: " + f1);

                            System.out.println("\nПроверим кэширование:");
                            System.out.println("Первый вызов getValue(): " + f1.getValue());
                            System.out.println("Второй вызов getValue() (кэш): " + f1.getValue());

                            System.out.println("\nСравнение двух дробей:");
                            Fraction f2 = new Fraction(5, 2);
                            System.out.println("f1.equals(f2)? " + f1.equals(f2));

                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ошибка ввода данных!");
                        }

                        System.out.println();
                        break;
                    case 2:

                        System.out.println();
                        break;
                    case 3:

                        System.out.println();
                        break;
                    case 4:

                        System.out.println();
                        break;
                    case 5:

                        System.out.println();
                        break;
                    case 6:

                        System.out.println();
                        break;
                    case 7:

                        System.out.println();
                        break;
                    case 8:

                        System.out.println();
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Вы должны ввести только целое число!");
                System.out.println();
            }
        }
    }
}