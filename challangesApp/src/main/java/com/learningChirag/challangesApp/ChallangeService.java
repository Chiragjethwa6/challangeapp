package com.learningChirag.challangesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallangeService {

    private int nextId = 1;

    @Autowired
    private ChallangeRepository challangeRepository;

    public ChallangeService(){

    }

    public List<Challange> getAllChallanges(){
        return challangeRepository.findAll();
    }

    public Boolean addChallange(Challange challange) {
        if (challange != null) {
            challange.setId(nextId++);
            challangeRepository.save(challange);
            return true;
        }else{
            return false;
        }
    }

    public Challange getChallangeById(String month) {
        Optional<Challange> challange = challangeRepository.findByMonthIgnoreCase(month);
        return challange.orElse(null);
    }

    public boolean updateChallange(int id, Challange updatedChallange) {
        Optional<Challange> challange = challangeRepository.findById(id);
        if (challange.isPresent()){
            Challange challangeToUpdate = challange.get();
            challangeToUpdate.setMonth(updatedChallange.getMonth());
            challangeToUpdate.setDescription(updatedChallange.getDescription());
            challangeRepository.save(challangeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallangeById(int id) {
        Optional<Challange> challange = challangeRepository.findById(id);
        if (challange.isPresent()){
            Challange challangeToDelete = challange.get();
            challangeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
