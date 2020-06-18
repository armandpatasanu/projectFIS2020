package org.loose.oose.fis.lab.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.loose.oose.fis.lab.project.Tools;
import org.loose.oose.fis.lab.project.services.VideoService;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static org.loose.oose.fis.lab.project.services.VideoService.active_video;

public class EditVideoController implements Initializable {
    @FXML
    private AnchorPane videoPane;
    @FXML
    private ImageView thumbnailPhoto;
    @FXML
    private TextField titleTF, thumbnailTF;
    @FXML
    private TextArea descriptionTA;
    @FXML
    private ChoiceBox<String> categoryCB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleTF.setText(active_video.getTitle());
        thumbnailTF.setText(active_video.getThumbnail_path());
        descriptionTA.setText(active_video.getDescription());
        categoryCB.getItems().addAll("Animals","Cars","Food","Funny","Gaming","Nature","Music","Sports");
        categoryCB.setValue(active_video.getCategory());
    }

    public void handleImageSearcher(){
        final FileChooser filechooser = new FileChooser();
        Stage stage = (Stage) videoPane.getScene().getWindow();
        File file= filechooser.showOpenDialog(stage);
        if(file!=null)
        {
            Image im = new Image(file.toURI().toString());
            thumbnailPhoto.setImage(im);
            thumbnailPhoto.setStyle("-fx-border-color:black;-fx-border-width:thin;");
            thumbnailTF.setText(file.toURI().toString());
        }
    }

    public void handleSave(){
        if(titleTF.getText().equals("") || thumbnailTF.getText().equals("") || categoryCB.getValue().equals("")
         || titleTF.getText().isEmpty() || thumbnailTF.getText().isEmpty() || categoryCB.getValue().isEmpty()){
            Tools.AlertBox("Please enter valid data!");
        }
        else {
            active_video.setCategory(categoryCB.getValue());
            active_video.setDescription(descriptionTA.getText());
            active_video.setThumbnail_path(thumbnailTF.getText());
            active_video.setTitle(titleTF.getText());
            VideoService.persistVideos();
        }
        Stage s = (Stage) videoPane.getScene().getWindow();
        s.close();
    }
}
