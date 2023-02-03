package com.javamaster.application.controller;

import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transactions")
@Log
public class TransactionsController {

    private final TransactionsService transactionsService;

    @GetMapping("/create-transaction/{id}")
    public String showCreateTransactionPage(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "createtransaction";
    }
    @PostMapping(value = "/create-transaction/{id}")
    public String createTransaction(@PathVariable Integer id, @ModelAttribute("transaction") TransactionsDto transactionsDto) throws ValidationException{
        log.info("Handing create transaction: " + transactionsDto);
        TransactionsDto createdTransaction = transactionsService.createTransaction(id, transactionsDto);
        log.info("Handing read saved transaction: " + createdTransaction);
        return "redirect:/show/{id}";
    }
}
