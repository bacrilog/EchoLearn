package com.appdev.core.ocampog4.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.core.ocampog4.entity.CalendarEntity;
import com.appdev.core.ocampog4.repository.CalendarRepository;

// @Service annotation defines this class as a Service Layer component
@Service("CalendarService") // Following lecture style annotation
public class CalendarService {

    // Repository interface for accessing the database
    @Autowired
    CalendarRepository calRepo; // Following lecture variable naming style

    // C // Create or insert record in tblCalendar
    public CalendarEntity insertCalendarEvent(CalendarEntity calendarEntity) {
        return calRepo.save(calendarEntity);
    }

    // R // Read all records in tblCalendar
    public List<CalendarEntity> getAllCalendarEvents() {
        return calRepo.findAll();
    }

    // U // Update a calendar event record
    // @SuppressWarnings("finally") // Added to silence warning, following lecture
    public CalendarEntity updateCalendarEvent(Long eventId, CalendarEntity newCalendarDetails) {
        CalendarEntity currentEvent = new CalendarEntity(); // Initialize object

        try {
            // 1. Search the ID number of the event that will be updated
            Optional<CalendarEntity> eventOptional = calRepo.findById(eventId);
            if (eventOptional.isPresent()) {
                currentEvent = eventOptional.get();

                // 2. Update the record details
                currentEvent.setTitle(newCalendarDetails.getTitle());
                currentEvent.setDate(newCalendarDetails.getDate());
                currentEvent.setReminderTime(newCalendarDetails.getReminderTime());
            } else {
                throw new NoSuchElementException("Calendar Event ID " + eventId + " does not exist.");
            }
        } catch (NoSuchElementException ex) {
            // Throw exception if not found
            throw new NoSuchElementException(ex.getMessage());
        } finally {
            // Save the updated record
            return calRepo.save(currentEvent);
        }
    }

    // D // Delete a calendar event record
    public String deleteCalendarEvent(Long eventId) {
        String msg = "";
        Optional<CalendarEntity> eventOptional = calRepo.findById(eventId);

        if (eventOptional.isPresent()) {
            calRepo.deleteById(eventId);
            msg = "Calendar Event ID " + eventId + " is successfully deleted!";
        } else {
            msg = "Calendar Event ID " + eventId + " does not exist.";
        }
        return msg;
    }
}
