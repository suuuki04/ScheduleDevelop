package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.schedule.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleResponseDto save(String title, String contents,String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }

    //일정 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    //일정 수정
    @Transactional
    public ScheduleResponseDto update(Long id, String title, String contents) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.update(title,contents);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getContents());
    }

    //일정 삭제
    public void delete(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(findSchedule);
    }
}
