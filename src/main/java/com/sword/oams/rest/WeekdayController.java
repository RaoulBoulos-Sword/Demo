package com.sword.oams.rest;

import com.sword.oams.domain.Room;
import com.sword.oams.domain.Weekdays;
import com.sword.oams.repository.WeekDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/days")
public class WeekdayController {
    @Autowired
    WeekDayRepository weekDayRepository;

    @GetMapping("")
    List<Weekdays> allDays() {
        return weekDayRepository.findAll();
    }

    @PostMapping("")
    Weekdays addWeekday(@RequestBody Weekdays day) {
        return weekDayRepository.save(day);
    }

    @GetMapping("/{id}")
    Weekdays getWeekday(@PathVariable Long id) {
        return weekDayRepository.findById(id).orElseThrow(null);
    }

    @PutMapping("/{id}")
    Room updateWeekday(@RequestBody Room newRoom,@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    void deleteWeekday(@PathVariable Long id) {
        weekDayRepository.deleteById(id);
    }
}
