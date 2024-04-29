import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String answer = calc(str);
        if (answer != null) {
            System.out.println(answer);
        }
    }

    public static String calc(String input){
        String operation;
        Integer operandFirst, operandSecond, result;
        boolean romanNumFlag = false;

        Converter converter = new Converter();

        List<String> splittedInput = Arrays.asList(input.split(" "));

        if (splittedInput.size() != 3) {
                throw new CalculatorException("Ошибка в введенном выражении");
        }

        if (converter.checkOperation(splittedInput.get(1))) {
            operation = splittedInput.get(1);
        } else {
            throw new CalculatorException("Неверная операция");
        }

        if (converter.isRoman(splittedInput.get(0)) && converter.isRoman(splittedInput.get(2))){
            operandFirst = converter.romanToArabic(splittedInput.get(0));
            operandSecond = converter.romanToArabic(splittedInput.get(2));
            romanNumFlag = true;
        } else if (converter.isArabic(splittedInput.get(0)) && converter.isArabic(splittedInput.get(2))){
            operandFirst = Integer.parseInt(splittedInput.get(0));
            operandSecond = Integer.parseInt(splittedInput.get(2));
        } else {
            throw new CalculatorException("Числа должны быть в одинаковой системе счисления");
        }

        try {
            converter.isValidNum(operandFirst);
            converter.isValidNum(operandSecond);
        } catch (CalculatorException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        result = switch (operation) {
            case "+" -> operandFirst + operandSecond;
            case "-" -> operandFirst - operandSecond;
            case "*" -> operandFirst * operandSecond;
            case "/" -> operandFirst / operandSecond;
            default -> throw new CalculatorException("Неправильная операция");
        };

        if (romanNumFlag) {
            if (result > 0) {
                return converter.arabicToRoman(result);
            } else {
                throw new CalculatorException("Результатом работы калькулятора с римскими числами могут " +
                        "быть только положительные числа");
            }
        }

        return String.valueOf(result);
    }


}