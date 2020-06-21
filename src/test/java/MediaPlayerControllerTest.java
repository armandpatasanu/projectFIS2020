import org.junit.Ignore;
import org.junit.Test;
import org.loose.oose.fis.lab.project.controllers.MediaPlayerController;


public class MediaPlayerControllerTest {

    @Test
    public void testGetFileExtension(){
        MediaPlayerController mpc = new MediaPlayerController();
        assert(mpc.getFileExtension("a.txt").equals("txt"));
    }

    @Ignore
    @Test
    public void testLikePressed(){
        MediaPlayerController mpc = new MediaPlayerController();
        mpc.setLiked(1);
        mpc.likePressed();
        assert(mpc.getLiked() == 0);
    }
}
