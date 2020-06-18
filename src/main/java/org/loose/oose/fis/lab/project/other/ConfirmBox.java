package org.loose.oose.fis.lab.project.other;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    public static boolean answer = false;
    public static boolean display(String message) {
        Stage s = new Stage();
        s.initModality(Modality.APPLICATION_MODAL);
        s.setMinWidth(200);
        s.setMinHeight(100);
        Label l = new Label();
        l.setText(message);
        VBox v = new VBox(20);
        v.setAlignment(Pos.CENTER);
        HBox h = new HBox(50);
        h.setAlignment(Pos.CENTER);
        Button bDa = new Button("Da");
        Button bNu = new Button("Nu");
        h.getChildren().addAll(bDa, bNu);
        v.getChildren().addAll(l, h);

        bDa.setOnAction(e -> {
            answer = true;
            s.close();
        });
        bNu.setOnAction(e -> {
            answer = false;
            s.close();
        });

        Scene sc = new Scene(v, 200 ,100);
        s.setScene(sc);
        s.showAndWait();
        return answer;
    }
}
