import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите выражение (например: 5 + 3) или 'exit': ");
            String expression = scanner.nextLine();

            try {
                if (expression.trim().equalsIgnoreCase("exit")) {
                    System.out.println("Программа завершена.");
                    break;
                }

                String trimmed = expression.trim();
                String[] parts = trimmed.split("\\s+");

                if (parts.length != 3) {
                    throw new IllegalArgumentException(
                            "Неверный формат. Ожидалось: число оператор число (например, '5 + 3')."
                    );
                }

                int num1 = Integer.parseInt(parts[0]);
                String operator = parts[1];
                int num2 = Integer.parseInt(parts[2]);
                int result;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            throw new ArithmeticException("Деление на ноль невозможно.");
                        }
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException(
                                "Неизвестный оператор '" + operator + "'. Доступны: +, -, *, /"
                        );
                }

                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: одно из значений не является целым числом.");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
            }
        }

        scanner.close();
    }
}