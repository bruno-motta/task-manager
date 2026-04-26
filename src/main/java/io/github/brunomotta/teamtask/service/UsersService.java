package io.github.brunomotta.teamtask.service;

import io.github.brunomotta.teamtask.dto.request.UsersRequestDto;
import io.github.brunomotta.teamtask.dto.response.UsersResponseDto;
import io.github.brunomotta.teamtask.entity.Users;
import io.github.brunomotta.teamtask.mappers.UsersMappers;
import io.github.brunomotta.teamtask.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;


    public UsersResponseDto createUsers(UsersRequestDto usersRequestDto){
        validateEmail(usersRequestDto.email());

        Users users = new Users();
        users.setName(usersRequestDto.name());
        users.setEmail(usersRequestDto.email());
        users.setPassword(passwordEncoder.encode(usersRequestDto.password()));
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

