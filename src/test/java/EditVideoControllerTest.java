import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.junit.Ignore;
import org.junit.Test;
import org.loose.oose.fis.lab.project.controllers.EditVideoController;
import org.loose.oose.fis.lab.project.model.Video;

import static org.loose.oose.fis.lab.project.services.VideoService.active_video;

public class EditVideoControllerTest {

    @Ignore
    @Test
    public void testHandleSave(){
        ChoiceBox<String> cb = new ChoiceBox<>();
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextArea ta = new TextArea();
        Video v = new Video("aaa", "abc", "asd", "arf", "a", "v");
        active_video = v;
        EditVideoController evc = new EditVideoController();
        evc.setThumbnailTF(tf1);
        evc.setDescriptionTA(ta);
        evc.setCategoryCB(cb);
        evc.setTitleTF(tf2);
        v = active_video;
        evc.handleSaveForTest();
        TextField t = evc.getTitleTF();
        assert(t.equals(tf2));
    }
}
