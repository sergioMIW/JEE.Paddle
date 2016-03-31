package data.daos;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Court;
import data.entities.Reserve;
import data.entities.Training;
import data.entities.User;

public class TrainingDaoImpl implements TrainingDaoExtended {

    @Autowired
    private TrainingDao trainingDao;

    @Autowired
    private ReserveDao reserveDao;

    @Override
    public Training createTraining(Training training) {
        trainingDao.save(training);
        Court court = training.getCourt();
        User trainer = training.getTrainer();
        Calendar initDate = training.getInitDate();
        Calendar endDate = training.getEndDate();
        createReserve(court, trainer, initDate, endDate);
        return training;
    }

    private void createReserve(Court court, User trainer, Calendar initDate, Calendar endDate) {
        Calendar aux = initDate;
        while (aux.getTimeInMillis() <= endDate.getTimeInMillis()) {
            reserveDao.save(new Reserve(court, trainer, aux));
            aux.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @Override
    public Boolean deleteTraining(Training training) {
        if (trainingDao.findByTraining(training) != null) {
            training.removeAllUsers();
            trainingDao.delete(training);
            return true;
        } else
            return false;
    }

    @Override
    public void addUserInTraining(Training training, User user) {
        if (trainingDao.findByTraining(training) != null)
            if (training.addUser(user))
                trainingDao.save(training);
    }

    @Override
    public Boolean deleteUserInTraining(Training training, User user) {
        if (trainingDao.findByTraining(training) != null) {
            if (training.removeUser(user)) {
                trainingDao.save(training);
                return true;
            } else
                return false;

        } else
            return false;

    }

}
