package com.example.Hospital.Management;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse) {

        //we should write validations here...
        if(nurse.getNurseId() < 0) {
            return "Invalid NurseId!";
        }
        if(nurse.getName() == null) {
            return "Name should not be null!";
        }

        //saving to the DB
        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getAll() {
        List<Nurse> nurseList = nurseRepository.getAllNurses();
        return nurseList;
    }
    public List<Nurse> getList(int age) {
        List<Nurse> nurseList = nurseRepository.getAllNurses();

        List<Nurse> requiredList = new ArrayList<>();

        for(Nurse nurse : nurseList) {
            if(nurse.getAge() > age) {
                requiredList.add(nurse);
            }
        }
        return requiredList;
    }

    public List<Nurse> getByQualification(String qualification) {
        List<Nurse> nurseList = nurseRepository.getAllNurses();
        List<Nurse> requiredList = new ArrayList<>();

        for(Nurse nurse : nurseList) {
            if(nurse.getQualification().equals(qualification)) {
                requiredList.add(nurse);
            }
        }
        return requiredList;
    }
}
