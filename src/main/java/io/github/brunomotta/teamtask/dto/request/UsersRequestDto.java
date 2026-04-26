package io.github.brunomotta.teamtask.dto.request;

import io.github.brunomotta.teamtask.entity.role.UsersRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsersRequestDto(
        @NotNull(message = "Digite o seu nome!")
        @Size(max = 155)
        String name,

        @Email
        @NotNull(message = "Digite o E-mail!")
        @Size(min = 0, max = 155)
        String email,

        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.#_-])[A-Za-z\\d@$!%*?&.#_-]{8,}$"
                , message = "A senha deve ter no mínimo 8 caracteres, 1 letra maiúscula, 1 minúscula, 1 número e 1 caractere especial.")
        String passwod,

        UsersRole role


) {
}
