package io.github.brunomotta.teamtask.controller;

import io.github.brunomotta.teamtask.dto.response.UsersResponseDto;
import io.github.brunomotta.teamtask.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDto> findByid(@PathVariable UUID id){
        return ResponseEntity.ok(usersService.searchById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<UsersResponseDto> findByEmailUsers(@RequestParam String email){
        return ResponseEntity.ok(usersService.searchByEmail(email));
    }
}
