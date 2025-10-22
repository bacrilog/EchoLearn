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

import com.appdev.core.ocampog4.entity.CalendarEntity;
import com.appdev.core.ocampog4.service.CalendarService;

// Uses /calendars as the base path, following your logical naming choice
@RestController
@RequestMapping("/calendars") 
public class CalendarController {

    // Inject the Service Layer using @Autowired, following lecture style
    @Autowired
    CalendarService calServ;

    // C // Create or insert calendar event record
    @PostMapping("/insertCalendarEvent") // Following lecture mapping style
    public CalendarEntity insertCalendarEvent(@RequestBody CalendarEntity calendarEntity) {
        return calServ.insertCalendarEvent(calendarEntity);
    }

    // R // Read all calendar event records
    @GetMapping("/getAllCalendarEvents") // Following lecture mapping style
    public List<CalendarEntity> getAllCalendarEvents() {
        return calServ.getAllCalendarEvents();
    }

    // U // Update a calendar event record (using @RequestParam for ID, matching lecture style)
    @PutMapping("/updateCalendarEvent") // Following lecture mapping style
    public CalendarEntity updateCalendarEvent(@RequestParam Long eventId, @RequestBody CalendarEntity newCalendarDetails) {
        return calServ.updateCalendarEvent(eventId, newCalendarDetails);
    }

    // D // Delete a calendar event record (using @PathVariable, returning String message)
    @DeleteMapping("/deleteCalendarEvent/{eventId}") // Following lecture mapping style
    public String deleteCalendarEvent(@PathVariable Long eventId) {
        return calServ.deleteCalendarEvent(eventId);
    }
}
