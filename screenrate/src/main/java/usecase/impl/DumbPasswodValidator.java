package usecase.impl;


import usecase.PasswordValidator;

public class DumbPasswodValidator implements PasswordValidator {

    @Override
    public boolean validatePassword(String Password) {
        return true;
    }
}
