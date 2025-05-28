package com.example.back_end.AiProfileApp.service.logic;

import com.example.back_end.AiProfileApp.dto.logic.GetTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.NewTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.UpdateTransactionDTO;
import com.example.back_end.AiProfileApp.entity.Transaction;
import com.example.back_end.AiProfileApp.mapper.logic.GetTransactionMapper;
import com.example.back_end.AiProfileApp.mapper.logic.NewTransactionMapper;
import com.example.back_end.AiProfileApp.mapper.logic.UpdateTransactionMapper;
import com.example.back_end.AiProfileApp.repository.TransactionRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final ExcelService excelService;
    private final TransactionRepository transactionRepository;
    private final GetTransactionMapper getTransactionMapper;
    private final NewTransactionMapper newTransactionMapper;
    private final UpdateTransactionMapper updateTransactionMapper;

    @Override
    public List<GetTransactionDTO> getTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return getTransactionMapper.toDTOList(transactions);
    }

    @Override
    public void saveTransaction(NewTransactionDTO transactionDTO) {
        Transaction transaction = newTransactionMapper.toEntity(transactionDTO);
        transactionRepository.save(transaction);
        newTransactionMapper.toDTO(transaction);
    }

    @Override
    public UpdateTransactionDTO updateTransaction(UpdateTransactionDTO transactionDTO) {
        if (transactionRepository.existsById(transactionDTO.getId())) {
            Transaction transaction = updateTransactionMapper.toEntity(transactionDTO);
            transactionRepository.save(transaction);
            return updateTransactionMapper.toDTO(transaction);
        }
        return null;
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public void exportExcel(HttpServletResponse response) {
        excelService.exportTransactions(response);
    }

    @Override
    public void importExcel(HttpServletRequest request) {
        excelService.importTransactions(request);
    }

}
