package com.javamaster.application.controller;

import com.javamaster.application.dto.WalletDto;
import com.javamaster.application.service.WalletsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/wallets")
@Log
public class WalletsController {

    private final WalletsService walletsService;

    @GetMapping("/update/{walletId}")
    public String showUpdateWalletPage(@PathVariable Integer walletId,
                                       @RequestParam Integer userId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("id", walletId);
        model.addAttribute("wallet", walletsService.getById(walletId));
        log.info(String.valueOf(userId));
        return "updatewallet";
    }

    @PostMapping(value = "/update/{walletId}")
    public String updateUser(@PathVariable Integer walletId,
                             @ModelAttribute("wallet") WalletDto walletDto,
                             @ModelAttribute("userId") Integer userId) {
        log.info("Handing update wallet by id: " + walletId + "\n" + "Handing update wallet: " + walletDto);
        walletsService.updateWalletName(walletId, walletDto);

        return "redirect:/users/show/" + userId;
    }
}
