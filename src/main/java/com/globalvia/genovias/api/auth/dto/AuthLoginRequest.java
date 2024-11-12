package com.globalvia.genovias.api.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String username,
    @NotBlank String password) {
}