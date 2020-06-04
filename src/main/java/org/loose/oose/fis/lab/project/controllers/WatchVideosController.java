package org.loose.oose.fis.lab.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import org.loose.oose.fis.lab.project.services.VideoService;

import java.net.URL;
import java.util.ResourceBundle;

public class WatchVideosController implements Initializable {


    @FXML
    private ListView listView;
    @FXML
    private Text TextAlert;

    @FXML
    public void initialize(URL location, ResourceBundle resources)
    {
        VideoService.putVideo(this);
        listView.setFocusTraversable( false );
    }

    public void setMessage(String m) {
        TextAlert.setText(m);
    }

    public ListView getListView() {
        return listView;
    }
}

