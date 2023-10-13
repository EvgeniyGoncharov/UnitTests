package ru.miet.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Controller implements CalculatorPresenter{
    Scanner s = new Scanner(System.in);
    static Model model = new Model();
    static View view = new View();
    public static double firstArg = 0;
    public static double secondArg = 1;
    public static double res;
    public char operation;
    public static class Window extends JFrame {
        JLabel l1, l2, l3, l4;
        JTextField t1, t2;
        String op[] = new String[3];
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        eHandler handler = new eHandler();
        public Window(String s){
            super(s);
            setLayout(new FlowLayout());
            plus.addActionListener(handler);
            minus.addActionListener(handler);
            multiply.addActionListener(handler);
            divide.addActionListener(handler);

            l1 = new JLabel("Введите первое число");
            l2 = new JLabel("Введите второе число");
            l3 = new JLabel();
            l4 = new JLabel();
            JLabel l5 = new JLabel("Выберите операцию");
            t1 = new JTextField(10);
            t2 = new JTextField(10);
            t1.setText("1");
            t2.setText("1");
            add(l5, BorderLayout.CENTER);
            add(plus);
            add(minus);
            add(multiply);
            add(divide);

            add(l1);
            add(t1);
            add(l2);
            add(t2);
            add(l3);
            add(l4);

            }
        class eHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == plus){
                    op[0] = t1.getText();
                    op[1] = t2.getText();
                    l3.setText("Результат = " + Double.toString(model.sum(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()))));
                }
                if(e.getSource() == minus){
                    op[0] = t1.getText();
                    op[1] = t2.getText();
                    l3.setText("Результат = " + Double.toString(model.subtract(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()))));
                }
                if(e.getSource() == multiply){
                    op[0] = t1.getText();
                    op[1] = t2.getText();
                    l3.setText("Результат = " + Double.toString(model.multiply(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()))));
                }
                if(e.getSource() == divide){
                    op[0] = t1.getText();
                    op[1] = t2.getText();
                    try {
                        l3.setText("Результат = " + Double.toString(model.divide(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()))));
                    } catch (Exception ex) {
                        DisplayError();
                    }
                }
            }


        }
    }
    public static void DisplayError(){
        view.DisplayError();
    }
    public void start() throws Exception {
        Window win = new Window("калькулятор");
        win.setVisible(true);
        win.setSize(350, 300);
        win.setResizable(false);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**try{
            while (operation != '+' & operation != '-' & operation != '*' & operation != '/'){
                System.out.println("Введите операцию которую хотите произвести (+ - * /): ");
                operation = s.nextLine().charAt(0);
            }

            System.out.println("Введите первый аргумент: ");
            firstArg = s.nextDouble();
            System.out.println("Введите второй аргумент: ");
            secondArg = s.nextDouble();
        }catch (Exception e){
            view.displayError(String.valueOf(e));
        }
        switch (operation){
            case '+':
                this.onPlusClicked();
                break;
            case '-':
                this.onMinusClicked();
                break;
            case '*':
                this.onMultiplyClicked();
                break;
            case '/':
                this.onDivideClicked();
                break;
        }*/
    }
    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '+'
     */
    public void onPlusClicked(){
        view.printResult(model.sum(firstArg, secondArg));
    };

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '-'
     */
    public void onMinusClicked(){
        view.printResult(model.subtract(firstArg, secondArg));
    };

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '/'
     */
    public void onDivideClicked() throws Exception {
        try{
            res = model.divide(firstArg, secondArg);
            view.printResult(res);
        }catch (Exception e){
            view.displayError(String.valueOf(e));
        }

    };

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '*'
     */
    public void onMultiplyClicked() throws Exception {
        view.printResult(model.multiply(firstArg, secondArg));
    };
}
