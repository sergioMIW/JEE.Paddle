package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Court;

public interface TrainingDao extends JpaRepository<Court, Integer>{

}
