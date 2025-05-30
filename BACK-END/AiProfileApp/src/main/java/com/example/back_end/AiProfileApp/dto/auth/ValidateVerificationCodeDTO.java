package com.example.back_end.AiProfileApp.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateVerificationCodeDTO {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String code;
}
