package data.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Token;

public class TokenDaoImpl implements TokenDaoExtended {

    @Autowired
    private TokenDao tokenDao;

    @Override
    public void deleteNotValidToken() {
        List<Token> tokens = tokenDao.findAll();
        for (Token token : tokens){ 
            if (!token.isValidTime()) 
                tokenDao.delete(token);
        }
    }

}
