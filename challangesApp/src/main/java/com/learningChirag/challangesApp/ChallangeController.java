package com.learningChirag.challangesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challanges")
public class ChallangeController {
    @Autowired
    private ChallangeService challangeService;

//    public ChallangeController(ChallangeService challangeService){
//        this.challangeService = challangeService;
//    }

    @GetMapping
    public ResponseEntity<List<Challange>> getAllChallanges() {
        return new ResponseEntity<>(challangeService.getAllChallanges(), HttpStatus.OK);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challange> getChallangeById(@PathVariable String month){
        Challange challange = challangeService.getChallangeById(month);
        if (challange != null){
            return new ResponseEntity<>(challange,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> addChallange(@RequestBody Challange challange){
        boolean challangeAdded = challangeService.addChallange(challange);
        if(challangeAdded){
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallange(@PathVariable int id, @RequestBody Challange updatedChallange){
        boolean isUpdated = challangeService.updateChallange(id, updatedChallange);
        if(isUpdated){
            return new ResponseEntity<>("Updated", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallange(@PathVariable int id){
        boolean isDeleted = challangeService.deleteChallangeById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not Deleted", HttpStatus.NOT_FOUND);
        }
    }
}
