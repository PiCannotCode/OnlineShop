/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author SANG
 */
public class RegexUtils {

    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final String PASSWORD_REGEX
            = "((?=.*\\d)(?=.*[a-z]).{6,20})";

    private static Pattern pattern;
    private static Matcher matcher;

    //CHECK VALIDATE MAIL
    public static boolean checkEmail(String email) {
        email = email.trim();
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches(); // return boolen the input is matched with regex or not
    }

    public static boolean checkPass(String password) {
        password = password.trim();
        pattern = Pattern.compile(PASSWORD_REGEX);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // CHECK VALIDATE PASSWORD CONFIRM
    public static boolean checkPassValidate(String password, String passconfirm) {
        if (checkPass(password)) {
            return password.equals(passconfirm);
        }
        return false;
    }
}
