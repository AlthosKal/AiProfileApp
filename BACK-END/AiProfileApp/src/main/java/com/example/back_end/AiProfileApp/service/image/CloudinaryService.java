package com.example.back_end.AiProfileApp.service.image;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    Map<String, Object> upload(MultipartFile multipartFile) throws IOException;

    Map<String, Object> delete(String id) throws IOException;
}
