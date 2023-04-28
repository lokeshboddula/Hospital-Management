package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")

public class PatientController {

    HashMap<Integer, Patient> patientDB = new HashMap<>();
    @PostMapping("/addViaParameters")
    public String add(@RequestParam("patientId") Integer patientId, @RequestParam("name") String name,
                                @RequestParam("disease") String disease, @RequestParam("age") Integer age) {
        Patient patient = new Patient(patientId, name, disease, age);
        patientDB.put(patientId, patient);

        return "Patient added successfully via parameters!";
    }

    @PostMapping("/addViaRequestBody")
    public String add(@RequestBody Patient patient) {
        int key = patient.getPatientId();
        patientDB.put(key, patient);

        return "Patient added successfully via RequestBody!";
    }

    @GetMapping("/getInfo")
    public Patient getInfo(@RequestParam("patientId") Integer patientId) {
        Patient patient = patientDB.get(patientId);

        return patient;
    }

    @GetMapping("/getByName")
    public Patient getByName(@RequestParam("name") String name) {

        for (Patient p : patientDB.values()){
            if(p.getName().equals(name)){
                return  p;
            }
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDB.values()) {
            patients.add(p);
        }
        return patients;
    }

    @GetMapping("/getListGreaterThanAge")

    public List<Patient> getListGreaterThanAge(@RequestParam("age") Integer age){
        List<Patient> patientList = new ArrayList<>();

        for(Patient p : patientDB.values()){
            if(p.getAge() > age) {
                patientList.add(p);
            }
        }
        return patientList;
    }

    @GetMapping("/get/{disease}")

    public List<Patient> get(@PathVariable("disease") String disease) {
        List<Patient> list = new ArrayList<>();
        for (Patient p : patientDB.values()) {
            if(p.getDisease().equals(disease)) {
                list.add(p);
            }
        }
        return list;
    }
    @GetMapping("/get/{age}/{disease}")

    public List<Patient> get(@PathVariable("age") Integer age,
                                     @PathVariable("disease") String disease) {
        List<Patient> list = new ArrayList<>();
        for (Patient p : patientDB.values()) {
            if(p.getAge() > age && p.getDisease().equals(disease)) {
                list.add(p);
            }
        }
        return list;
    }

    @PutMapping("/update")

    public String update(@RequestBody Patient patient) {
        int key = patient.getPatientId();
        if(patientDB.containsKey(key)) {
            patientDB.put(key, patient);
            return "details updated!";
        }
        else return "No record found!";
    }

    @PutMapping("/updateDisease")

    public String updateDisease(@RequestParam("patientId") Integer patientId, @RequestParam("disease") String disease) {

        if(patientDB.containsKey(patientId)) {
            Patient patient = patientDB.get(patientId);
            int key = patient.getPatientId();
            patient.setDisease(disease);
            patientDB.put(key, patient);
            return "details updated!";
        } else return "Patient not Found!";
    }
    @DeleteMapping("/delete")

    public String delete(@RequestParam("patientId") Integer patientId) {

        if(patientDB.containsKey(patientId)) {

            patientDB.remove(patientId);

            return "deleted Successfully!";
        }
        return "Patient doesn't exist!";
    }
}
