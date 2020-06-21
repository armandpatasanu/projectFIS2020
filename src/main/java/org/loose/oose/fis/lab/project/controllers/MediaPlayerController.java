package org.loose.oose.fis.lab.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.loose.oose.fis.lab.project.other.Review;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import static org.loose.oose.fis.lab.project.services.UserService.persistUsers;
import static org.loose.oose.fis.lab.project.services.VideoService.active_video;
import static org.loose.oose.fis.lab.project.controllers.LoginController.active_user;
import static org.loose.oose.fis.lab.project.services.VideoService.persistVideos;

public class MediaPlayerController implements Initializable {
    @FXML
    private ImageView image;
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
    @FXML
    private Button xB;

    private static int liked;//0 for not rated, 1 for liked, -1 for disliked

    private MediaPlayer mediaPlayer;

    public void xPressedHandler(){
        Stage s = (Stage) h.getScene().getWindow();
        mediaPlayer.stop();
        s.close();
    }

    public static String getFileExtension(String fullName) {
        if(fullName != null) {
            String fileName = new File(fullName).getName();
            int dotIndex = fileName.lastIndexOf('.');
            return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getUserReview();
        Review r = Review.getReview(active_video.getVideo_path());
        if(r.getLike()){
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #4863bd; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = 1;
        }
        else if(r.getDislike()){
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #f51414; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = -1;
        }
        nrOfLikes.setText("" + active_video.getLikes());
        nrOfDislikes.setText("" + active_video.getDislikes());
        String URL = active_video.getVideo_path();
        String format = getFileExtension(URL);
        if(format.equals("mp3")) {
            Media m = new Media(URL);
            Image im = new Image(active_video.getThumbnail_path());
            xB.setStyle("-fx-text-fill: black;");
            image.setImage(im);
            mediaPlayer = new MediaPlayer(m);
            media.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }
        else{
            Media m = new Media(URL);
            mediaPlayer = new MediaPlayer(m);
            media.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }
    }

    public static void getUserReview(){
        Review r = Review.getReview(active_video.getVideo_path());
        if(r == null){
            List<Review> list = active_user.getReviews();
            list.add(new Review(active_video.getVideo_path(), false, false));
            active_user.setReviews(list);
            liked = 0;
            persistUsers();
        }
        else if(!r.getLike() && !r.getDislike()){
            liked = 0;
        }
        else if(!r.getLike() && r.getDislike()){
            liked = -1;
        }
        else {
            liked = 1;
        }
    }

    public void likePressed(){
        getUserReview();
        Review r = Review.getReview(active_video.getVideo_path());
        if(liked == 1){
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            liked = 0;
            r.setLike(false);
            active_video.setLikes(active_video.getLikes() - 1);

        }
        else if(liked == 0){
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #4863bd; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = 1;
            r.setLike(true);
            active_video.setLikes(active_video.getLikes() + 1);
        }
        else {
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #4863bd; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            liked = 1;
            r.setLike(true);
            active_video.setLikes(active_video.getLikes() + 1);
            r.setDislike(false);
            active_video.setDislikes(active_video.getDislikes() - 1);
        }
        nrOfLikes.setText("" + active_video.getLikes());
        nrOfDislikes.setText("" + active_video.getDislikes());
        persistVideos();
        persistUsers();
    }

    public void dislikePressed(){
        getUserReview();
        Review r = Review.getReview(active_video.getVideo_path());
        if(liked == -1){
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            liked = 0;
            r.setDislike(false);
            active_video.setDislikes(active_video.getDislikes() - 1);
        }
        else if(liked == 0){
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #f51414; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = -1;
            r.setDislike(true);
            active_video.setDislikes(active_video.getDislikes() + 1);
        }
        else {
            likeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0);");
            dislikeB.setStyle("-fx-background-color: rgba(255, 0, 0, 0); -fx-border-color: #f51414; -fx-border-width: 2pt 2pt 2pt 2pt; -fx-border-radius: 30px;");
            liked = -1;
            r.setDislike(true);
            r.setLike(false);
            active_video.setDislikes(active_video.getDislikes() + 1);
            active_video.setLikes(active_video.getLikes() - 1);
        }
        nrOfLikes.setText("" + active_video.getLikes());
        nrOfDislikes.setText("" + active_video.getDislikes());
        persistVideos();
        persistUsers();
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

    public static int getLiked() {
        return liked;
    }

    public static void setLiked(int liked) {
        MediaPlayerController.liked = liked;
    }
}
