package org.loose.oose.fis.lab.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Button likeB;
    @FXML
    private Button dislikeB;
    @FXML
    private Label nrOfLikes;
    @FXML
    private Label nrOfDislikes;

    private static int liked = 0;//0 for not rated, 1 for liked, -1 for disliked

    private MediaPlayer mediaPlayer;

    public void xPressedHandler(){
        Stage s = (Stage) h.getScene().getWindow();
        mediaPlayer.stop();
        s.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nrOfLikes.setText("" + active_video.getLikes());
        nrOfDislikes.setText("" + active_video.getDislikes());
        String URL = active_video.getVideo_path();
        Media m = new Media(URL);
        mediaPlayer = new MediaPlayer(m);
        media.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void likePressed(){
        if(liked == 1){
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            liked = 0;
        }
        else if(liked == 0){
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #4863bd; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = 1;
        }
        else {
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #4863bd; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            liked = 1;
        }
    }

    public void dislikePressed(){
        if(liked == -1){
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            liked = 0;
        }
        else if(liked == 0){
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #f51414; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = -1;
        }
        else {
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #f51414; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = -1;
        }
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
