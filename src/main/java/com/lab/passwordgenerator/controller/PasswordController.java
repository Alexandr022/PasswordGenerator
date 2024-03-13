package com.lab.passwordgenerator.controller;

import com.lab.passwordgenerator.dto.PasswordDTO;
import com.lab.passwordgenerator.service.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private final PasswordGenerator passwordGenerator;

    @Autowired
    public PasswordController(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @GetMapping("/generate")
    public PasswordDTO generatePassword(
            @RequestParam(name = "length", defaultValue = "12") int length,
            @RequestParam(name = "includeUppercase", defaultValue = "true") boolean includeUppercase,
            @RequestParam(name = "includeNumbers", defaultValue = "true") boolean includeNumbers,
            @RequestParam(name = "includeSpecial", defaultValue = "true") boolean includeSpecial) {

        String generatedPassword = passwordGenerator.generatePassword(length, includeUppercase, includeNumbers, includeSpecial);
        return new PasswordDTO(generatedPassword);
    }
}
