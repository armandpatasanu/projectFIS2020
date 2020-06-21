package org.loose.oose.fis.lab.project.controllers;

import javafx.fxml.LoadException;
import javafx.scene.control.ComboBox;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.loose.oose.fis.lab.project.model.User;
import org.loose.oose.fis.lab.project.services.FileSystemService;
import org.loose.oose.fis.lab.project.services.UserService;
import org.testfx.framework.junit.ApplicationTest;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;

public class EditProfileControllerTest extends ApplicationTest {


    @BeforeClass
    public static void setupClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".video-platform";
        FileSystemService.initApplicationHomeDirIfNeeded();
        UserService.loadUsersFromFile();
    }


    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        UserService.loadUsersFromFile();
    }

    /*
    @Ignore
    public void saveChangesHandler() throws Exception {
        User u=new User("Alex","Maco","alex68","alex@","123");
        UserService.getUsers().add(u);
        UserService.persistUsers();
        User active_user=UserService.getUser("alex68");
        interact(() -> {
                    EditProfileController controller1 = new EditProfileController();
                    controller1.getCountryComboBox().setValue("Ro");
                    controller1.getDescriptionTextArea().setText("im god");
                    controller1.getUsersCityValue().setText("timi");
                    controller1.getUsersNumberValue().setText("0231");
            try {
                controller1.saveChangesHandler(event);
            } catch(LoadException e)
            {
                System.out.println("Load exc");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        assertEquals("Ro",active_user.getCountry());
        assertEquals("im god",active_user.getDescription());
        assertEquals("timi",active_user.getCity());
        assertEquals("0231",active_user.getPhone());
    }
    */

}