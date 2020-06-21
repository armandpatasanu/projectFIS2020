import org.junit.Test;
import org.loose.oose.fis.lab.project.controllers.SearchPageController;

import java.io.IOException;

import static org.loose.oose.fis.lab.project.controllers.SearchPageController.current_category;


public class SearchPageControllerTest {

    @Test
    public void testButtonClicked() throws IOException {
        SearchPageController spc = new SearchPageController();
        spc.buttonClickedForTest("Nature");
        assert(current_category.equals("Nature"));
    }
}
