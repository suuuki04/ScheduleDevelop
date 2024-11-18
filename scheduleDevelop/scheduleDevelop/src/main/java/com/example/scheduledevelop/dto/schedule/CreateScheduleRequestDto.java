package com.example.scheduledevelop.dto.schedule;

public class CreateScheduleRequestDto {

    private String username;
    private String title;
    private String contents;

    public CreateScheduleRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
