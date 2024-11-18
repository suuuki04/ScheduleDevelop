package com.example.scheduledevelop.dto.schedule;

import com.example.scheduledevelop.entity.Schedule;

public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String title;
    private String contents;

    public ScheduleResponseDto(Long id, String username, String title, String contents) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(), schedule.getContents());
    }
}
