package com.learningChirag.challangesApp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallangeService {
    private List<Challange> challanges = new ArrayList<>();
    private int nextId = 1;
    public ChallangeService(){

    }

    public List<Challange> getAllChallanges(){
        return challanges;
    }

    public Boolean addChallange(Challange challange) {
        if (challange != null) {
            challange.setId(nextId++);
            challanges.add(challange);
            return true;
        }else{
            return false;
        }
    }

    public Challange getChallangeById(String month) {
        for(Challange challange: challanges){
            if (challange.getMonth().equalsIgnoreCase(month)){
                return challange;
            }
        }
        return null;
    }

    public boolean updateChallange(int id, Challange updatedChallange) {
        for(Challange challange: challanges){
            if (challange.getId().equals(id)){
                challange.setId(updatedChallange.getId());
                challange.setMonth(updatedChallange.getMonth());
                challange.setDescription(updatedChallange.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallangeById(int id) {
        return challanges.removeIf(challange -> challange.getId().equals(id));
    }
}
