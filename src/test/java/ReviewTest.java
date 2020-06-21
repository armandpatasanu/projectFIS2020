import org.junit.Test;
import org.loose.oose.fis.lab.project.model.User;
import org.loose.oose.fis.lab.project.other.Review;

import java.util.List;

import static org.loose.oose.fis.lab.project.controllers.LoginController.active_user;

public class ReviewTest {

    @Test
    public void testNewReview(){
        String URL = "file:/C:/Users/popac/Desktop/Dorian%20Popa%20feat.%20SHIFT%20-%20HATZ%20(%20Official%20Video%20).mp4";
        Review r = new Review(URL, false, false);
        assert(r.getVURL().equals(URL));
        assert(r.getDislike() == false);
        assert(r.getLike() == false);
    }

    @Test
    public void testGetReview(){
        Review r = new Review("file:/C:/Users/popac/Desktop/Dorian%20Popa%20feat.%20SHIFT%20-%20HATZ%20(%20Official%20Video%20).mp4", true, false);
        User user = new User();
        List<Review> list = user.getReviews();
        list.add(r);
        user.setReviews(list);
        active_user = user;
        Review result = r.getReview("file:/C:/Users/popac/Desktop/Dorian%20Popa%20feat.%20SHIFT%20-%20HATZ%20(%20Official%20Video%20).mp4");
        assert(result.getLike() == true && result.getDislike() == false);
    }

    @Test
    public void testSetLike(){
        boolean l = true;
        Review r = new Review();
        r.setLike(l);
        assert(r.getLike());
    }

    @Test
    public void testSetDislike(){
        boolean l = true;
        Review r = new Review();
        r.setDislike(l);
        assert(r.getDislike());
    }

    @Test
    public void testSetVURL(){
        String URL = "aaa";
        Review r = new Review();
        r.setVURL(URL);
        assert(r.getVURL().equals("aaa"));
    }

    @Test
    public void testGetLike(){
        Review r = new Review("aaa", true, false);
        assert(r.getLike());
    }

    @Test
    public void testGetDislike(){
        Review r = new Review("aaa", true, false);
        assert(!r.getDislike());
    }

    @Test
    public void testGetVURL(){
        Review r = new Review("aaa", true, false);
        assert(r.getVURL().equals("aaa"));
    }



}
