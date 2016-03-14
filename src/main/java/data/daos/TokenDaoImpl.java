package data.daos;

import java.util.List;

import data.entities.Token;

public class TokenDaoImpl  implements TokenDaoExtended{

    
    private TokenDao tokenDao;

    @Override
    public void deleteTokenExpired() {
       
        List<Token> tokens = tokenDao.findAll();
        for (Token token : tokens) {
            if (token.isValidTime()) {
                tokenDao.delete(token);
            }
        }
        
    }

   
}
