package io.github.brunomotta.teamtask.controller;

import io.github.brunomotta.teamtask.dto.request.UsersRequestDto;
import io.github.brunomotta.teamtask.dto.response.UsersResponseDto;
import io.github.brunomotta.teamtask.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public final UsersService usersService;

    public AuthController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<UsersResponseDto> register(@Valid @RequestBody UsersRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.createUsers(requestDto));
    }
}
