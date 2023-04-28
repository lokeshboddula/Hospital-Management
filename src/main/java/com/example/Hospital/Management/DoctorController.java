package com.example.Hospital.Management;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    HashMap<Integer, Doctor> doctorDB = new HashMap<>();

    @PostMapping("/add")

    public String add(@RequestBody Doctor doctor) {

        if(doctorDB.containsKey(doctor.getDoctorId())) {
            return "Duplicate ID!";
        } else {
            int doctorId = doctor.getDoctorId();
            doctorDB.put(doctorId, doctor);
            return "Doctor added successfully!";
        }

    }
}
