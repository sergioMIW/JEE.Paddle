package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Court;
import data.entities.Training;
import data.entities.User;

public interface TrainingDao extends JpaRepository<Training, Integer> {

    List<Training> findTrainingsByCourt(Court court);

    Training findById(int id);

    List<User> findUsersTraining(int id);

}
