package ru.miet.testing;

public class Model {
    /**
     * Вычисляет сумму двух чисел
     */
    public double sum(double a, double b){
        return a + b;
    };


    /**
     * Вычисляет разность двух чисел a - b
     */
    public double subtract(double a, double b){
        return a - b;
    };

    /**
     * Вычисляет произведение двух чисел
     */
    double multiply(double a, double b){
        return a * b;
    };

    /**
     * Вычисляет отношение числа а к числу b.
     * Должен выбросить {@link java.lang.ArithmeticException} если |b| < 10e-8
     */
    double divide(double a, double b) throws Exception {
        if(Math.abs(b) < 0.00000001){
            throw new java.lang.ArithmeticException();
        }
        return a/b;
    };
}
