package com.appdev.core.ocampog4.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.core.ocampog4.entity.ClassEntity;
import com.appdev.core.ocampog4.repository.ClassRepository;

// @Service annotation defines this class as a Service Layer component
@Service("ClassService") // Following lecture style annotation
public class ClassService {

    // Repository interface for accessing the database
    @Autowired
    ClassRepository crepo; // Following lecture variable naming style

    // C // Create or insert record in tblClass
    public ClassEntity insertClass(ClassEntity classEntity) {
        return crepo.save(classEntity);
    }

    // R // Read all records in tblClass
    public List<ClassEntity> getAllClasses() {
        return crepo.findAll();
    }

    // U // Update a class record
    // @SuppressWarnings("finally") // Added to silence warning, following lecture
    public ClassEntity updateClass(Long cid, ClassEntity newClassDetails) {
        ClassEntity currentClass = new ClassEntity(); // Initialize object

        try {
            // 1. Search the ID number of the class that will be updated
            Optional<ClassEntity> classOptional = crepo.findById(cid);
            if (classOptional.isPresent()) {
                currentClass = classOptional.get();

                // 2. Update the record details
                currentClass.setClassName(newClassDetails.getClassName());
                currentClass.setClassDesc(newClassDetails.getClassDesc());
            } else {
                throw new NoSuchElementException("Class with ID " + cid + " does not exist.");
            }
        } catch (NoSuchElementException ex) {
            // Throw exception if not found
            throw new NoSuchElementException(ex.getMessage());
        } finally {
            // Save the updated record
            return crepo.save(currentClass);
        }
    }

    // D // Delete a class record
    public String deleteClass(Long cid) {
        String msg = "";
        Optional<ClassEntity> classOptional = crepo.findById(cid);

        if (classOptional.isPresent()) {
            crepo.deleteById(cid);
            msg = "Class ID " + cid + " is successfully deleted!";
        } else {
            msg = "Class ID " + cid + " does not exist.";
        }
        return msg;
    }
}
