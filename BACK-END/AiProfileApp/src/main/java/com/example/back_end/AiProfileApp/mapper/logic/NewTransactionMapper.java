package com.example.back_end.AiProfileApp.mapper.logic;

import com.example.back_end.AiProfileApp.dto.logic.NewTransactionDTO;
import com.example.back_end.AiProfileApp.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NewTransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true) // El campo correcto en la entidad
    Transaction toEntity(NewTransactionDTO newTransactionDTO);
}
