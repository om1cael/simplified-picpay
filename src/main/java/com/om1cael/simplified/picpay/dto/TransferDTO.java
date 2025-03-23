package com.om1cael.simplified.picpay.dto;

public record TransferDTO(Long senderID, Long receiverID, double amount) {
}
