package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.schedule.CreateScheduleRequestDto;
import com.example.scheduledevelop.dto.schedule.ScheduleResponseDto;
import com.example.scheduledevelop.dto.schedule.UpdateScheduleRequestDto;
import com.example.scheduledevelop.service.ScheduleService;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduled")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UserService userService;

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());

    return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    //전체 일정 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    //일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<UpdateScheduleRequestDto> update(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        scheduleService.update(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>( HttpStatus.OK);
    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
