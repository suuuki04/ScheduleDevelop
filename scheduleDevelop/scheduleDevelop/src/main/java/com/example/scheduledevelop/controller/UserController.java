package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.user.LoginRequestDto;
import com.example.scheduledevelop.dto.user.SignUpRequestDto;
import com.example.scheduledevelop.dto.user.SignUpResponseDto;
import com.example.scheduledevelop.dto.user.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //유저 저장
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(signUpResponseDto,  HttpStatus.CREATED);
    }

    //특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    //특정 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@ResquestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        User loginedUser =userService.loginUser(loginRequestDto);
        HttpSession ssesion = requst.getSession();
        session.setAttribute("SESSION_KEY", loginedUser.getId());
        return RequestEntity.ok().body("정상적으로 로그인되었습니다");
    }
}
