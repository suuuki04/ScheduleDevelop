package com.example.scheduledevelop.dto.schedule;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    public final String title;
    public final String contents;

    public UpdateScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

