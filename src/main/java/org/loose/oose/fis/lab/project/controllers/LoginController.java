package org.loose.oose.fis.lab.project.controllers;


import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import static org.loose.oose.fis.lab.project.services.UserService.*;

import org.loose.oose.fis.lab.project.Tools;
import org.loose.oose.fis.lab.project.model.User;
import org.loose.oose.fis.lab.project.services.UserService;
import org.loose.oose.fis.lab.project.services.VideoService;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginController implements Initializable {

    @FXML
    private Text loginErrorText;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    public Button logInButton;
    public static User active_user;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private AnchorPane anchorPane;


    public void closingLogin(MouseEvent event) {
        System.exit(0);
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleLoginAction() throws Exception {
        UserService.loadUsersFromFile();
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username == null || username.isEmpty()) {
            loginErrorText.setText("Please type in a username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginErrorText.setText("Password cannot be empty");
            return;
        }
        if(checkLoginUsername(username))
        {
            if(checkLoginPassword(password,username))
            {
                active_user=getUser(username);
                Stage prevStage = (Stage) logInButton.getScene().getWindow();
                prevStage.close();
                Stage stage=new Stage();
                Stage profileStage = Tools.createSearchPage(stage);
                profileStage.show();
            }
            else
                loginErrorText.setText("The password is incorrect!");
        }
        else
            loginErrorText.setText("Enter a valid account!");

    }

    public void openCreateAccountHandler(ActionEvent event) throws IOException {
        try {
            Parent viewCreateAccountRoot = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Register.fxml"));
            Scene loginScene=logInButton.getScene();
            viewCreateAccountRoot.translateYProperty().set(loginScene.getHeight());
            rootPane.getChildren().add(viewCreateAccountRoot);
            Timeline timeline=new Timeline();
            KeyValue keyValue=new KeyValue(viewCreateAccountRoot.translateYProperty(),0, Interpolator.EASE_IN);
            KeyFrame keyFrame=new KeyFrame(Duration.seconds(1),keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            timeline.setOnFinished((ActionEvent event2)->{
                rootPane.getChildren().remove(anchorPane);
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
