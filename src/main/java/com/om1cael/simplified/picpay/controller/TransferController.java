package com.om1cael.simplified.picpay.controller;

import com.om1cael.simplified.picpay.dto.TransferDTO;
import com.om1cael.simplified.picpay.dto.UserDTO;
import com.om1cael.simplified.picpay.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping
    private ResponseEntity<UserDTO> transfer(@RequestBody @Valid TransferDTO transferDTO) {
        UserDTO userDTO = transferService.transfer(transferDTO);
        return ResponseEntity.ok().body(userDTO);
    }
}
