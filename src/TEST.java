import java.util.Scanner;

public class TEST {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();
        System.out.println(calc(exp));
    }

    public static String calc(String input) throws Exception {
        int a;
        int b;
        String znak;
        String[] elements = input.split(" ");
        if (elements.length == 1) {
            throw new Exception("строка не является математической операцией");
        }
        if (elements.length != 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        znak = opredznak(input);
        if (znak == null) {
            throw new Exception("не знакомый формат математической операции ");
        }
        a = Integer.parseInt(elements[0]);
        b = Integer.parseInt(elements[2]);
        if (a > 10 || b > 10) {
            throw new Exception("числа должны быть от 1 до 10");
        }
        String result = String.valueOf(reshen(a, b, znak));

        return result;

    }

    static String opredznak(String input) {
        if (input.contains("+")) {
            return "+";
        } else if (input.contains("-")) {
            return "-";
        } else if (input.contains("/")) {
            return "/";
        } else if (input.contains("*")) {
            return "*";
        } else return null;

    }

    static int reshen(int a, int b, String znak) {
        if (znak.equals("+")) {
            return a + b;
        } else if (znak.equals("-")) {
            return a - b;
        } else if (znak.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }

    }
}
