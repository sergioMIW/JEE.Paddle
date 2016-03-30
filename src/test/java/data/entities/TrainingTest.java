package data.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class TrainingTest {

    @Test
    public void testAddUserTrainning() {
        Training training = new Training();
        assertEquals(0, training.getUserList().size());
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        training.addUser(user);
        assertEquals("u@gmail.com", training.getUser(user).getEmail());
    }

    @Test
    public void testDeleteTrainning() {
        Training training = new Training();
        assertEquals(0, training.getUserList().size());
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        training.addUser(user);
        assertEquals(1, training.getUserList().size());
        training.removeUser(user);
        assertEquals(0, training.getUserList().size());
    }

    @Test
    public void testGetUserTrainning() {
        Training training = new Training();
        assertEquals(0, training.getUserList().size());
        User user = new User("u", "u1@gmail.com", "p", Calendar.getInstance());
        assertEquals(null, training.getUser(user));
    }

    @Test
    public void testAddListUserTrainning() {
        Training training = new Training();
        assertEquals(0, training.getUserList().size());
        User user = new User("u1", "u1@gmail.com", "p", Calendar.getInstance());
        User user2 = new User("u2", "u2@gmail.com", "p", Calendar.getInstance());
        User user3 = new User("u3", "u3@gmail.com", "p", Calendar.getInstance());
        assertEquals(0, training.getUserList().size());
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        training.setUserList(users);
        assertEquals(3, training.getUserList().size());
    }
    
    @Test
    public void testRemoveListUserTrainning() {
        Training training = new Training();
        assertEquals(0, training.getUserList().size());
        User user = new User("u1", "u1@gmail.com", "p", Calendar.getInstance());
        User user2 = new User("u2", "u2@gmail.com", "p", Calendar.getInstance());
        User user3 = new User("u3", "u3@gmail.com", "p", Calendar.getInstance());
        assertEquals(0, training.getUserList().size());
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        training.setUserList(users);
        assertEquals(3, training.getUserList().size());
        training.removeAllUsers();
        assertEquals(0, training.getUserList().size());
    }
    
    

}
