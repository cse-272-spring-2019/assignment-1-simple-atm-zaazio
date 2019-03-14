package myatm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyAtmGui {
    String hist[][] = new String[10][2];
    public MyAtmLogic auth;
    public Stage stage;
    public Scene scene1, scene2, scene3;
    public int flag, amount = 0,i=0,j=0,p=0,count=0;

    public void GenGui() {
        auth = new MyAtmLogic();
//setting loginPage-------------------------------------------------------------
        Button login = new Button("Login");
        Label hint = new Label("Enter Pin (hint: 0000)");
        TextField pin = new TextField();
        GridPane loginpage = new GridPane();
        loginpage.setMinSize(400, 200);
        loginpage.setAlignment(Pos.CENTER);
        loginpage.add(hint, 300, 100);
        loginpage.add(pin, 300, 200);
        loginpage.add(login, 300, 250);
        scene1 = new Scene(loginpage);
//setting menu------------------------------------------------------------------
        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");
        Button balanceinquiry = new Button("Balance Inquiry");
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        Label bal = new Label(""+auth.balanceInquiry()+"$");
        GridPane menu = new GridPane();
        menu.setMinSize(400, 200);
        menu.setVgap(1);
        menu.setHgap(1);
        menu.add(withdraw, 0, 0);
        menu.add(deposit, 200, 0);
        menu.add(balanceinquiry, 400, 0);
        menu.add(previous, 0, 200);
        menu.add(next, 400, 200);
        menu.add(bal, 200, 100);
        scene2 = new Scene(menu);
//setting keypad----------------------------------------------------------------
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button zero = new Button("0");
        Button confirm = new Button("Confirm");
        Button bckspce = new Button("<-");
        Label number = new Label("" + amount+"$");
        GridPane keypad = new GridPane();
        keypad.setMinSize(400, 200);
        keypad.setAlignment(Pos.CENTER);
        number.setWrapText(true);
        number.setMaxWidth(Double.MAX_VALUE);
        keypad.setVgap(10);
        keypad.setHgap(10);
        keypad.add(one, 0, 1);
        keypad.add(two, 1, 1);
        keypad.add(three, 2, 1);
        keypad.add(four, 0, 2);
        keypad.add(five, 1, 2);
        keypad.add(six, 2, 2);
        keypad.add(seven, 0, 3);
        keypad.add(eight, 1, 3);
        keypad.add(nine, 2, 3);
        keypad.add(zero, 1, 4);
        keypad.add(confirm, 5, 3);
        keypad.add(bckspce, 5, 0);
        keypad.add(number, 2, 0);
        scene3 = new Scene(keypad);
//setting button actions--------------------------------------------------------
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String p = pin.getText();
                boolean v = auth.log(p);
                if (v) {
                    stage.setScene(scene2);
                } else {
                    hint.setText("Error! pin must be 0000");
                }
            }

        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amount=0;
                stage.setScene(scene3);
                number.setText("" + amount + "$");
                flag = 0;
            }

        });
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amount=0;
                stage.setScene(scene3);
                number.setText("" + amount + "$");
                flag = 1;
            }

        });
        balanceinquiry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bal.setText("" +auth.balanceInquiry()+"$");
                hist[i][j]="Balance Inquired ";
                hist[i][j+1]=(""+auth.balanceInquiry());
                i++;
                p=i;
            }

        });
        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            if((p-1)<0) {
                bal.setText("NuLL");
                for(int t=0 ; t<24000;t++);
                bal.setText(""+hist[p][j]+" "+hist[p][j+1]);
            } else {
                p--;
                bal.setText(""+hist[p][j]+" "+hist[p][j+1]);
            }
            }

        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            if((p+1)>9 || hist[p+1][j]==null) {
                bal.setText("NuLL");
                for(int t=0 ; t<24000;t++);
                bal.setText(""+hist[p][j]+" "+hist[p][j+1]);
            } else {
                p++;
                bal.setText(""+hist[p][j]+" "+hist[p][j+1]);
            }
            }

        });
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 1;
                } else {
                    amount *= 10;
                    amount += 1;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 2;
                } else {
                    amount *= 10;
                    amount += 2;
                }
                number.setText("" + amount + "$");
                count++;}

            }

        });
        three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 3;
                } else {
                    amount *= 10;
                    amount += 3;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 4;
                } else {
                    amount *= 10;
                    amount += 4;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 5;
                } else {
                    amount *= 10;
                    amount += 5;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 6;
                } else {
                    amount *= 10;
                    amount += 6;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 7;
                } else {
                    amount *= 10;
                    amount += 7;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 8;
                } else {
                    amount *= 10;
                    amount += 8;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 9;
                } else {
                    amount *= 10;
                    amount += 9;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(count<=7){
                if (amount == 0) {
                    amount += 0;
                } else {
                    amount *= 10;
                    amount += 0;
                }
                number.setText("" + amount + "$");
                count++;}
            }

        });
        bckspce.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (amount!=0) {
                    amount /=10;
                }
                number.setText("" + amount+"$");
                count--;
            }

        });
        confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (flag == 1) {
                    auth.depo(amount);
                    stage.setScene(scene2);
                    hist[i][j]="Deposited";
                    hist[i][j+1]=(""+amount);
                    i++;
                    p=i;
            
                }else{
                    boolean z=auth.with(amount);
                    if(z){
                        stage.setScene(scene2);
                        hist[i][j]="Withdrawn";
                        hist[i][j+1]=(""+amount);
                        i++;
                        p=i;
            
                    }
                    else{
                        number.setText("Insufficient Funds");
                }
                }
                }
        });
}
//getters & setters-------------------------------------------------------------
public Scene getScene1() {
    return this.scene1;   
    }
public Scene getScene2() {
        return scene2;
    }
public Scene getScene3() {
        return scene3;
    }
public MyAtmGui(Stage stage) {
        this.stage = stage;
    }
}