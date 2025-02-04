package estrutura_dados_colecoes.lista_duplamente_encadeada.exceptions;

public class CalculatorConundrum {

    public static void main(String[] args) {
        CalculatorConundrum calculator = new CalculatorConundrum();
        System.out.println(calculator.calculate(16, 51, "+")); // "16 + 51 = 67"
        System.out.println(calculator.calculate(32, 6, "*"));  // "32 * 6 = 192"
        System.out.println(calculator.calculate(512, 4, "/")); // "512 / 4 = 128"
        System.out.println(calculator.calculate(512, 4, "**")); // "512 / 4 = 128"
        System.out.println(calculator.calculate(0, 4, "/")); // "512 / 4 = 128"
    }

    private static String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        try {
            switch (operation) {
                case "+":
                    return operand1 + " + " + operand2 + " = " + (operand1 + operand2);
                case "*":
                    return operand1 + " * " + operand2 + " = " + (operand1 * operand2);
                case "/":
                    if (operand2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    return operand1 + " / " + operand2 + " = " + (operand1 / operand2);
                default:
                    throw new IllegalOperationException("Operation '" + operation + "' does not exist");
            }
        } catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }
    }

}

