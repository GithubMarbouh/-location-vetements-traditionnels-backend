package com.marbouh.locationdevetementstraditionnels.exception;

public enum ErrorCodes {
    UTILISATEUR_NOT_FOUND(1000),
    UTILISATEUR_NOT_VALID(1001),
    UTILISATEUR_ALREADY_EXISTS(1002),
    UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID(1003),

    BAD_CREDENTIALS(12003)
            ;
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

}
