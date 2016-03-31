package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import data.entities.Court;
import data.entities.Training;
import data.entities.User;

public interface TrainingDao extends JpaRepository<Training, Integer>,TrainingDaoExtended {

    Training findById(int id);

    @Query("select t from Training t where t= ?1")
    Training findByTraining(Training training);

    @Query("select t from Training t where t= ?1")
    List<Training> findTrainingsByCourt(Court court);

    @Query("select t from Training t where t= ?1")
    Training findTrainingsByUser(User user);

}
