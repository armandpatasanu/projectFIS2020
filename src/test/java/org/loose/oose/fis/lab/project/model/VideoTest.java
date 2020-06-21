package org.loose.oose.fis.lab.project.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class VideoTest {

    @Test
    public void checkConstructorsAndGetters()
    {
        Video v=new Video("alex68","abc","fun","ok","@.","pic");
        assertEquals(v.getUploader(),"alex68");
        assertEquals(v.getDescription(),"ok");
        assertEquals(v.getDislikes(),0);
        assertEquals(v.getLikes(),0);
        assertEquals(v.getCategory(),"fun");
        assertEquals(v.getVideo_path(),"@.");
        assertEquals(v.getThumbnail_path(),"pic");
        assertEquals(v.getTitle(),"abc");
    }

    @Test
    public void checkBlankConstructor()
    {
        Video v=new Video();
        assertEquals(v.getUploader(),null);
        assertEquals(v.getDescription(),null);
        assertEquals(v.getDislikes(),0);
        assertEquals(v.getLikes(),0);
        assertEquals(v.getCategory(),null);
        assertEquals(v.getVideo_path(),null);
        assertEquals(v.getThumbnail_path(),null);
        assertEquals(v.getTitle(),null);
    }
}