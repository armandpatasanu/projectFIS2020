package org.loose.oose.fis.lab.project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;
    public static boolean display(String title, String message) {
        Stage s = new Stage();
        Button yB,nB;

        nB=new Button("Nu");
        nB.setOnAction(e -> {
            answer=false;
            s.close();
        });
        yB=new Button("Da");
        yB.setOnAction(e -> {
            answer=true;
            s.close();
        });

        s.initModality(Modality.APPLICATION_MODAL);
        s.setTitle(title);
        s.setMinWidth(500);

        Label l1=new Label();
        l1.setText(message);

        VBox layout =new VBox(11);
        layout.getChildren().addAll(l1,yB,nB);
        layout.setAlignment(Pos.CENTER);

        Scene sc = new Scene(layout);
        s.setScene(sc);
        s.showAndWait();

        return answer;
    }
}
