package com.example.Hospital.Management;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {
    //this is a class which contains the database
    HashMap<Integer, Nurse> nurseDB = new HashMap<>();
    public String addNurse(Nurse nurse) {
        int key  = nurse.getNurseId();
        nurseDB.put(key, nurse);
        return "Nurse added Successfully!";
    }
    public List<Nurse> getAllNurses() {
        return nurseDB.values().stream().toList();
    }
}
