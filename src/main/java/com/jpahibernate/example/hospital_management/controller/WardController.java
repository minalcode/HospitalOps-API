
package com.jpahibernate.example.hospital_management.controller;

import com.jpahibernate.example.hospital_management.model.Ward;
import com.jpahibernate.example.hospital_management.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ward/apis")
public class WardController {

    @Autowired
    WardService wardService;

    @PostMapping("/save")
    public String saveWard(@RequestBody Ward ward) {
        return wardService.saveWard(ward);
    }

    @GetMapping("/findById/{id}")
    public Ward findWardById(@PathVariable int id) {
        return wardService.getWardById(id);
    }

    @GetMapping("/findAll")
    public List<Ward> findAllWards() {
        return wardService.getAllWards();
    }

    @GetMapping("/count")
    public String countWards() {
        return wardService.countWards();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWardById(@PathVariable int id) {
        return wardService.deleteWardById(id);
    }

    @PutMapping("/updatePut/{id}")
    public String updateWardUsingPut(
            @PathVariable int id,
            @RequestBody Ward newWard) {
        return wardService.updateWardUsingPut(id, newWard);
    }

    @PatchMapping("/updatePatch/{id}")
    public String updateWardUsingPatch(
            @PathVariable int id,
            @RequestParam String newWardName) {
        return wardService.updateWardUsingPatch(id, newWardName);
    }
}
