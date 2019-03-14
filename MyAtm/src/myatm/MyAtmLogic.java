package myatm;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyAtmLogic extends Application {

    public int balance = 0;
    public static void main(String[] args) {
        launch(args);
    }

    public boolean log(String pin) {
        return "0000".equals(pin);
    }

    boolean with(int x) {
        if (x > balance) {
            return false;
        } else {
            balance = balance - x;
            return true;
        }
    }

    void depo(int y) {
        balance = balance + y;
    }

    int balanceInquiry() {
        return balance;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        MyAtmGui gui = new MyAtmGui(primaryStage);
        gui.GenGui();
        primaryStage.setTitle("My Weird ATM");
        primaryStage.setScene(gui.getScene1());
        primaryStage.show();
    }
}
