package org.loose.oose.fis.lab.project.services;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.loose.oose.fis.lab.project.controllers.WatchVideosController;
import org.loose.oose.fis.lab.project.exceptions.EmailAlreadyUsedException;
import org.loose.oose.fis.lab.project.exceptions.UsernameAlreadyExistsException;
import org.loose.oose.fis.lab.project.model.User;
import org.loose.oose.fis.lab.project.model.Video;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class VideoServiceTest {

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
        VideoService.loadVideosFromFile();
        assertTrue(Files.exists(VideoService.VIDEOS_PATH));
    }

    @Test
    public void addVideoTest() throws Exception {
        VideoService.loadVideosFromFile();
        VideoService.addVideo("alex68","abc","fun","ok","@.","pic");
        assertNotNull(VideoService.getVideos());
        assertEquals(1, VideoService.getVideos().size());
    }

    @Test
    public void getVideo()
    {
        Video v=VideoService.getVideo("abc");
        Video v1=VideoService.getVideo("ahahxD");
        assertEquals("alex68",v.getUploader());
        assertNull(v1);
    }

    @Ignore
    public void setUsersVideo() throws Exception {
        UserService.loadUsersFromFile();
        VideoService.loadVideosFromFile();
        WatchVideosController w=new WatchVideosController();
        try {
            UserService.addUser("Alex","Maco","alex68","alex@","123122");
        } catch (UsernameAlreadyExistsException | EmailAlreadyUsedException e) {
            e.printStackTrace();
        }
        User u=UserService.getUser("alex68");
        VideoService.setUsersVideos(u);
        assertEquals(1,w.getListView().getItems().size());

    }

}