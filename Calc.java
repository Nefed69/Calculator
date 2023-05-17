import components.RomanConverter;
import components.ArabCalcul;
import java.util.Scanner;
public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Boolean proverka1 = proverkфArabic(input);
        Boolean proverka2 = proverkaRoman(input);
        String resultRomanToArabic;
        if ((!proverka1) & (!proverka2)) {
            throw new Exception();
        }
        if (proverka1) {
            String output = Calculator(input);
            System.out.println(output);
        }
        if (proverka2) {
            resultRomanToArabic = romanToArabic(input);
            String output2= Calculator(resultRomanToArabic);
            String resultRoman = arabToRoman(output2);
            System.out.println(resultRoman);

        }
    }

    public static boolean proverkфArabic(String inputArab) {
        String[] checks = inputArab.split(" ");
        boolean a = true;
        boolean b = true;
        String arabNumber1 = checks[0];
        String arabNumber2 = checks[2];
        String[] arab = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (String elements1 : arab) {
            a = arabNumber1.equals(elements1);
            if (a) {
                break;
            }
            for (String elements2 : arab) {
                b = arabNumber2.equals(elements2);
                if (b) {
                    break;
                }
            }
        }
        return a & b;
    }

    public static boolean proverkaRoman(String inputRoman) {
        String[] checks = inputRoman.split(" ");
        boolean a = true;
        boolean b = true;
        String romanNumber1 = checks[0];
        String romanNumber2 = checks[2];
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (String elements1 : roman) {
            a = romanNumber1.equals(elements1);
            if (a) {
                break;
            }
            for (String elements2 : roman) {
                b = romanNumber2.equals(elements2);
                if (b) {
                    break;
                }
            }
        }
        return a & b;
    }

    public static String romanToArabic(String input) {
        String[] convert = input.split(" ");
        String rom1 = convert[0];
        String rom2 = convert[2];
        RomanConverter con1 = RomanConverter.valueOf(rom1);
        String str1 = con1.getArab();
        RomanConverter con2 = RomanConverter.valueOf(rom2);
        String str2 = con2.getArab();
        String result = str1 + " " + convert[1] + " " + str2;
        return result;
    }

    public static String arabToRoman(String input) {
        int num = Integer.parseInt(input);
        RomanConverter con = RomanConverter.values()[num - 1];
        return con.name();
    }

    public static String Calculator(String input) throws Exception {
        String[] numbers = input.split(" ");
        if (numbers.length == 3) {
            String num1 = numbers[0];
            String operat = numbers[1];
            String num2 = numbers[2];
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            ArabCalcul arabCalcul=new ArabCalcul(a,b);
            if (a < 0 || a > 10 || b < 0 || b > 10) {
                throw new Exception();
            }

            switch (operat) {
                case "+":
                    arabCalcul.addition();
                break;
                case "-":
                    arabCalcul.subtraction();
                break;
                case "*":
                    arabCalcul.multiplication();
                break;
                case "/":
                    arabCalcul.division();
                    break;
                default:
                    throw new Exception();
            }
            return Integer.toString(arabCalcul.getResult());

        } else throw new Exception();
    }
}
