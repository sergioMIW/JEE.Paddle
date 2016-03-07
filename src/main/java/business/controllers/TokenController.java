package business.controllers;

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
        int last_token = tokenDao.findByUserLastConnection(user);
        int seconds24hours = 3600;
        if (last_token > seconds24hours) {
            // renovar token
            token = new Token(user);
            tokenDao.save(token);
        }

        else {
            // recoger token y enviar

        }

        return token.getValue();
    }
}
