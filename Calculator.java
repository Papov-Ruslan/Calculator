import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println(calc(expression));


    }

    private static boolean checkOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) { // сравниваем s с строкой указанной в скобках, если они равны - возвращает true иначе false
            return true;
        }
        return false;
    }

    private static boolean isCorrectArabicInput(String operand) {
        if (
                operand.equals("1") || operand.equals("2") || operand.equals("3") ||
                        operand.equals("4") || operand.equals("5") || operand.equals("6") ||
                        operand.equals("7") || operand.equals("8") || operand.equals("9") ||
                        operand.equals("10")) {
            return true;
        }
        return false;
    }

    private static boolean isCorrectRomanInput(String operand) {
        if (
                operand.equals("I") || operand.equals("II") || operand.equals("III") ||
                        operand.equals("IV") || operand.equals("V") || operand.equals("VI") ||
                        operand.equals("VII") || operand.equals("VIII") || operand.equals("IX") ||
                        operand.equals("X")) {
            return true;
        }
        return false;
    }

    private static int calcOperation(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        }
        return a / b;
    }

    private static int convertFromRoman(String s) {
        if (s.equals("I")) {
            return 1;
        }
        if (s.equals("II")) {
            return 2;
        }
        if (s.equals("III")) {
            return 3;
        }
        if (s.equals("IV")) {
            return 4;
        }
        if (s.equals("V")) {
            return 5;
        }
        if (s.equals("VI")) {
            return 6;
        }
        if (s.equals("VII")) {
            return 7;
        }
        if (s.equals("VIII")) {
            return 8;
        }
        if (s.equals("IX")) {
            return 9;
        }
        if (s.equals("X")) {
            return 10;
        }
        return -1;
    }

    private static String convertToRoman(int a) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[a];
        return s;
    }
    public static String calc(String input) {
        /* посчитать результат выражения и вернуть */
        String[] tokens = input.split(" ");
        if (tokens.length == 3) {
            // tokens[0] - a
            // tokens[1] - оператор
            // tokens[2] - b
            if (checkOperator(tokens[1])) {
                if (isCorrectArabicInput(tokens[0]) && isCorrectArabicInput(tokens[2])) {
                    int result = calcOperation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[2]), tokens[1]);
                    return String.valueOf(result);
                }
                if (isCorrectRomanInput(tokens[0]) && isCorrectRomanInput(tokens[2])) {
                    int result = calcOperation(convertFromRoman(tokens[0]), convertFromRoman(tokens[2]), tokens[1]);
                    if (result > 0) {
                        return convertToRoman(result);
                    } else {
                        throw new RuntimeException("Roman numbers can't be less or equal zero");
                    }
                }
                throw new RuntimeException("Systems of numbers must be same/or your input incorrect");
            } else {
                throw new RuntimeException("Incorrect operator");
            }
        }
        throw new RuntimeException("Incorrect size of input");
    }
}