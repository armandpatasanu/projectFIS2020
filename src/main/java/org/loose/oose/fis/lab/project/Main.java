package org.loose.oose.fis.lab.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Button b1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello Student");
        b1=new Button();
        b1.setText("Intrebare Vitala");
        b1.setOnAction(e ->{
            boolean result= ConfirmBox.display("Alt window","Iti place FIS?"); // AlertBox.display
            if(result==true)
                System.out.println("Bravo");
            else
                System.out.println("Esti ciudat");
        });

        StackPane layout=new StackPane();
        layout.getChildren().add(b1);

        Scene s1= new Scene(layout,300, 275);
        primaryStage.setScene(s1);
        primaryStage.show();
    }

}
