package data.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.entities.Court;
import data.entities.Training;
import data.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class TrainingDaoITest {

    @Autowired
    private TrainingDao trainingDao;

    @Autowired
    private CourtDao courtDao;

    @Autowired
    private DaosService daosService;

    @Test
    public void testCompareDatesTrainnig() {
        User u1 = (User) daosService.getMap().get("u0");
        Court court = courtDao.findOne(1);
        Calendar initDate = new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 13, 00, 00);
        Training training = new Training(court, initDate, u1);
        initDate.add(Calendar.HOUR_OF_DAY, 1);
        assertEquals(initDate.getTimeInMillis(), training.getEndDate().getTimeInMillis());
    }

    @Test
    public void testCreateTrainnig() {
        long count = trainingDao.count();
        User u0 = (User) daosService.getMap().get("u0");
        Court court = courtDao.findOne(1);
        Calendar initDate = new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 13, 00, 00);
        Calendar endDate = new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 14, 00, 00);
        Training training = new Training(court, initDate, endDate, u0);
        trainingDao.createTraining(training);
        long countAux = trainingDao.count();
        assertTrue(count < countAux);

    }

    @Test
    public void testDeleteTrainnig() {
        assertTrue(trainingDao.count() == 4);
        trainingDao.deleteTraining(trainingDao.findById(1));
        assertTrue(trainingDao.count() == 3);

    }

    @Test
    public void testAddUserTrainnig() {
        User u1 = (User) daosService.getMap().get("u1");
        User u0 = (User) daosService.getMap().get("u0");
        Court court = courtDao.findOne(1);
        Calendar initDate = new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 13, 00, 00);
        Calendar endDate = new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 14, 00, 00);
        Training training = new Training(court, initDate, endDate, u0);
        trainingDao.createTraining(training);
        assertEquals(0, training.getUserList().size());
        trainingDao.addUserInTraining(training, u1);
        assertEquals(1, trainingDao.findByTraining(training).getUserList().size());
    }

    @Test
    public void testDeleteUserTrainnig() {
        User u1 = (User) daosService.getMap().get("u1");
        User u0 = (User) daosService.getMap().get("u0");
        Court court = courtDao.findOne(1);
        Calendar initDate = new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 13, 00, 00);
        Calendar endDate = new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 14, 00, 00);
        Training training = new Training(court, initDate, endDate, u0);
        trainingDao.createTraining(training);
        assertEquals(0, training.getUserList().size());
        trainingDao.addUserInTraining(training, u1);
        assertEquals(1, trainingDao.findByTraining(training).getUserList().size());
        trainingDao.deleteUserInTraining(training, u1);
        assertEquals(0, training.getUserList().size());
    }

}
