package data.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Training {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private Court court;

    @ManyToOne
    @JoinColumn
    private User trainer;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> userList;

    private Calendar initDate;

    private Calendar endDate;

    private int hourTrainningByDefault = 1;

    public Training() {
        this.userList = new ArrayList<User>();
    }

    public Training(Court court, Calendar initDate, User trainer) {
        super();
        this.court = court;
        this.initDate = initDate;
        this.endDate = setHourByDefault(initDate);
        this.trainer = trainer;
        this.userList = new ArrayList<User>();
    }
    
    public Training(Court court, Calendar initDate,Calendar endDate, User trainer) {
        super();
        this.court = court;
        this.initDate = initDate;
        this.endDate = endDate;
        this.trainer = trainer;
        this.userList = new ArrayList<User>();
    }

    public Training(Court court, List<User> userList, Calendar initDate, Calendar endDate) {
        super();
        this.court = court;
        this.userList = userList;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Calendar setHourByDefault(Calendar calendar) {
        Calendar cal = calendar;
        cal.add(Calendar.HOUR, hourTrainningByDefault);
        return cal;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUser(User user) {
        int userIndex = userList.indexOf(user);
        if (userIndex != -1)
            return userList.get(userIndex);
        else
            return null;
    }

    public boolean addUser(User user) {
        if (!userList.contains(user))
            return this.userList.add(user);
        else
            return false;
    }

    public boolean removeUser(User user) {
        return userList.remove(user);
    }

    public void removeAllUsers() {
        this.userList.clear();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Training other = (Training) obj;
        if (court == null) {
            if (other.court != null)
                return false;
        } else if (!court.equals(other.court))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (hourTrainningByDefault != other.hourTrainningByDefault)
            return false;
        if (id != other.id)
            return false;
        if (initDate == null) {
            if (other.initDate != null)
                return false;
        } else if (!initDate.equals(other.initDate))
            return false;
        if (userList == null) {
            if (other.userList != null)
                return false;
        } else if (!userList.equals(other.userList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Training [id=" + id + ", court=" + court + ", trainer=" + trainer + ", userList=" + userList + ", initDate=" + initDate
                + ", endDate=" + endDate + ", hourTrainningByDefault=" + hourTrainningByDefault + "]";
    }

}
