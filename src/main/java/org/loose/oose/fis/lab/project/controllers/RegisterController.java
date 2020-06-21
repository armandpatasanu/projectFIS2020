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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.loose.oose.fis.lab.project.exceptions.EmailAlreadyUsedException;
import org.loose.oose.fis.lab.project.exceptions.UsernameAlreadyExistsException;
import org.loose.oose.fis.lab.project.services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private Text registerMessage;
    @FXML
    private TextField fnamefield=new TextField();
    @FXML
    private TextField lnamefield=new TextField();
    @FXML
    private TextField userfield=new TextField();
    @FXML
    private TextField emailfield=new TextField();
    @FXML
    private TextField passwordfield=new TextField();
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Label lblRegister;

    public Text getRegisterMessage() {
        return registerMessage;
    }

    public void setRegisterMessage(Text registerMessage) {
        this.registerMessage = registerMessage;
    }

    public TextField getFnamefield() {
        return fnamefield;
    }

    public void setFnamefield(TextField fnamefield) {
        this.fnamefield = fnamefield;
    }

    public TextField getLnamefield() {
        return lnamefield;
    }

    public void setLnamefield(TextField lnamefield) {
        this.lnamefield = lnamefield;
    }

    public TextField getUserfield() {
        return userfield;
    }

    public void setUserfield(TextField userfield) {
        this.userfield = userfield;
    }

    public TextField getEmailfield() {
        return emailfield;
    }

    public void setEmailfield(TextField emailfield) {
        this.emailfield = emailfield;
    }

    public TextField getPasswordfield() {
        return passwordfield;
    }

    public void setPasswordfield(TextField passwordfield) {
        this.passwordfield = passwordfield;
    }

    public void createAccountHandler() {
        String firstname = fnamefield.getText();
        String lastname = lnamefield.getText();
        String user = userfield.getText();
        String pass = passwordfield.getText();
        String email = emailfield.getText();

        if (firstname == null || firstname.isEmpty()) {
            registerMessage.setText("Please type in your first name!");
            return;
        }
        if (lastname == null || lastname.isEmpty()) {
            registerMessage.setText("Please type in your last name!");
            return;
        }
        if (user == null || user.isEmpty()) {
            registerMessage.setText("Please type in a username!");
            return;
        }

        if (pass == null || pass.isEmpty()) {
            registerMessage.setText("Password cannot be empty");
            return;
        }
        if (email == null || email.isEmpty()) {
            registerMessage.setText("A valid email must be entered!");
            return;
        } else
            try {
                UserService.addUser(fnamefield.getText(), lnamefield.getText(), userfield.getText(), emailfield.getText(), passwordfield.getText());
                Parent viewCreateAccountRoot = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Login.fxml"));
                Scene registerScene = lblRegister.getScene();
                viewCreateAccountRoot.translateYProperty().set(registerScene.getHeight());
                AnchorPane rootPane = (AnchorPane) registerScene.getRoot();
                rootPane.getChildren().add(viewCreateAccountRoot);
                Timeline timeline = new Timeline();
                KeyValue keyValue = new KeyValue(viewCreateAccountRoot.translateYProperty(), 0, Interpolator.EASE_IN);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
                timeline.setOnFinished((ActionEvent event2) -> {
                    rootPane.getChildren().remove(anchorpane);
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UsernameAlreadyExistsException e) {
                registerMessage.setText(e.getMessage());
            } catch (EmailAlreadyUsedException e) {
                registerMessage.setText(e.getMessage());
            }

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
