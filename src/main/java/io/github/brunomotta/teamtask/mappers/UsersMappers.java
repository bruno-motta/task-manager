package io.github.brunomotta.teamtask.mappers;

import io.github.brunomotta.teamtask.dto.request.UsersRequestDto;
import io.github.brunomotta.teamtask.dto.response.UsersResponseDto;
import io.github.brunomotta.teamtask.entity.Users;

public class UsersMappers {

    public static Users toEntity(UsersRequestDto requestDto){
        return new Users(
                null,
                requestDto.name(),
                requestDto.email(),
                requestDto.role()
        );
    }

    public static UsersResponseDto toResponse(Users users){
        return new UsersResponseDto(
                users.getId(),
                users.getName(),
                users.getEmail(),
                users.getRole(),
                users.getCreateAt()
        );
    }

}
