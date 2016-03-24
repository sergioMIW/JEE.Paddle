package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import data.entities.Court;

@Service
public class CourtService {

    private List<Court> courtList;

    private int id;

    private Boolean active;

    public CourtService() {
        courtList = new ArrayList<>();
        id=0;
    }

    public List<Court> findAll() {
        return courtList;
        
    }

    public Court findOne(int id) {
        for (Court court : courtList) {
            if (court.getId() == id) {
                return court;
            }
        }
        return null;
    }

    public boolean save(Court court) {
        if (courtList.contains(court)) {
            return false;
        } else {
            courtList.add(court);
            this.id++;
            return true;

        }
    }

    public void delete(int id) {
        courtList.remove(new Court(id));
    }

    public int generateId() {
        return id++;
    }

    public Map<Boolean, String> activeCourtMap() {
        Map<Boolean, String> activeCourtMap = new HashMap<>();
        activeCourtMap.put(true, "Activo");
        activeCourtMap.put(false, "Inactivo");
        return activeCourtMap;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
