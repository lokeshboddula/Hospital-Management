package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    NurseService nurseService = new NurseService();
    @PostMapping("/add")
    public String add(@RequestBody Nurse nurse) {

        String ans = nurseService.addNurse(nurse);
        return ans;
    }

    @GetMapping("/getAll")
    public List<Nurse> getALlNurses() {
        List<Nurse> nurseList = nurseService.getAll();
        return nurseList;
    }
    @GetMapping("/getList")
    public List<Nurse> getListGreaterThanAge(@RequestParam("age") Integer age) {
        List<Nurse> nurseList = nurseService.getList(age);
        return nurseList;
    }
    @GetMapping("/getByQualification")
    public List<Nurse> getByQualification(@RequestParam("qualification") String qualification) {
        List<Nurse> listByQual = nurseService.getByQualification(qualification);
        return listByQual;
    }
}
