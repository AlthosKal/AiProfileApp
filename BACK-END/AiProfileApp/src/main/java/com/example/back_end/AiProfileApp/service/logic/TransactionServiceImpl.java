package com.example.back_end.AiProfileApp.service.logic;

import com.example.back_end.AiProfileApp.dto.logic.GetTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.NewTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.UpdateTransactionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public List<GetTransactionDTO> getTransactions() {
        return null;
    }

    @Override
    public NewTransactionDTO saveTransaction(NewTransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public UpdateTransactionDTO updateTransaction(UpdateTransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public void deleteTransaction(Long id) {

    }

    @Override
    public void exportExcel(HttpServletResponse response) {

    }

    @Override
    public void importExcel(HttpServletRequest request) {

    }
}
