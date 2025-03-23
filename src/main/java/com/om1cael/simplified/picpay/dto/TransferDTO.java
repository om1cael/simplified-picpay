package com.om1cael.simplified.picpay.dto;

public record TransferDTO(UserDTO sender, UserDTO receiver, double amount) {
}
