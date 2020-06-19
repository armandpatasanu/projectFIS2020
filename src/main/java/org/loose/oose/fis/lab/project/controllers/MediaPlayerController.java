package org.loose.oose.fis.lab.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import static org.loose.oose.fis.lab.project.services.VideoService.active_video;

public class MediaPlayerController implements Initializable {
    @FXML
    private HBox h;
    @FXML
    private MediaView media;
    @FXML
    private Button pauseB;

   private MediaPlayer mediaPlayer;

    public void xPressedHandler(){
        Stage s = (Stage) h.getScene().getWindow();
        mediaPlayer.stop();
        s.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String URL = active_video.getVideo_path();
        Media m = new Media(URL);
        mediaPlayer = new MediaPlayer(m);
        media.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void pausePressed(){
        if(mediaPlayer.getStatus() == PLAYING) {
            mediaPlayer.pause();
            pauseB.setText("Play");
            pauseB.setStyle("-fx-font-family: Arial; -fx-font-size: 12pt; -fx-font-weight: bold;");
        }
        else{
            mediaPlayer.play();
            pauseB.setText("Pause");
            pauseB.setStyle("-fx-font-family: Arial; -fx-font-size: 12pt; -fx-font-weight: bold;");
        }
    }


}
