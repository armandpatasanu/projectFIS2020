package org.loose.oose.fis.lab.project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static org.loose.oose.fis.lab.project.Tools.createProfileStage;

public class SearchPageController {

    @FXML
    private Button myProfileButton;

    public void openProfileHandler(ActionEvent event) throws IOException {
        Stage prevStage = (Stage) myProfileButton.getScene().getWindow();
        prevStage.close();
        Stage stage=new Stage();
        Stage profileStage = createProfileStage(stage);
        profileStage.show();

    }
}
