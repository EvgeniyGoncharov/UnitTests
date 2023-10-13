package ru.miet.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements CalculatorView {
    public double firstArg = 0;
    public double secondArg = 0;
    public char operation;
    public Error er;
    public static class Error extends JFrame {
        JLabel l;
        public Error(String s){
            super(s);
            setLayout(new FlowLayout());
            l = new JLabel("ОШИБКА!\n Делить на ноль нельзя, измените второе число");
            add(l);
        }
    }
    /**
     * Отображает результат вычисления
     */
    public void printResult(double result){
        System.out.print(result);
    };

    /**
     * Показывает ошибку, например деление на 0, пустые аргументы и прочее
     */
    public void displayError(String message){
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

    public void DisplayError(){
        er = new Error("ОШИБКА! ДЕЛЕНИЕ НА НОЛЬ!");
        er.setVisible(true);
        er.setSize(500,200);
    }

}
