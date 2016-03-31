package data.daos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TokenDaoITest.class,
    UserDaoITest.class,
    ReserveDaoITest.class,
    TokenDaoITest.class,
    TrainingDaoITest.class
})
public class AllDaosITests {

}
