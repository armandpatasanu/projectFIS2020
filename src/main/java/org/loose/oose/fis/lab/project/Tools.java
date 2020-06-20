package org.loose.oose.fis.lab.project;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

import static org.loose.oose.fis.lab.project.services.VideoService.active_video;

public class Tools
{
    private static double xOffset = 0;
    private static double yOffset = 0;

    public static Stage createLoginStage(Stage primaryStage) throws java.io.IOException {

        Parent root = FXMLLoader.load(Tools.class.getClassLoader().getResource("fxml/Login.fxml"));
        primaryStage.setTitle("Video Platform");
        primaryStage.setScene(new Scene(root, 708, 400));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
        return primaryStage;
    }
    public static Stage createSearchPage(Stage primaryStage) throws java.io.IOException {

        Parent root = FXMLLoader.load(Tools.class.getClassLoader().getResource("fxml/SearchPage.fxml"));
        primaryStage.setTitle("Video Platform");
        primaryStage.setScene(new Scene(root, 1200, 670));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
        return primaryStage;
    }
    public static Stage createProfileStage(Stage primaryStage) throws java.io.IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(Tools.class.getClassLoader().getResource("fxml/UserProfile.fxml")));
        primaryStage.setTitle("Video Platform");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
        return primaryStage;
    }
    public static void AlertBox(String message) {
        Stage s = new Stage();
        s.initModality(Modality.APPLICATION_MODAL);
        Label l1=new Label();
        l1.setText(message);
        VBox layout =new VBox(10);
        layout.getChildren().addAll(l1);
        layout.setAlignment(Pos.CENTER);
        Scene sc = new Scene(layout,300,150);
        s.setScene(sc);
        s.showAndWait();
    }

    public static Stage createEditVideoStage(Stage primaryStage) throws java.io.IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(Tools.class.getClassLoader().getResource("fxml/EditVideo.fxml")));
        primaryStage.setTitle("Video Edit video");
        primaryStage.setScene(new Scene(root, 710, 400));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
        return primaryStage;
    }

    public static Stage createSearchedVideosStage(Stage primaryStage) throws java.io.IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(Tools.class.getClassLoader().getResource("fxml/SearchedVideos.fxml")));
        primaryStage.setTitle("Searched Videos");
        primaryStage.setScene(new Scene(root, 1200, 670));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
        return primaryStage;
    }

    public static Stage createMediaPlayerStage(Stage primaryStage) throws java.io.IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(Tools.class.getClassLoader().getResource("fxml/MediaPlayer.fxml")));
        primaryStage.setTitle("Searched Videos");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
        return primaryStage;
    }

    public static void reviewAlertBox(){
        Stage s = new Stage();
        s.initModality(Modality.APPLICATION_MODAL);
        s.setTitle(active_video.getTitle() + ": reviews");
        VBox v = new VBox(20);
        v.setAlignment(Pos.CENTER);
        HBox h = new HBox(30);
        h.setAlignment(Pos.CENTER);
        Button okB = new Button("Ok");
        okB.setOnAction(e -> s.close());
        Label l1 = new Label("Number of Likes: " + active_video.getLikes());
        Label l2 = new Label("Number of Dislikes: " + active_video.getDislikes());
        Label l3 = new Label("Success rate of video: " + successRateForVideo());
        h.getChildren().addAll(l1, l2);
        v.getChildren().addAll(h, l3, okB);
        Scene scene = new Scene(v,300,150);
        s.setScene(scene);
        s.showAndWait();
    }

    public static String successRateForVideo(){
        if((active_video.getLikes() == 0) && (active_video.getDislikes() == 0)){
            return "not rated";
        }
        else {
            int rate = (100 * active_video.getLikes()) / (active_video.getLikes() + active_video.getDislikes());
            return "" + rate + " %";
        }
    }
}
