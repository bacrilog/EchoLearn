package com.appdev.core.ocampog4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblClass") // Using tbl prefix like lecture
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="class_id") // Explicit column name
    private Long classId;

    @Column(name="class_name")
    private String className;

    @Column(name="class_desc")
    private String classDesc;

    // Default Constructor (Required by JPA)
    public ClassEntity() {
        super();
    }

    // Parameterized Constructor (Following lecture style)
    public ClassEntity(Long classId, String className, String classDesc) {
        super();
        this.classId = classId;
        this.className = className;
        this.classDesc = classDesc;
    }

    // --- Getters ---
    public Long getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public String getClassDesc() {
        return classDesc;
    }

    // --- Setters ---
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }
}
