package com.demirel.socialmedia.model.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import static com.demirel.socialmedia.util.CommonConstants.EXCEPTION.DEFAULT_CODE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum BusinessValidationRule implements IBusinessValidationRule {

    USER_NOT_FOUND("0001", "Kullanıcı Bulunmadı!"),
    USER_AND_POST_NOT_FOUND("0002", "Kullanıcı veya Post Bulunmadı!"),
    POST_NOT_FOUND("0003", "Post Bulunmadı!"),
    LIKE_NOT_DELETED("0004", "Like Silinemedi!"),
    LIKE_NOT_FOUND("0005", "Like Bulunamadı!"),
    LIKE_NOT_CREATED("0006", "Like Oluşturulamadı!");

    private String code = DEFAULT_CODE;
    private final String message;
    private HttpStatus httpStatus = BAD_REQUEST;

    BusinessValidationRule(String code, String message) {
        this.code = code;
        this.message = message;
    }
    BusinessValidationRule(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
