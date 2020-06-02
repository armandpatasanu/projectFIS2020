package org.loose.oose.fis.lab.project.controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

public class RegisterController {
    @FXML
    private Button createAccButton;
    @FXML
    private Text registerMessage;
    @FXML
    private TextField fnamefield;
    @FXML
    private TextField lnamefield;
    @FXML
    private TextField userfield;
    @FXML
    private TextField emailfield;
    @FXML
    private TextField passwordfield;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Label lblRegister;

    public void createAccountHandler(ActionEvent event) {
        String firstname = fnamefield.getText();
        String lastname = lnamefield.getText();
        String user = userfield.getText();
        String pass = passwordfield.getText();
        String email = emailfield.getText();


    }

    public void backToLoginHandler(ActionEvent event) throws IOException
    {
        try {
            Parent viewCreateAccountRoot = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Login.fxml"));
            Scene registerScene = lblRegister.getScene();
            viewCreateAccountRoot.translateYProperty().set(registerScene.getHeight());
            AnchorPane rootPane = (AnchorPane) registerScene.getRoot();
            rootPane.getChildren().add(viewCreateAccountRoot);
            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(viewCreateAccountRoot.translateYProperty(), 0, Interpolator.EASE_IN);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            timeline.setOnFinished((ActionEvent event2) -> {
                rootPane.getChildren().remove(anchorpane);
            });
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
