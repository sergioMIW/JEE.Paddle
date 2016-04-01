package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.ApiException;
import business.api.exceptions.InvalidDateException;
import business.api.exceptions.NotFoundCourtIdException;
import business.api.exceptions.NotFoundTrainingIdException;
import business.controllers.TrainingController;
import business.wrapper.TrainingWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.TRAINING)
public class TrainerResource {

    private TrainingController trainingController;

    @Autowired
    public void setTrainingController(TrainingController trainingController) {
        this.trainingController = trainingController;
    }

    @RequestMapping(value = Uris.CREATE_TRAINING, method = RequestMethod.POST)
    public void createTraining(@RequestBody TrainingWrapper trainingWrapper) throws ApiException {

        if (trainingWrapper.getInitDate().getTimeInMillis() > trainingWrapper.getEndDate().getTimeInMillis()) {
            throw new InvalidDateException();
        }

        if (!trainingController.existTraining(trainingWrapper.getCourtId())) {
            throw new NotFoundCourtIdException("Pista no encontrada o no disponible");
        }
        if (!this.trainingController.createTraining(trainingWrapper)) {
            throw new ApiException("Error al crear el entrenamiento", 1);
        }

    }

    @RequestMapping(value = Uris.DELETE_TRAINING + Uris.ID, method = RequestMethod.DELETE)
    public void deleteTraining(@RequestParam(required = true) int id) throws ApiException {
        if (!trainingController.existTraining(id))
            throw new NotFoundTrainingIdException("Id de entrenamiento no encontrado");

        if (!this.trainingController.deleteTraining(id)) {
            throw new ApiException("Error al borrar el usuario", 1);
        }
    }

    @RequestMapping(value = Uris.LIST_TRAININGS, method = RequestMethod.GET)
    public List<TrainingWrapper> showTrainings() {
        return this.trainingController.showTrainings();
    }

}
