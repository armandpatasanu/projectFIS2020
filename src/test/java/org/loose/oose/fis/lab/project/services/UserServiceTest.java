package org.loose.oose.fis.lab.project.services;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loose.oose.fis.lab.project.exceptions.EmailAlreadyUsedException;
import org.loose.oose.fis.lab.project.exceptions.UsernameAlreadyExistsException;
import org.loose.oose.fis.lab.project.model.User;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;
import static org.loose.oose.fis.lab.project.services.UserService.persistUsers;

public class UserServiceTest {

    @BeforeClass
    public static void setupClass() {
        FileSystemService.APPLICATION_FOLDER = ".video-platform";
        FileSystemService.initApplicationHomeDirIfNeeded();
    }

    @Before
    public void setUp() throws IOException {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
    }

    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception {
        UserService.loadUsersFromFile();
        assertTrue(Files.exists(UserService.USERS_PATH));
    }

    @Test
    public void testAddOneUser() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("Alex","Maco","alex68","alex@","123");
        assertNotNull(UserService.getUsers());
        assertEquals(1, UserService.getUsers().size());
    }

    @Test(expected = UsernameAlreadyExistsException.class)
    public void sameUsernameExists() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("Alex","Maco","alex68","alex@32","1234");
        assertNotNull(UserService.getUsers());
        UserService.checkUserDoesNotAlreadyExist("alex68");
    }

    @Test(expected = EmailAlreadyUsedException.class)
    public void sameMailExists() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("Alex","Maco","alex681","alex@","123122");
        assertNotNull(UserService.getUsers());
        UserService.checkEmailDoesNotAlreadyExist("alex@");
    }

    @Test
    public void checkLoginUsername() throws IOException {
        Boolean t=UserService.checkLoginUsername("alex68");
        Boolean t1=UserService.checkLoginUsername("maria");
        assertNotNull(UserService.getUsers());
        assertEquals(true,t);
        assertEquals(false,t1);
    }

    @Test
    public void checkLoginPass() throws IOException {
        Boolean t=UserService.checkLoginPassword("123","alex68");
        Boolean t1=UserService.checkLoginPassword("aloha","alex68");
        assertNotNull(UserService.getUsers());
        assertEquals(true,t);
        assertEquals(false,t1);
    }

    @Test
    public void getUser()
    {
        User u=UserService.getUser("alex68");
        User u1=UserService.getUser("armand");
        assertEquals("Maco",u.getLastName());
        assertNull(u1);
    }
}