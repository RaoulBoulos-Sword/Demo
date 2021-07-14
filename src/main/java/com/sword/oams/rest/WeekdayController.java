package com.sword.oams.rest;

import com.sword.oams.domain.Room;
import com.sword.oams.domain.Weekdays;
import com.sword.oams.payload.request.WeekdayRequest;
import com.sword.oams.repository.WeekDayRepository;
import com.sword.oams.service.WeekDayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/days")
@Api(tags = "Weekday")
public class WeekdayController {
    @Autowired
    WeekDayService weekDayService;

    @GetMapping("")
    List<Weekdays> allDays() {
        return weekDayService.getAllWeekDays();
    }

    @PostMapping("")
    Weekdays addWeekday(@RequestBody WeekdayRequest request) {
        return weekDayService.addWeekDay(request);
    }

    @GetMapping("/{id}")
    Weekdays getWeekday(@PathVariable Long id) {
        return weekDayService.getWeekDayById(id);
    }

    @DeleteMapping("/{id}")
    void deleteWeekday(@PathVariable Long id) {
        weekDayService.deleteWeekDayById(id);
    }
}
