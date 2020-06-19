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

    public static String current_category;

    public void openProfileHandler(ActionEvent event) throws IOException {
        Stage prevStage = (Stage) myProfileButton.getScene().getWindow();
        prevStage.close();
        Stage stage=new Stage();
        Stage profileStage = createProfileStage(stage);
        profileStage.show();

    }

    public void AnimalsHandler(ActionEvent event) throws IOException{
        buttonClicked("Animals");
    }
    public void CarsHandler(ActionEvent event) throws IOException{
        buttonClicked("Cars");
    }
    public void FoodHandler(ActionEvent event) throws IOException{
        buttonClicked("Food");
    }
    public void FunnyHandler(ActionEvent event) throws IOException{
        buttonClicked("Funny");
    }
    public void GamingHandler(ActionEvent event) throws IOException{
        buttonClicked("Gaming");
    }
    public void NatureHandler(ActionEvent event) throws IOException{
        buttonClicked("Nature");
    }
    public void MusicHandler(ActionEvent event) throws IOException{
        buttonClicked("Music");
    }
    public void SportsHandler(ActionEvent event) throws IOException{
        buttonClicked("Sports");
    }

    public void buttonClicked(String category) throws IOException{

    }

    public void xPressedHandler(){
        System.exit(0);
    }
}
