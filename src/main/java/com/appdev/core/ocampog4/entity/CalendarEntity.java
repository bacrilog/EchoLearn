package com.appdev.core.ocampog4.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblCalendar") // Using tbl prefix like lecture
public class CalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id") // Explicit column name
    private Long eventId;

    @Column(name="title")
    private String title;

    @Column(name="date")
    private LocalDate date;

    @Column(name="reminder_time")
    private LocalTime reminderTime;

    // Default Constructor (Required by JPA)
    public CalendarEntity() {
        super();
    }

    // Parameterized Constructor (Following lecture style)
    public CalendarEntity(Long eventId, String title, LocalDate date, LocalTime reminderTime) {
        super();
        this.eventId = eventId;
        this.title = title;
        this.date = date;
        this.reminderTime = reminderTime;
    }

    // --- Getters ---
    public Long getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    // --- Setters ---
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }
}
