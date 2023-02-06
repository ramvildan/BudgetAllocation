package com.javamaster.application.controller;

import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.service.TransactionsService;
import com.javamaster.application.service.WalletsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transactions")
@Log4j2
public class TransactionsController {

    private final TransactionsService transactionsService;
    private final WalletsService walletsService;

    @GetMapping("/create-income-transaction/{userId}")
    public String showCreateIncomeTransactionPage(@PathVariable Integer userId, Model model){
        model.addAttribute("transaction", new TransactionsDto());
        model.addAttribute("userId", userId);
        return "createincometransaction";
    }

    @PostMapping(value = "/create-income-transaction/{userId}")
    public String createIncomeTransaction(@PathVariable Integer userId,
                                          @ModelAttribute("transaction") TransactionsDto transactionsDto) throws ValidationException{
        log.info("createIncomeTransaction: userId = {}, transactionDto = {}", userId, transactionsDto);

        transactionsService.createIncomeTransaction(userId, transactionsDto);

        return "redirect:/users/show/" + userId;
    }

    @GetMapping("/create-expense-transaction/{userId}")
    public String showCreateExpenseTransactionPage(@PathVariable Integer userId, Model model){
        model.addAttribute("walletsList", walletsService.getAllByUserId(userId));
        model.addAttribute("transaction", new TransactionsDto());
        model.addAttribute("userId", userId);
        log.info(String.valueOf(userId));
        return "createexpensetransaction";
    }

    @PostMapping(value = "/create-expense-transaction/{userId}")
    public String createExpenseTransaction(@PathVariable Integer userId,
                                           @ModelAttribute("walletId") Integer walletId,
                                           @ModelAttribute("transaction") TransactionsDto transactionsDto) throws ValidationException{
        log.info("createExpenseTransaction: userId = {}, walletId = {}, transactionDto = {}", userId, walletId, transactionsDto);

        transactionsService.createExpenseTransaction(walletId, transactionsDto);

        return "redirect:/users/show/" + userId;
    }
}
