package data.daos;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Token;
import data.entities.User;

public class UserDaoImpl implements UserDaoExtended {

    @Autowired
    private TokenDao tokenDao;

    public User findByTokenValueIsValid(String usernameOrEmailOrTokenValue) {
        Token token = tokenDao.findByValue(usernameOrEmailOrTokenValue);
        if (token != null && token.isValidTime())
            return token.getUser();
        else
            return null;

    }

}
