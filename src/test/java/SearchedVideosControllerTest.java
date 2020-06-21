import javafx.scene.layout.HBox;
import org.junit.Ignore;
import org.junit.Test;
import org.loose.oose.fis.lab.project.controllers.SearchedVideosController;

import javafx.scene.control.ListView;


public class SearchedVideosControllerTest {

    @Ignore
    @Test
    public void testSetMessage(){
        SearchedVideosController svc = new SearchedVideosController();
        svc.setMessage("Vasile");
        assert(svc.getMessage().equals("Vasile"));
    }

    @Ignore
    @Test
    public void testSetList(){
        SearchedVideosController svc = new SearchedVideosController();
        ListView<HBox> list = new ListView();
        list.getItems().addAll(new HBox(), new HBox(2));
        svc.setList(list);
        assert(svc.getList().equals((new ListView<>()).getItems().addAll(new HBox(), new HBox(2))));
    }

}
