package com.practicalunittesting;

/**
 * Created by otsukanov on 20.02.2015.
 */
public class PasswordValidator {

    public static final String UNDERSCORE_SYMBOL = "_";

    public static final String HASH_SYMBOL = "#";

    private int minLength;

    private int maxLength;

    public PasswordValidator(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public void validate(String password) throws Exception {
        if(password == null){
            throw new NullPointerException();
        }
        validateMinLength(password);
        validateMaxLength(password);
        validatePassContainsUnderscoreSymbol(password);
        validatePassContainsHashSymbol(password);
        validateMixtureOfCapitalAndLowerLetters(password);
    }

    private void validateMixtureOfCapitalAndLowerLetters(String password) throws Exception {
        boolean lowerCaseLetterPresent = false;
        boolean capitalCaseLetterPresent = false;
        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(Character.isLowerCase(c)){
                lowerCaseLetterPresent = true;
            }
            if(Character.isUpperCase(c)){
                capitalCaseLetterPresent = true;
            }
        }
        if(!(lowerCaseLetterPresent && capitalCaseLetterPresent)){
            throw new Exception(
                    String.format(
                            "Password should contain lower case and capital letters but it doesn't: %s",
                            password
                    )
            );
        }
    }

    private void validatePassContainsHashSymbol(String password) throws Exception {
        if(!password.contains(HASH_SYMBOL)){
            throw new Exception(
                    String.format(
                            "Password should contain '#' but it doesn't: %s",
                            password
                    )
            );
        }
    }

    private void validatePassContainsUnderscoreSymbol(String password) throws Exception {
        if(!password.contains(UNDERSCORE_SYMBOL)){
            throw new Exception(
                    String.format(
                            "Password should contain '_' but it doesn't: %s",
                            password
                    )
            );
        }
    }

    private void validateMaxLength(String password) throws Exception {
        if(password.length() > maxLength){
            throw new Exception(
                    String.format(
                            "Too long password: %s (%d symbols), max length: %d",
                            password,
                            password.length(),
                            maxLength
                    )
            );
        }
    }

    private void validateMinLength(String password) throws Exception {
        if(password.length() <= minLength){
            throw new Exception(
                    String.format(
                            "Too short password: %s (%d symbols), min length: %d",
                            password,
                            password.length(),
                            minLength
                    )
            );
        }
    }
}
