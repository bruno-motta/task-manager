package io.github.brunomotta.teamtask.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsersRequestDto(
        @NotNull(message = "Digite o seu nome!")
        @Size(max = 155)
        String name,

        @Email
        @NotNull(message = "Digite o E-mail!")
        @Size(min = 0, max = 155)
        String email

) {
}
