package ru.miet.testing;

import java.io.IOException;
import java.util.Scanner;

public class Controller implements CalculatorPresenter{
    Scanner s = new Scanner(System.in);
    Model model = new Model();
    View view = new View();
    public double firstArg;
    public double secondArg;
    public double res;
    public char operation;


    public void start() throws Exception {
        try{
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
        }
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
        if(operation == '*'){
            view.printResult(model.multiply(firstArg, secondArg));
        }
    };
}
