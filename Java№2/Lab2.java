public class Lab2 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: не переданы аргументы командной строки.");
            return;
        }

        String taskNumber = args[0];

        switch (taskNumber) {
            case "1":
                task1();
                break;
            case "2":
                task2();
                break;
            case "3":
                task3();
                break;
            case "4":
                task4(args);
                break;
            case "5":
                task5(args);
                break;
            case "6":
                task6();
                break;
            case "7":
                task7(args);
                break;
            case "8":
                task8();
                break;
            case "9":
                task9(args);
                break;
            case "10":
                task10(args);
                break;
            default:
                System.out.println("Неизвестное задание. Введите число от 1 до 10.");
        }
    }

    // 1
    public static void task1() {
        System.out.println("Тип\t\tМинимум\t\t\tМаксимум");
        System.out.println("---------------------------------------------------------");
        System.out.println("byte\t\t" + Byte.MIN_VALUE + "\t\t\t" + Byte.MAX_VALUE);
        System.out.println("short\t\t" + Short.MIN_VALUE + "\t\t\t" + Short.MAX_VALUE);
        System.out.println("int\t\t" + Integer.MIN_VALUE + "\t\t" + Integer.MAX_VALUE);
        System.out.println("long\t\t" + Long.MIN_VALUE + "\t" + Long.MAX_VALUE);
        System.out.println("float\t\t" + Float.MIN_VALUE + "\t\t\t" + Float.MAX_VALUE);
        System.out.println("double\t\t" + Double.MIN_VALUE + "\t\t\t" + Double.MAX_VALUE);
    }

    // 2
    public static void task2() {
        int[] arr = {5, -10, 3, -4, 15, -2, 7, 0, -5, 8, -1, 12, -3, 9, 14, -7, 2, -6, 11, 4};
        double product = 1.0;
        int count = 0;

        for (int x : arr) {
            if (x < 0) {
                product *= x;
                count++;
            }
        }

        if (count > 0) {
            double geometricMean = Math.pow(Math.abs(product), 1.0 / count);
            System.out.println("Количество отрицательных элементов: " + count);
            System.out.println("Среднее геометрическое (по модулю): " + geometricMean);
        } else {
            System.out.println("Отрицательных элементов нет.");
        }
    }

    // 3
    public static void task3() {
        double x = 5.0;
        double y = 5.0;
        double R = 10.0;
        double r = 3.0;

        double distance = Math.sqrt(x * x + y * y);
        System.out.println("Расстояние: " + distance);

        if (distance > R) {
            System.out.println("Не обнаружен");
        } else if (distance < r) {
            System.out.println("Тревога");
        } else {
            System.out.println("Обнаружен");
        }
    }

    // 4
    public static void task4(String[] args) {
        if (args.length < 5) {
            System.out.println("Ошибка: нужно передать R, r, x, y (4 числа).");
            return;
        }

        double R = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        double x = Double.parseDouble(args[3]);
        double y = Double.parseDouble(args[4]);

        double distance = Math.sqrt(x * x + y * y);

        if (distance > R) {
            System.out.println("Не обнаружен");
        } else if (distance <= r) {
            System.out.println("Тревога");
        } else {
            System.out.println("Обнаружен");
        }
    }

    // 5
    public static void task5(String[] args) {
        if (args.length < 2) {
            System.out.println("Ошибка: нужно передать целое число.");
            return;
        }

        int num = Integer.parseInt(args[1]);
        
        System.out.println("Число: " + num);
        System.out.println("Двоичное: " + Integer.toBinaryString(num));
        System.out.println("Восьмеричное: " + Integer.toOctalString(num));
        System.out.println("Шестнадцатеричное: " + Integer.toHexString(num).toUpperCase());
    }

    // 6
    public static void task6() {
        System.out.println("Кириллица (0x0400):");
        printTable(0x0400, 16, 16);
        
        System.out.println("\nДенежные знаки (0x20A0):");
        printTable(0x20A0, 2, 16);
    }

    public static void printTable(int startCode, int rows, int cols) {
        System.out.print("   ");
        for (int c = 0; c < cols; c++) {
            System.out.print(Integer.toHexString(c) + " ");
        }
        System.out.println();

        for (int r = 0; r < rows; r++) {
            int rowStart = startCode + r * cols;
            String hexCode = Integer.toHexString(rowStart);
            while (hexCode.length() < 4) {
                hexCode = "0" + hexCode;
            }
            System.out.print(hexCode + " ");
            
            for (int c = 0; c < cols; c++) {
                char ch = (char)(rowStart + c);
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    // 7
    public static void task7(String[] args) {
        if (args.length < 2) {
            System.out.println("Ошибка: передайте строку для анализа (в кавычках).");
            return;
        }
        
        String text = args[1];
        
        int letters = 0, upper = 0, lower = 0;
        int digits = 0, arabic = 0, nonArabic = 0;
        int other = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                letters++;
                if (Character.isUpperCase(c)) {
                    upper++;
                } else {
                    lower++;
                }
            } else if (Character.isDigit(c)) {
                digits++;
                if (c >= '0' && c <= '9') {
                    arabic++;
                } else {
                    nonArabic++;
                }
            } else {
                other++;
            }
        }

        System.out.println("Всего символов: " + text.length());
        System.out.println("Букв: " + letters + " (Строчных: " + lower + ", Прописных: " + upper + ")");
        System.out.println("Цифр: " + digits + " (Арабских: " + arabic + ", Не арабских: " + nonArabic + ")");
        System.out.println("Других символов: " + other);
    }

    // 8
    public static void task8() {
        System.out.println("=== СПРАВКА: indexOf ===");
        System.out.println("Метод indexOf ищет первое вхождение и возвращает индекс.");
        System.out.println("Если не найдено, возвращает -1.");
        System.out.println("Формы: indexOf(char), indexOf(char, fromIndex), indexOf(String), indexOf(String, fromIndex)");
    }

    // 9
    public static void task9(String[] args) {
        if (args.length < 3) {
            System.out.println("Ошибка: передайте основную строку и подстроку.");
            return;
        }

        String text = args[1];
        String sub = args[2];

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        System.out.println("Подстрока встречается: " + count + " раз.");
    }

    // 10
    public static void task10(String[] args) {
        if (args.length < 2) {
            System.out.println("Ошибка: передайте строку.");
            return;
        }

        String str = args[1];
        int n = str.length();
        
        System.out.println("Циклические перестановки для \"" + str + "\":");
        
        for (int i = 0; i < n; i++) {
            String permutation = str.substring(i) + str.substring(0, i);
            System.out.println(permutation);
        }
    }
}