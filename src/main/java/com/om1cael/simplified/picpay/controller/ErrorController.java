package com.om1cael.simplified.picpay.controller;

import com.om1cael.simplified.picpay.exception.MerchantTransferException;
import com.om1cael.simplified.picpay.exception.NotEnoughBalanceException;
import com.om1cael.simplified.picpay.exception.UnauthorizedTransactionException;
import com.om1cael.simplified.picpay.model.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(MerchantTransferException.class)
    private ResponseEntity<JsonResponse> merchantTransferException(MerchantTransferException e) {
        return ResponseEntity.badRequest().body(new JsonResponse(false, e.getMessage()));
    }

    @ExceptionHandler(NotEnoughBalanceException.class)
    private ResponseEntity<JsonResponse> notEnoughBalanceException(NotEnoughBalanceException e) {
        return ResponseEntity.badRequest().body(new JsonResponse(false, e.getMessage()));
    }

    @ExceptionHandler(UnauthorizedTransactionException.class)
    private ResponseEntity<JsonResponse> unauthorizedTransactionException(UnauthorizedTransactionException e) {
        return ResponseEntity.badRequest().body(new JsonResponse(false, e.getMessage()));
    }
}
