package data.daos;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Token;
import data.entities.User;

public class UserDaoImpl implements UserDaoExtended {
    
    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;

    public User findByTokenValueIsValid(String usernameOrEmailOrTokenValue) {
        User user = userDao.findByTokenValue(usernameOrEmailOrTokenValue);
        if (user != null) {
            Token token = tokenDao.findByUser(user);
            if (token.isValidTime())
                return user;
        }
        return null;
    }

}
