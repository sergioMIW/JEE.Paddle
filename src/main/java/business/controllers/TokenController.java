package business.controllers;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.daos.TokenDao;
import data.daos.UserDao;
import data.entities.Token;
import data.entities.User;

@Controller
@Transactional
public class TokenController {

    private TokenDao tokenDao;

    private UserDao userDao;

    @Autowired
    public void setTokenDao(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String login(String username) {
        User user = userDao.findByUsernameOrEmail(username);
        assert user != null;
        // TODO:Comprobar si el usuario logeado tiene un token valido
        Token token = null;
        token = tokenDao.findByUserLastConnection(user);
        long last_token_msec = token.getLastConnection();
        long misecsNow = (new Date().getTime());
        double diffeHours = (last_token_msec - misecsNow) / 1000 / 60 / 60;
        double hours = 24;

        // El tiempo de token excede 24horas
        if (diffeHours > hours) {
            token = new Token(user);
            // refresh the token
            token.setLastConnection(misecsNow);
            tokenDao.save(token);
        }

        return token.getValue();
    }
}
