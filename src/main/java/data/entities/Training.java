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

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> userList;

    private Calendar initDate;

    private Calendar endDate;

    private final int hourTrainningByDefault = 1;

    public Training(Court court, Calendar initDate) {
        super();
        this.court = court;
        this.initDate = initDate;
        this.endDate = this.setHourByDefault(initDate);
        this.userList = new ArrayList<User>();
    }

    public Training(Court court, List<User> userList, Calendar initDate, Calendar endDate) {
        super();
        this.court = court;
        this.userList = userList;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    private Calendar setHourByDefault(Calendar calendar) {
        Calendar aux = Calendar.getInstance();
        aux.add(Calendar.HOUR_OF_DAY, hourTrainningByDefault);
        return aux;
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
        return "Training [id=" + id + ", court=" + court + ", userList=" + userList + ", initDate=" + initDate + ", endDate=" + endDate
                + ", hourTrainningByDefault=" + hourTrainningByDefault + "]";
    }

}