import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        System.out.println("Введите выражение");
        Scanner scanner = new Scanner(System.in);

        //Приводим строку в порядок, делаем все буквы заглавными, убираем все пробелы
        String exp = scanner.nextLine().toUpperCase().replaceAll("\\s", "");
        String[] expression = new String[2];

        //Опредялем оператор действия, добавляем к нему пробелы для удобства разделения строки
        try {
            if (exp.contains(Character.toString('+'))) {
                expression = exp.replace("+", " + ").split("\\s");
            } else if (exp.contains(Character.toString('-'))) {
                expression = exp.replace("-", " - ").split("\\s");
            } else if (exp.contains(Character.toString('*'))) {
                expression = exp.replace("*", " * ").split("\\s");
            } else if (exp.contains(Character.toString('/'))) {
                expression = exp.replace("/", " / ").split("\\s");
            } else {
                throw new UnsupportedOperationException("Неверный знак оператора");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        char operator = expression[1].charAt(0);
        int num1 = 0;
        int num2 = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean parse1 = false;
        boolean parse2 = false;

        //Проверяем наличие римских цифр
        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equals(expression[0])) {
                flag1 = true;
            }
        }
        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equals(expression[2])) {
                flag2 = true;
            }
        }

        //Ловим исключение, когда имеется только одна римская цифра
        try
        {
            if ((flag1 && !flag2) || (!flag1 && flag2))
            {
                throw new IllegalArgumentException("Введите только римские или только арабские цифры");
            }
        }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                System.exit(0);
            }

            if (flag1 && flag2)
            {
                num1 = RomanToNumber.romanToNumber(expression[0]);
                num2 = RomanToNumber.romanToNumber(expression[2]);
                System.out.println(IntToRoman.integerToRoman(Calculator.calculate(num1, num2, operator)));
            }
            else
                {
                    //Ловим исключение, когда невозможно парсить в Int
                try
                {
                    parse1 = Calculator.isParsable(expression[0]);
                    parse2 = Calculator.isParsable(expression[2]);
                    if (parse1 && parse2)
                    {
                        num1 = Integer.parseInt(expression[0]);
                        num2 = Integer.parseInt(expression[2]);
                    }

                    //Ловим исключение, когда цифра больше 10 или меньше 0
                    if ((num1 > 10) || (num1 < 0) || (num2 > 10) || (num2 < 0) )
                    {
                        throw new IllegalArgumentException("Числа не должны быть больше 10 и меньше 0");
                    }
                    System.out.println(Calculator.calculate(num1, num2, operator));
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }

            }
        }

    }