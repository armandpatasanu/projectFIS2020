package org.loose.oose.fis.lab.project.model;

import org.junit.Test;
import org.loose.oose.fis.lab.project.other.Review;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void checkConstructorsAndGetters()
    {
        User u=new User("Alex","Maco","alex68","alex@","123");
        assertEquals(u.getFirstName(),"Alex");
        assertEquals(u.getLastName(),"Maco");
        assertEquals(u.getUsername(),"alex68");
        assertEquals(u.getEmail(),"alex@");
        assertEquals(u.getPassword(),"123");
        assertEquals(u.getBack_color(),"#b22222");
        assertEquals(u.getPic_path(),"images/profile_photo.png");
        assertEquals(u.getCity(),null);
        assertEquals(u.getCountry(),null);
        assertEquals(u.getPhone(),null);
        assertEquals(u.getDescription(),null);
    }

    @Test
    public void checkUserSetters()
    {
        User u=new User();
        u.setBack_color("#b22222");
        u.setCity(null);
        u.setCountry(null);
        u.setDescription(null);
        u.setEmail("alex@");
        u.setFirstName("Alex");
        u.setUsername("alex68");
        u.setLastName("Maco");
        u.setPassword("123");
        u.setPhone(null);
        u.setPic_path("images/profile_photo.png");
        assertEquals(u.getFirstName(),"Alex");
        assertEquals(u.getLastName(),"Maco");
        assertEquals(u.getUsername(),"alex68");
        assertEquals(u.getEmail(),"alex@");
        assertEquals(u.getPassword(),"123");
        assertEquals(u.getBack_color(),"#b22222");
        assertEquals(u.getPic_path(),"images/profile_photo.png");
        assertEquals(u.getCity(),null);
        assertEquals(u.getCountry(),null);
        assertEquals(u.getPhone(),null);
        assertEquals(u.getDescription(),null);
    }

    @Test
    public void checkBlankConstructor()
    {
        User u=new User();
        assertEquals(u.getFirstName(),null);
        assertEquals(u.getLastName(),null);
        assertEquals(u.getUsername(),null);
        assertEquals(u.getEmail(),null);
        assertEquals(u.getPassword(),null);
        assertEquals(u.getBack_color(),null);
        assertEquals(u.getPic_path(),null);
        assertEquals(u.getCity(),null);
        assertEquals(u.getCountry(),null);
        assertEquals(u.getPhone(),null);
        assertEquals(u.getDescription(),null);
    }

    @Test
    public void testingEquals()
    {
        User u1=new User("Alex","Maco","alex68","alex@","123");
        User u2=new User("Alex","Maco","alex68","alex@@","124");
        User u3=new User("Alex","Maco","alex67","alex@","124");
        User u4=new User("Alex","Maco","alex67","alex@@","123");
        assertEquals(u1.equals(u1),true);
        assertEquals(u1.equals(u2),false);
        assertEquals(u1.equals(u3),false);
        assertEquals(u1.equals(u4),false);
    }

    @Test
    public void testingToString()
    {
        User u=new User("Alex","Maco","alex68","alex@","123");
        String t;
        t="UserDTO{first name='" + "Alex" + '\'' +
                ", last name=" + "Maco" + '\'' +
                ", username=" + "alex68" + '\'' +
                ", password='" + "123" + '\'' +
                ", email='" + "alex@" + '\'' +
                ", description=" + null + '\'' +
                ", phone=" + null + '\'' +
                ", country=" + null + '\'' +
                ", city=" + null + '\'' +
                ", image=" + "images/profile_photo.png" + '\'' +
                ", profile background color=" + "#b22222" + '\'' +
                '}';
        assertEquals(t,u.toString());
    }

    @Test
    public void testingHashCode()
    {
        User u=new User("Alex","Maco","alex68","alex@","123");
        int result = "alex68".hashCode();
        result = 31 * result + "123".hashCode();
        result = 31 * result + "Alex".hashCode();
        result = 31 * result + "Maco".hashCode();
        result = 31 * result + "alex@".hashCode();
        assertEquals(result,u.hashCode());
    }
}
