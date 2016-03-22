package data.daos;

import data.entities.Token;
import data.entities.User;

public class UserDaoImpl implements UserDaoExtended {

    private TokenDao tokenDao;

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
