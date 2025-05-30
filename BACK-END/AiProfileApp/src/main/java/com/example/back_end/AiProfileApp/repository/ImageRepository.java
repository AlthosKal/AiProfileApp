package com.example.back_end.AiProfileApp.repository;

import com.example.back_end.AiProfileApp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
