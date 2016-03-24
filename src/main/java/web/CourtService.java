package web;

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
            return true;
        }
    }

    public void delete(int id) {
        courtList.remove(new Court(id));
    }

    public int generateId() {
        return id++;
    }
    
    public Map<Integer, String> activeCourtMap() {
        Map<Integer, String> activeCourtMap = new HashMap<>();
        activeCourtMap.put(1, "Activo");
        activeCourtMap.put(0, "Inactivo");
        return activeCourtMap;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
