import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá");
        calculator();
    }
    public static void calculator() {
        int firstNumber = inputInt("Qual o primerio número: ");
        OperationOption selectedOption = selectOption();
        int secondNumber = inputInt("Qual o segundo número: ");
        doCalcAndPrint(firstNumber, secondNumber, selectedOption);
        if (mustContinue()) {
            calculator();
        } else {
            exit();
        }
    }
    private static void exit() {
        System.out.println("Saindo");
        System. exit(0);
    }
    private static void doCalcAndPrint(int firstNumber, int secondNumber,
                                       OperationOption selectedOption) {
        double result = 0;
        switch (selectedOption) {
            case Sum -> {
                result = firstNumber + secondNumber;
            }
            case Multiply -> {
                result = firstNumber * secondNumber;
            }
            case Divide -> {
                result = (double) firstNumber / secondNumber;
            }
            case Minus -> {
                result = firstNumber - secondNumber;
            }
        }
        String resultMsg = getResultMessage(selectedOption);
        String out = String.format(resultMsg, firstNumber, secondNumber, result);
        System.out.println(out);
    }
    private static String getResultMessage(OperationOption selectedOption) {
        switch (selectedOption) {
            case Sum -> {
                return "%s + %s = %s";
            }
            case Multiply -> {
                return "%s x %s = %s";
            }
            case Divide -> {
                return "%s / %s = %s";
            }
            case Minus -> {
                return "%s - %s = %s";
            }
        }
        return "";
    }
    public static boolean mustContinue()
    {
        String msg = "Para continuar digite s, ou qualquer tecla para sair.";
        String selected = inputString(msg);
        selected = selected.toLowerCase();
        return selected.equals("s");
    }
    public static OperationOption selectOption() {
        String msg = "(0) - Somar\r\n(1) - Multiplicar\r\n(2) - Diminuir\r\n(3) - Dividir\r\n(X) - Sair\n";
        String selected = inputString(msg);
        selected = selected.toLowerCase();
        OperationOption option = null;
        boolean exit = false;
        switch (selected) {
            case "0": option = OperationOption.Sum; break;
            case "1": option = OperationOption.Multiply; break;
            case "2": option = OperationOption.Minus; break;
            case "3": option = OperationOption.Divide; break;
            case "x": exit = true; break;
        }
        if (exit) {
            exit();
        }
        if (option == null) {
            System.out.println("Inválido");
            return selectOption();
        }
        return option;
    }
    public static String inputString(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        String result = scan.nextLine();
        System.out.print("\n");
        return result;
    }
    public static int inputInt(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        int result = scan.nextInt();
        System.out.print("\n");
        return result;
    }
    public enum OperationOption {
        Sum,
        Multiply,
        Divide,
        Minus
    }
}
