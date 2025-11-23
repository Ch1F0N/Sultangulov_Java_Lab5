import cats.Cat;
import cats.MeowHelper;
import cats.MeowingCounter;
import fractions.CachedFraction;
import fractions.Fraction;
import geometry.Point;
import geometry.Polyline;
import geometry.PolylineBuilder;
import lists.Task10;
import multisport.Multisport;
import russiantext.RussianText;
import queueTask6.MyQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
                        System.out.println("=== Дробь ===");

                        try {
                            System.out.print("Введите числитель: ");
                            int num1 = scanner.nextInt();

                            System.out.print("Введите знаменатель: ");
                            int den1 = scanner.nextInt();

                            Fraction baseFraction = new Fraction(num1, den1);

                            CachedFraction f1 = new CachedFraction(baseFraction);

                            System.out.println("Создана дробь: " + f1);


                            System.out.print("\nУстановим новый числитель: ");
                            int num = scanner.nextInt();
                            f1.setNumerator(num);
                            System.out.println("Теперь дробь: " + f1);


                            System.out.print("\nУстановим новый знаменатель: ");
                            int den = scanner.nextInt();
                            f1.setDenominator(den);
                            System.out.println("Теперь дробь: " + f1);


                            System.out.println("\nПроверим кэширование:");
                            System.out.println("Первый вызов getValue() (вычисление): " + f1.getValue());
                            System.out.println("Второй вызов getValue() (кэш): " + f1.getValue());


                            System.out.println("\nСравнение двух дробей:");
                            Fraction f2 = new Fraction(num1, den1);
                            System.out.println("Первая дробь равна второй дроби? " + baseFraction.equals(f2));

                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ошибка ввода данных!");
                            scanner.nextLine();
                        }

                        System.out.println();
                        break;
                    case 2:
                        // Структурные шаблоны
                        System.out.println("=== Количество мяуканий ===");

                        Cat cat = new Cat("Рыжик");

                        MeowingCounter counter = new MeowingCounter(cat);

                        System.out.println("Передаем кота в метод:");

                        System.out.print("Введите, сколько раз кот должен мяукнуть: ");
                        int times = scanner.nextInt();
                        if (times >= 0) {
                            for (int i = 0; i < times; i++) {
                                MeowHelper.makeAllMeow(counter);
                            }
                        } else {
                            System.out.println("Кот не может мяукать меньше 0!");
                        }

                        System.out.println("Кот мяукал: " + counter.getCount() + " раз(а)");

                        System.out.println();
                        break;
                    case 3:
                        // Список
                        System.out.println("=== Оставить только первые вхождения элементов ===");
                        System.out.println("Введите количество элементов списка:");
                        scanner.nextLine();

                        int n = 0;
                        try {
                            n = Integer.parseInt(scanner.nextLine());
                            if (n <= 0) {
                                System.out.println("Ошибка: количество должно быть > 0");
                                return;
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка ввода числа!");
                            return;
                        }

                        List<Integer> list = new ArrayList<>();

                        System.out.println("Введите " + n + " целых чисел через Enter:");

                        for (int i = 0; i < n; i++) {
                            try {
                                list.add(Integer.parseInt(scanner.nextLine()));
                            } catch (Exception e) {
                                System.out.println("Ошибка: введите целое число!");
                                i--;
                            }
                        }

                        System.out.println("\nИсходный список: " + list);

                        Task10.keepOnlyFirstOccurrences(list);

                        System.out.println("Результат: " + list);
                        System.out.println();
                        break;
                    case 4:
                        // Мап
                        System.out.println("=== Соревнования по многоборью ===");
                        try {
                            System.out.print("Введите количество спортсменов N: ");
                            int N = scanner.nextInt();

                            System.out.print("Введите количество видов спорта M: ");
                            int M = scanner.nextInt();
                            scanner.nextLine();

                            List<String> athleteLines = new ArrayList<>();
                            for (int i = 0; i < N; i++) {
                                System.out.print("Введите данные спортсмена #" + (i + 1) + ": ");
                                athleteLines.add(scanner.nextLine());
                            }

                            Multisport.processAthletes(N, M, athleteLines);

                        } catch (Exception e) {
                            System.out.println("Ошибка ввода: " + e.getMessage());
                        }
                        System.out.println();
                        break;
                    case 5:
                        // Сет
                        System.out.println("=== Текст на русском языке ===");
                        scanner.nextLine();
                        System.out.print("Введите путь к файлу с текстом: ");
                        String filePath = scanner.nextLine();

                        File file = new File(filePath);
                        if (!file.exists()) {
                            System.out.println("Ошибка: файл не найден.");
                            return;
                        }

                        List<String> words = new ArrayList<>();

                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] split = line.trim().split("\\s+");
                                words.addAll(Arrays.asList(split));
                            }

                            Set<Character> symbols = RussianText.getSymbolsInEvenWords(words);

                            System.out.println("Символы, встречающиеся хотя бы в одном четном слове:");
                            for (char c : symbols) {
                                System.out.print(c + " ");
                            }
                            System.out.println();

                        } catch (IOException e) {
                            System.out.println("Ошибка чтения файла: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                        System.out.println();
                        break;
                    case 6:
                        // Очередь
                        System.out.println("=== Печать элементов очереди в обратном порядке ===");
                        MyQueue<String> queue = new MyQueue<>();

                        System.out.print("Введите количество элементов очереди: ");
                        n = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < n; i++) {
                            System.out.print("Введите элемент #" + (i + 1) + ": ");
                            queue.add(scanner.nextLine());
                        }

                        List<String> reversed = queue.toReversedList();
                        System.out.println("Элементы очереди в обратном порядке:");
                        for (String e : reversed) {
                            System.out.println(e);
                        }
                        System.out.println();
                        break;
                    case 7:
                        // Стрим (1)
                        List<Point> points = new ArrayList<>();
                        scanner.nextLine();

                        System.out.println("=== Создание ломаной линии ===");

                        try {
                            System.out.print("Введите количество точек: ");
                            n = Integer.parseInt(scanner.nextLine());
                            if (n <= 0) {
                                throw new IllegalArgumentException("Количество точек должно быть > 0");
                            }

                            for (int i = 0; i < n; i++) {
                                System.out.print("Введите координаты точки #" + (i + 1) + " через пробел (X Y): ");
                                String[] input = scanner.nextLine().trim().split("\\s+");
                                if (input.length != 2) {
                                    throw new IllegalArgumentException("Нужно ввести ровно 2 числа");
                                }

                                double x = Double.parseDouble(input[0]);
                                double y = Double.parseDouble(input[1]);
                                points.add(new Point(x, y));
                            }

                            Polyline polyline = PolylineBuilder.buildPolyline(points);
                            System.out.println("Результирующая ломаная: " + polyline);

                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка: введено не число");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка: " + e.getMessage());
                        }
                        System.out.println();
                        break;
                    case 8:

                        System.out.println();
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println("Вы должны ввести только целое число!");
                System.out.println();
            }
        }
    }
}