package com.example.back_end.AiProfileApp.service.logic;

import com.example.back_end.AiProfileApp.dto.logic.GetTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.NewTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.UpdateTransactionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface TransactionService {
    List<GetTransactionDTO> getTransactions();

    NewTransactionDTO saveTransaction(NewTransactionDTO transactionDTO);

    UpdateTransactionDTO updateTransaction(UpdateTransactionDTO transactionDTO);

    void deleteTransaction(Long id);

    void exportExcel(HttpServletResponse response);

    void importExcel(HttpServletRequest request);
}
