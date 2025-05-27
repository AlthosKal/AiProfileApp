package com.example.back_end.AiProfileApp.dto.image;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String id_image;
}
