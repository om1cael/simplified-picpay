package com.om1cael.simplified.picpay.service;

import com.om1cael.simplified.picpay.dto.TransferDTO;
import com.om1cael.simplified.picpay.exception.MerchantTransferException;
import com.om1cael.simplified.picpay.exception.NotEnoughBalanceException;
import com.om1cael.simplified.picpay.exception.UnauthorizedTransactionException;
import com.om1cael.simplified.picpay.model.User;
import com.om1cael.simplified.picpay.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferService {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    private final String TRANSACTION_AUTHORIZE_URL = "https://util.devi.tools/api/v2/authorize";

    public void transfer(TransferDTO transferDTO) {
        User sender = userService.getById(transferDTO.senderID());
        User receiver = userService.getById(transferDTO.receiverID());

        if(isMerchant(sender)) {
            throw new MerchantTransferException("Merchants can only receive");
        }

        if(!hasFunds(transferDTO, sender)) {
            throw new NotEnoughBalanceException("You don't have funds for the transaction");
        }

        if(!isAuthorized()) {
            throw new UnauthorizedTransactionException("This transaction was not authorized");
        }

        sender.setBalance(sender.getBalance() - transferDTO.amount());
        receiver.setBalance(receiver.getBalance() + transferDTO.amount());
    }

    private boolean hasFunds(TransferDTO transferDTO, User sender) {
        return sender.getBalance() >= transferDTO.amount();
    }

    private boolean isMerchant(User user) {
        return user.getUserType() == UserType.MERCHANT;
    }

    private boolean isAuthorized() {
        ResponseEntity<String> apiResponse = restTemplate.getForEntity(TRANSACTION_AUTHORIZE_URL, String.class);
        return apiResponse.getStatusCode() == HttpStatus.OK;
    }
}
