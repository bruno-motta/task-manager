package io.github.brunomotta.teamtask.dto.response;

import io.github.brunomotta.teamtask.entity.role.UsersRole;
import java.time.LocalDateTime;
import java.util.UUID;

public record UsersResponseDto(UUID id, String name, String email, UsersRole role, LocalDateTime createAt) {
}
