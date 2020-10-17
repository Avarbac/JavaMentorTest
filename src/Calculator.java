public class Calculator
{
    public Calculator(){}

    public static int calculate(int num1, int num2, char operator){
        int result = 0;
        switch (operator){
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
            default:throw  new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

    //Проверяем возможость парсить в Int
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e)
        {
            System.out.println("Ошибка в вводе");
            return false;
        }
    }
}
