package org.loose.oose.fis.lab.project.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.loose.oose.fis.lab.project.Tools;
import org.loose.oose.fis.lab.project.services.UserService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.loose.oose.fis.lab.project.controllers.LoginController.active_user;

public class EditProfileController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField pathValue;
    @FXML
    private Circle picturePreview;
    @FXML
    private ComboBox<String> countryComboBox;
    @FXML
    private TextArea descriptionTextArea;
    private static final int LIMIT = 150;
    @FXML
    private ColorPicker backgroundColorPicker;
    @FXML
    private TextField usersCityValue;
    @FXML
    private TextField usersNumberValue;
    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> cities = FXCollections.observableArrayList();
        String[] locales1 = Locale.getISOCountries();
        for (String countrylist : locales1) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                cities.add(obj.getDisplayCountry());
            }
        }
        countryComboBox.setItems(cities);

        descriptionTextArea.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if (newValue.intValue() > oldValue.intValue())
                {
                    if (descriptionTextArea.getText().length() >= LIMIT)
                    {
                        descriptionTextArea.setText(descriptionTextArea.getText().substring(0, LIMIT));
                    }
                }
            }
        });
    }
    public void saveChangesHandler(ActionEvent event) throws Exception {
        String new_city= usersCityValue.getText();
        String new_phone= usersNumberValue.getText();
        String new_description= descriptionTextArea.getText();
        String new_country=  countryComboBox.getValue();

        if(new_city!=null &&!(new_city.isEmpty()))
            active_user.setCity(new_city);
        if(new_phone!=null &&!(new_phone.isEmpty()))
            active_user.setPhone(new_phone);
        if(new_description!=null &&!(new_description.isEmpty()))
            active_user.setDescription(new_description);
        if((new_country!=null))
            active_user.setCountry(new_country);

        UserService.persistUsers();
        Stage modified_stage =new Stage();
        modified_stage= Tools.createProfileStage(modified_stage);
        modified_stage.show();
        Stage prevStage = (Stage) saveButton.getScene().getWindow();
        prevStage.close();
        Tools.AlertBox("Profilul a fost editat cu succes!");

    };
    public void searchNewImageHandler(ActionEvent event) throws IOException {
        final FileChooser filechooser = new FileChooser();
        Stage stage = (Stage) mainPane.getScene().getWindow();
        File file= filechooser.showOpenDialog(stage);
        if(file!=null)
        {
            Image im = new Image(file.toURI().toString(),150,120,true,false);
            picturePreview.setFill(new ImagePattern(im));
            active_user.setPic_path(file.toURI().toString());
        }
    }

    public void getBackColorHandler(ActionEvent event) {
        Color c=backgroundColorPicker.getValue();
        active_user.setBack_color(c.toString());
    }
}
