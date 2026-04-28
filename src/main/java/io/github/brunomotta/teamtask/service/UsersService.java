package io.github.brunomotta.teamtask.service;

import io.github.brunomotta.teamtask.dto.request.UsersRequestDto;
import io.github.brunomotta.teamtask.dto.response.UsersResponseDto;
import io.github.brunomotta.teamtask.entity.Users;
import io.github.brunomotta.teamtask.entity.role.UsersRole;
import io.github.brunomotta.teamtask.mappers.UsersMappers;
import io.github.brunomotta.teamtask.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        users.setRole(UsersRole.USER);

        Users savedUsers = usersRepository.save(users);

        return UsersMappers.toResponse(savedUsers);

    }

    public Page<UsersResponseDto> listAllUsersbyName(String name, Pageable pageable){
        Page<Users> page;

        if(name != null && !name.isBlank()){
            page = usersRepository.findByNameContainingIgnoreCase(name, pageable);
        }else{
            page = usersRepository.findAll(pageable);
        }

        return page.map(UsersMappers::toResponse);

    }

    private void validateEmail(String email) {
        if (usersRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");

        }
    }



}

