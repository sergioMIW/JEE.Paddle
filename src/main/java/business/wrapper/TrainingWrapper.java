package business.wrapper;

import java.util.Calendar;
import java.util.List;

import data.entities.Training;
import data.entities.User;

public class TrainingWrapper {

    private int id;

    private Calendar initDate;

    private Calendar endDate;

    private int courtId;

    private int trainerId;

    private List<User> users;

    public TrainingWrapper(int id, Calendar initDate, Calendar endDate, int courtId, int trainerId, List<User> users) {
        super();
        this.id = id;
        this.initDate = initDate;
        this.endDate = endDate;
        this.courtId = courtId;
        this.trainerId = trainerId;
        this.users = users;
    }

    public TrainingWrapper(Calendar initDate, Calendar endDate, int courtId) {
        this.initDate = initDate;
        this.endDate = endDate;
        this.courtId = courtId;
    }
    
    public TrainingWrapper(Calendar initDate, Calendar endDate, int courtId,int trainerId) {
        this.initDate = initDate;
        this.endDate = endDate;
        this.courtId = courtId;
        this.trainerId = trainerId;
    }

    public TrainingWrapper(Training training) {
        this(training.getId(), training.getInitDate(), training.getEndDate(), training.getCourt().getId(), training.getTrainer().getId(),
                training.getUserList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getInitDate() {
        return initDate;
    }

    public void setInitDate(Calendar initDate) {
        this.initDate = initDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
