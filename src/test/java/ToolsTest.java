import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.loose.oose.fis.lab.project.Tools;
import org.loose.oose.fis.lab.project.model.Video;

import java.io.IOException;

import static org.loose.oose.fis.lab.project.Tools.createMediaPlayerStage;
import static org.loose.oose.fis.lab.project.Tools.successRateForVideo;
import static org.loose.oose.fis.lab.project.services.VideoService.active_video;

public class ToolsTest {

    @Test
    public void testSuccessRateForVideo() {
        Video v = new Video();
        v.setLikes(0);
        v.setDislikes(0);
        active_video = v;
        assert (Tools.successRateForVideo().equals("not rated"));
        v.setLikes(1);
        v.setDislikes(0);
        active_video = v;
        assert (Tools.successRateForVideo().equals("" + 100 + " %"));
    }
}
