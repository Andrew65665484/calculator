import java.util.Scanner;
C:\Users\user\Desktop\CalcArabianSupport
public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите выражение без пробелов: ");
        String exp = scn.nextLine();
        int actionIndex = -1;
        for (int actionsOperation = 0; actionsOperation < actions.length; actionsOperation++) {
            if(exp.contains(actions[actionsOperation])) {
                actionIndex = actionsOperation;
                break;
            }
        }
        if(actionIndex == -1) {
            System.out.println("Некоректное выражение");
            return;
        }
        String[] data = exp.split(regexActions[actionIndex]);

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman) {
                System.out.println("Выражение " + converter.intToRoman(a) + actions[actionIndex] + converter.intToRoman(b) + " = " + converter.intToRoman(result));
            } else {
                System.out.println("Выражение " + a + actions[actionIndex] + b + " = " + result);
            }
        }
        else {
            System.out.println("Числа должны бфть в одном формате");
        }
    }
}








































