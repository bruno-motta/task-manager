package io.github.brunomotta.teamtask.service;

import io.github.brunomotta.teamtask.dto.request.UsersRequestDto;
import io.github.brunomotta.teamtask.dto.response.UsersResponseDto;
import io.github.brunomotta.teamtask.entity.Users;
import io.github.brunomotta.teamtask.mappers.UsersMappers;
import io.github.brunomotta.teamtask.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder){
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsersResponseDto createUsers(UsersRequestDto usersRequestDto){
        validateEmail(usersRequestDto.email());

        Users users = new Users();
        users.setName(usersRequestDto.name());
        users.setEmail(usersRequestDto.email());
        users.setPassword(passwordEncoder.encode(usersRequestDto.passwod()));
        users.setRole(usersRequestDto.role());

        Users savedUsers = usersRepository.save(users);

        return UsersMappers.toResponse(savedUsers);

    }

    private void validateEmail(String email) {
        if (usersRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");

        }
    }



}

