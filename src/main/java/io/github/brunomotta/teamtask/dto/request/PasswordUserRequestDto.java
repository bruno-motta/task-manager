package io.github.brunomotta.teamtask.dto.request;

import jakarta.validation.constraints.Pattern;

public record PasswordUserRequestDto(
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.#_-])[A-Za-z\\d@$!%*?&.#_-]{8,}$"
        , message = "A senha deve ter no mínimo 8 caracteres, 1 letra maiúscula, 1 minúscula, 1 número e 1 caractere especial.")
        String password
) {
}
