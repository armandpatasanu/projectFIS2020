package org.loose.oose.fis.lab.project.controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import org.loose.oose.fis.lab.project.services.UserService;


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
    @FXML
    private Label lblLogin;

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

    }

    public void openCreateAccountHandler(ActionEvent event) {
    }
}
