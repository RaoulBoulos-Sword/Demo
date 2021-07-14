package com.sword.oams.service;

import com.sword.oams.domain.WDay;
import com.sword.oams.domain.Weekdays;
import com.sword.oams.payload.request.WeekdayRequest;
import com.sword.oams.repository.WeekDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class WeekDayService {

    @Autowired
    WeekDayRepository weekDayRepository;

    public List<Weekdays> getAllWeekDays() {
        return weekDayRepository.findAll();
    }

    public Weekdays getWeekDayById(Long id) {
        return weekDayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: WeekDay Id Not Found"));
    }

    public void deleteWeekDayById(Long id) {
        weekDayRepository.deleteById(id);
    }

    public Weekdays addWeekDay(@RequestBody WeekdayRequest request) {
        Weekdays newWeekday = Weekdays.builder()
                .weekDay(WDay.valueOf(request.getWeekDay()))
                .weekDayId(request.getId())
                .build();

        return weekDayRepository.save(newWeekday);
    }

}
