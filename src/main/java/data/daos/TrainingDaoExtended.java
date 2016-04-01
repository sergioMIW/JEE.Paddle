package data.daos;

import data.entities.Training;
import data.entities.User;

public interface TrainingDaoExtended {

    public Training createTraining(Training training);

    public Boolean deleteTraining(Training training);

    public Boolean addUserInTraining(Training training, User user);

    public Boolean deleteUserInTraining(Training training, User user);
}
