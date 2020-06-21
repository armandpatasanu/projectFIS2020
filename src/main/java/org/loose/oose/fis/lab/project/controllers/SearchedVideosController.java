package org.loose.oose.fis.lab.project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.loose.oose.fis.lab.project.model.Video;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.loose.oose.fis.lab.project.Tools.createProfileStage;
import static org.loose.oose.fis.lab.project.Tools.createSearchPage;
import static org.loose.oose.fis.lab.project.controllers.SearchPageController.current_category;
import static org.loose.oose.fis.lab.project.services.VideoService.*;

public class SearchedVideosController implements Initializable {

    @FXML
    private Button myProfileB;
    @FXML
    private Label l;
    @FXML
    private ListView<HBox> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        putSearchedVideo(this);

        try {
            setSearchedVideos(current_category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void myProfileHandler(ActionEvent event) throws IOException {
        Stage prevStage = (Stage) myProfileB.getScene().getWindow();
        prevStage.close();
        Stage stage=new Stage();
        Stage profileStage = createProfileStage(stage);
        profileStage.show();
    }

    public void backToMainHandler(ActionEvent event) throws IOException {
        Stage prevStage = (Stage) myProfileB.getScene().getWindow();
        prevStage.close();
        Stage stage=new Stage();
        Stage profileStage = createSearchPage(stage);
        profileStage.show();
    }

    public ListView<HBox> getList() { return list; }

    public void setList(ListView<HBox> list) { this.list = list; }

    public void setMessage(String message){
        l.setText(message);
    }

    public String getMessage(){
        return l.getText();
    }

    public void xPressedHandler(){
        System.exit(0);
    }
}
