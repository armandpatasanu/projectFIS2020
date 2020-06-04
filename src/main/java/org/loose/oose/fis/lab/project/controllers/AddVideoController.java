package org.loose.oose.fis.lab.project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.loose.oose.fis.lab.project.Tools;
import org.loose.oose.fis.lab.project.services.VideoService;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static org.loose.oose.fis.lab.project.controllers.LoginController.active_user;

public class AddVideoController implements Initializable {

    private WatchVideosController wvc;
    @FXML
    private TextField videoTitleValue;
    @FXML
    private TextArea videoDescriptionValue;
    @FXML
    private Text addVideoErrorText;
    @FXML
    private ChoiceBox<String> categoryChoiceBox;
    @FXML
    private AnchorPane videoPane;
    @FXML
    private MediaView addVideoMedia;
    @FXML
    private TextField videoPathValue;
    @FXML
    private TextField thumbnailPathValue;
    @FXML
    private ImageView videoThumbnail;
    private File file;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        categoryChoiceBox.getItems().addAll("Animals","Cars","Food","Funny","Gaming","Nature","Music","Sports");
    }
    public void searchVideoHandler(ActionEvent event) {
        final FileChooser filechooser = new FileChooser();
        Stage stage = (Stage) videoPane.getScene().getWindow();
        file= filechooser.showOpenDialog(stage);
        if(file!=null)
        {
            Media media = new Media(file.toURI().toString());
            MediaPlayer mediaplayer = new MediaPlayer(media);
            videoPathValue.setText(file.toURI().toString());
            addVideoMedia.setMediaPlayer(mediaplayer);
            addVideoMedia.setStyle("-fx-border-color:black;-fx-border-width:thin;");
        }
    }

    public void searchThumbnailHandler(ActionEvent event)
    {
        final FileChooser filechooser = new FileChooser();
        Stage stage = (Stage) videoPane.getScene().getWindow();
        File file= filechooser.showOpenDialog(stage);
        if(file!=null)
        {
            Image im = new Image(file.toURI().toString());
            videoThumbnail.setImage(im);
            videoThumbnail.setStyle("-fx-border-color:black;-fx-border-width:thin;");
            thumbnailPathValue.setText(file.toURI().toString());
        }

    }
    public void addVideoHandler(ActionEvent event) {
        String vcategory=categoryChoiceBox.getValue();
        String vtitle = videoTitleValue.getText();
        String vdescription = videoDescriptionValue.getText();
        String vpath = videoPathValue.getText();
        String vuploader = active_user.getUsername();
        String vthumbnail =  thumbnailPathValue.getText();

        if (vpath == null || vpath.isEmpty()) {
            addVideoErrorText.setText("Please add a video!");
            return;
        }
        if (vthumbnail == null || vthumbnail.isEmpty()) {
            addVideoErrorText.setText("Please add a thumbnail!");
            return;
        }
        if (vtitle == null || vtitle.isEmpty()) {
            addVideoErrorText.setText("Please type in a title for the video!");
            return;
        }
        if (vcategory == null) {
            addVideoErrorText.setText("Please choose a catergory for the video!");
            return;
        }
        else
        {
            VideoService.addVideo(vuploader,vtitle,vcategory,vdescription,vpath,vthumbnail);
            Tools.AlertBox("Video adaugat cu succes!");
            thumbnailPathValue.clear();
            videoPathValue.clear();
            videoDescriptionValue.clear();
            videoTitleValue.clear();
            addVideoMedia.setMediaPlayer(null);
            videoThumbnail.setImage(null);
            categoryChoiceBox.setValue(null);
        }
    }
}