package com.Flapkap.VendingMachine.config.exception;

import com.Flapkap.VendingMachine.config.util.InfraUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> processBaseException(BaseException ex) {
        logger.error(InfraUtils.getStackTrace(ex));
        return new ResponseEntity<>(ex.toErrorDto(InfraUtils.getStackTrace(ex)), HttpStatus.valueOf(ex.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> processException(MethodArgumentNotValidException ex) {
        logger.error(InfraUtils.getStackTrace(ex));

        Map<String, Object> params = new HashMap<>();
        for (FieldError e : ex.getBindingResult().getFieldErrors()) params.put(e.getField(), e.getDefaultMessage());

        return new ResponseEntity<>(new ErrorDto(
                "validation",
                ex.getMessage(),
                params,
                InfraUtils.getStackTrace(ex)
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> processException(Exception ex) {
        logger.error(InfraUtils.getStackTrace(ex));
        return new ResponseEntity<>(new ErrorDto(
                "internal",
                ex.getMessage(),
                new HashMap<>(),
                InfraUtils.getStackTrace(ex)
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
