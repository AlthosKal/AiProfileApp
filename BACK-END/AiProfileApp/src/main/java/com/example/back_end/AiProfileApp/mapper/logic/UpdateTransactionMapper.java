package com.example.back_end.AiProfileApp.mapper.logic;

import com.example.back_end.AiProfileApp.dto.logic.NewTransactionDTO;
import com.example.back_end.AiProfileApp.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UpdateTransactionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Transaction toEntity(NewTransactionDTO newTransactionDTO);
}
