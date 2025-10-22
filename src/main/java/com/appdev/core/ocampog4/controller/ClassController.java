package com.appdev.core.ocampog4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.core.ocampog4.entity.ClassEntity;
import com.appdev.core.ocampog4.service.ClassService;

// Uses /classes as the base path, following your logical naming choice
@RestController
@RequestMapping("/classes") 
public class ClassController {

    // Inject the Service Layer using @Autowired, following lecture style
    @Autowired
    ClassService cServ;

    // C // Create or insert class record
    @PostMapping("/insertClass") // Following lecture mapping style
    public ClassEntity insertClass(@RequestBody ClassEntity classEntity) {
        return cServ.insertClass(classEntity);
    }

    // R // Read all class records
    @GetMapping("/getAllClasses") // Following lecture mapping style
    public List<ClassEntity> getAllClasses() {
        return cServ.getAllClasses();
    }

    // U // Update a class record (using @RequestParam for ID, matching lecture style)
    @PutMapping("/updateClass") // Following lecture mapping style
    public ClassEntity updateClass(@RequestParam Long cid, @RequestBody ClassEntity newClassDetails) {
        return cServ.updateClass(cid, newClassDetails);
    }

    // D // Delete a class record (using @PathVariable, returning String message)
    @DeleteMapping("/deleteClass/{cid}") // Following lecture mapping style
    public String deleteClass(@PathVariable Long cid) {
        return cServ.deleteClass(cid);
    }
}
