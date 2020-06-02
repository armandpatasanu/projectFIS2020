package org.loose.oose.fis.lab.project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.loose.oose.fis.lab.project.Tools;

import java.io.IOException;

public class UserProfileController {

    @FXML
    private Button logOutButton;
    @FXML
    private Button mainPageButton;

    public void logOutHandler(ActionEvent event) throws IOException {
        Stage prevStage = (Stage) logOutButton.getScene().getWindow();
        prevStage.close();
        Stage stage=new Stage();
        Stage loginStage = Tools.createLoginStage(stage);
        loginStage.show();
    }

    public void backToMainPageHandler(ActionEvent event) throws IOException {
        Stage prevStage = (Stage) mainPageButton.getScene().getWindow();
        prevStage.close();
        Stage stage=new Stage();
        Stage loginStage = Tools.createSearchPage(stage);
        loginStage.show();
    }
}
