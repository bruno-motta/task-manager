package io.github.brunomotta.teamtask.controller;

import io.github.brunomotta.teamtask.dto.response.UsersResponseDto;
import io.github.brunomotta.teamtask.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<Page<UsersResponseDto>> listAllUsers(@RequestParam(required = false) String name,
                                                               @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return ResponseEntity.ok(usersService.listAllUsersbyName(name, pageable));
    }
}
