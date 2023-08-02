import java.io.IOException;
import java.util.Arrays;
import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите пример");
        String inputData = s.nextLine();
        System.out.println(calc(inputData));
    }

    public static String calc(String input) {
        int str1, str2;
        boolean check = true;
        String[] massiv = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        //System.out.println(Arrays.asList(massiv).indexOf("X"));
        if (input.split(" ").length != 3) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return ("Должно быть 2 числа и знак");
            }
        }

        if (Arrays.asList(massiv).contains(input.split(" ")[0]) && Arrays.asList(massiv).contains(input.split(" ")[2])) {
            str1 = Arrays.asList(massiv).indexOf(input.split(" ")[0]) + 1;
            str2 = Arrays.asList(massiv).indexOf(input.split(" ")[2]) + 1;
        } else {
            try {
                str1 = Integer.parseInt(input.split(" ")[0]);
                str2 = Integer.parseInt(input.split(" ")[2]);
                check = false;
            } catch (Exception e) {
                return ("используются одновременно разные системы счисления или число не целое");
            }
        }

        if (str1 < 1 || str1 > 10 || str2 < 1 || str2 > 10) {
            try {
                throw new IOException();
            } catch (Exception e) {
                return ("Числа должны быть от 1 до 10");
            }
        }


        String znak = input.split(" ")[1];
        String result;

        switch (znak) {
            case "+":
                result = Integer.toString(str1 + str2);
                break;
            case "-":
                result = Integer.toString(str1 - str2);
                if (check && (Integer.parseInt(result) <= 0)) {
                    try {
                        throw new IOException();
                    } catch (Exception e) {
                        return ("Римские цифры не могут быть отрицательные");
                    }

                }
                break;
            case "*":
                result = Integer.toString(str1 * str2);
                break;
            case "/":
                result = Integer.toString(str1 / str2);
                break;
            default: {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    return ("Неизвестный знак");
                }
            }
        }
        if (check) {
            int number = Integer.parseInt(result);
            result = "";
            for (RIM numeral : RIM.values()) {
                while (number >= numeral.getConvertion()) {
                    number -= numeral.getConvertion();
                    result += numeral;

                }
            }
            return (result);
        } else
            return (result);
    }
}