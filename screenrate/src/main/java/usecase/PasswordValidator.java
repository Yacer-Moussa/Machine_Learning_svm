package usecase;

import android.content.Context;

import data.model.Benutzer;

public interface PasswordValidator {


    boolean validatePassword(String Password);
}
