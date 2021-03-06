package data.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TokenTest {

    @Test
    public void testTokenUser() {
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        Token token = new Token(user);
        assertTrue(token.getValue().length() > 20);
    }

    @Test
    public void testTokenIsValid() {
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        Token token = new Token(user);
        assertTrue(token.isValidTime());
    }

    @Test
    public void testTokenIsValidSetTime() {
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        Token token = new Token(user);
        Calendar calendar = Calendar.getInstance();
        token.setCreateConnection(calendar.getTimeInMillis());
        assertTrue(token.isValidTime());
    }

    @Test
    public void testTokenIsNotValidSetTime() {
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        Token token = new Token(user);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // sets calendar time/date
        calendar.add(Calendar.HOUR_OF_DAY, -2); // less two hour
        token.setCreateConnection(calendar.getTimeInMillis());
        assertFalse(token.isValidTime());
    }

}
