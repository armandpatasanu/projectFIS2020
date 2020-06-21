package org.loose.oose.fis.lab.project.controllers;

import javafx.fxml.LoadException;
import javafx.scene.control.TextField;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.loose.oose.fis.lab.project.model.User;
import org.loose.oose.fis.lab.project.services.FileSystemService;
import org.loose.oose.fis.lab.project.services.UserService;
import org.loose.oose.fis.lab.project.services.VideoService;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class AddVideoControllerTest extends ApplicationTest {

    public static final String title = "t";
    public static final String desc = "d";
    public static final String vpath = "vp";
    public static final String vthumb = "vt";
    public static final String vcateg = "vc";


    private AddVideoController controller;

    @BeforeClass
    public static void setupClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".video-platform";
        FileSystemService.initApplicationHomeDirIfNeeded();
        UserService.loadUsersFromFile();
        VideoService.loadVideosFromFile();
    }

    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        VideoService.loadVideosFromFile();
    }

    /*
    @Ignore
    public void addVideoHandlertest() throws Exception
    {
        User u=new User("Alex","Maco","alex68","alex@","123");
        UserService.getUsers().add(u);
        UserService.persistUsers();
        User active_user=UserService.getUser("alex68");
        interact(() -> {
            AddVideoController controller = new AddVideoController();
            controller.getThumbnailPathValue().setText(vthumb);
            controller.getCategoryChoiceBox().setValue(vcateg);
            controller.getVideoTitleValue().setText(title);
            controller.getVideoDescriptionValue().setText(desc);
            controller.getVideoPathValue().setText(vpath);
            try {
                controller.addVideoHandler();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
        assertEquals(1,VideoService.getVideos().size());
    }
     */

}