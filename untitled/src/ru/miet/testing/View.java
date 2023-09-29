package ru.miet.testing;

public class View implements CalculatorView {
    public double firstArg;
    public double secondArg;
    public char operation;
    /**
     * Отображает результат вычисления
     */
    public void printResult(double result){
        System.out.print(result);
    };

    /**
     * Показывает ошибку, например деление на 0, пустые аргументы и прочее
     */
    public void displayError(String message) throws Exception {
        System.out.print(message);
    };

    /**
     * Возвращает значение, введенное в поле первого аргументы
     */
    public String getFirstArgumentAsString(){
        return Double.toString(firstArg);
    };

    /**
     * Возвращает значение, введенное в поле второго аргументы
     */
    public String getSecondArgumentAsString(){
        return Double.toString(secondArg);
    };
}
