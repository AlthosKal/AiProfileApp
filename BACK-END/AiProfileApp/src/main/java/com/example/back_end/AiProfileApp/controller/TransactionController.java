package com.example.back_end.AiProfileApp.controller;

import com.example.back_end.AiProfileApp.dto.logic.GetTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.NewTransactionDTO;
import com.example.back_end.AiProfileApp.dto.logic.UpdateTransactionDTO;
import com.example.back_end.AiProfileApp.exception.ApiResponse;
import com.example.back_end.AiProfileApp.service.logic.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTransactionDTO>>> getAllTransactions(HttpServletRequest request) {
        List<GetTransactionDTO> transactions = transactionService.getTransactions();
        return ResponseEntity
                .ok(ApiResponse.ok("Transacciones obtenidas exitosamente", transactions, request.getRequestURI()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createTransaction(@RequestBody NewTransactionDTO newTransactionDTO,
            HttpServletRequest request) {
        transactionService.saveTransaction(newTransactionDTO);
        return ResponseEntity.ok(ApiResponse.ok("Transacción creada exitosamente", null, request.getRequestURI()));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<UpdateTransactionDTO>> updateTransaction(
            @RequestBody UpdateTransactionDTO updateTransactionDTO, HttpServletRequest request) {
        UpdateTransactionDTO updatedTransaction = transactionService.updateTransaction(updateTransactionDTO);
        if (updatedTransaction == null) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.<UpdateTransactionDTO> builder().success(false)
                            .message("No se encontró la transacción con el ID proporcionado")
                            .timestamp(LocalDateTime.now()).path(request.getRequestURI()).build());
        }
        return ResponseEntity.ok(
                ApiResponse.ok("Transacción actualizada exitosamente", updatedTransaction, request.getRequestURI()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTransaction(@PathVariable Long id, HttpServletRequest request) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok(ApiResponse.ok("Transacción eliminada exitosamente", null, request.getRequestURI()));
    }

    @GetMapping("/export")
    public void exportTransactionsToExcel(HttpServletResponse response) {
        transactionService.exportExcel(response);
    }

    @PostMapping("/import")
    public ResponseEntity<ApiResponse<Void>> importTransactionsFromExcel(HttpServletRequest request,
            HttpServletResponse response) {
        transactionService.importExcel(request);
        return ResponseEntity
                .ok(ApiResponse.ok("Transacciones importadas exitosamente", null, request.getRequestURI()));
    }
}