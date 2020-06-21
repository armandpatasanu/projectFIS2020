package org.loose.oose.fis.lab.project.controllers;

import javafx.scene.control.TextField;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loose.oose.fis.lab.project.exceptions.UsernameAlreadyExistsException;
import org.loose.oose.fis.lab.project.services.FileSystemService;
import org.loose.oose.fis.lab.project.services.UserService;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class RegisterControllerTest extends ApplicationTest {

    public static final String TEST_USER = "testUser";
    public static final String TEST_PASSWORD = "testPassword";
    public static final String TEST_MAIL = "testMail";
    public static final String TEST_FNAME = "testFname";
    public static final String TEST_LNAME = "testLname";

    private RegisterController controller;

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
    @Test
    public void createAccountHandlerTest() {
        interact(()-> {
                    RegisterController controller = new RegisterController();
                    controller.getUserfield().setText(TEST_USER);
                    controller.getPasswordfield().setText(TEST_PASSWORD);
                    controller.getEmailfield().setText(TEST_MAIL);
                    controller.getFnamefield().setText(TEST_FNAME);
                    controller.getLnamefield().setText(TEST_LNAME);
                    controller.createAccountHandler();
                });
        assertEquals(1, UserService.getUsers().size());
    }
     */

    /*
    @Test(expected = UsernameAlreadyExistsException.class)
    public void sameUsernameHandlerTest () throws Exception
    {
        controller.createAccountHandler();
        controller.getEmailfield().setText("abc");
        controller.createAccountHandler();
        assertEquals("An account with the username " + TEST_USER +" already exists!",controller.getRegisterMessage().getText());
    }
    */
}