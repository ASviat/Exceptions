class Answer {
  
    public static void arrayOutOfBoundsException() {
        throw new ArrayIndexOutOfBoundsException();
      
}

    public static void divisionByZero() {
        int first = 5;
        int second = 0;
        int last = first / second;
      
}

    public static void numberFormatException() {
        throw new NumberFormatException();
       
 }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}