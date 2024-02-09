package src.Validator;

import src.User.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public boolean validUser(User user) {
        return validSureName(user.getSurName()) && validName(user.getName()) && validMiddleName(user.getMiddleName()) &&
                validBirthDay(user.getBirthDay()) && validPhoneNumber(user.getPhoneNumber()) && validGender(user.getGender());
    }

    public boolean validSureName(String str) {
        if (!str.isEmpty() && str.length() <= 20) {
            Pattern pattern = Pattern.compile("^[а-яА-я]+$");
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                return true;
            } else
                throw new IllegalArgumentException("Invalid surename.");
        }
        throw new IllegalArgumentException("Incorrect sure name  length.");

    }

    public boolean validName(String str) {
        if (!str.isEmpty() && str.length() <= 20) {
            Pattern pattern = Pattern.compile("^[а-яА-я]+$");
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                return true;
            } else
                throw new IllegalArgumentException("Invalid name.");
        }
        throw new IllegalArgumentException("Incorrect name length.");

    }

    public boolean validMiddleName(String str) {
        if (!str.isEmpty() && str.length() <= 20) {
            Pattern pattern = Pattern.compile("^[а-яА-я]+$");
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                return true;
            } else
                throw new IllegalArgumentException("Invalid middle name.");
        }
        throw new IllegalArgumentException("Incorrect middle name length.");

    }

    public boolean validBirthDay(String str) {
        if (str.length() == 10) {
            if (validDate(str)) {
                return true;
            }
        }
        throw new IllegalArgumentException("Invalid date.");
    }

    public boolean validDate(String str) {
        String[] birthDay = str.split("\\.");
        try {
            return (Integer.parseInt(birthDay[0]) > 0 && Integer.parseInt(birthDay[0]) <= 31) &&
                    (Integer.parseInt(birthDay[1]) > 0 && Integer.parseInt(birthDay[1]) <= 12) &&
                    (Integer.parseInt(birthDay[2]) > 0 && Integer.parseInt(birthDay[2]) != 0);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid date");
        }
    }

    public boolean validPhoneNumber(String str) {
        if (str.length() != 6) throw new IllegalArgumentException("Incorrect number length.");
        try {
            Integer number = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException | ClassCastException e) {
            throw new NumberFormatException("Invalid phone number");
        }
    }

    public boolean validGender(String str) {
        if (str.equals("f") || str.equals("m")) {
            return true;
        }
        throw new IllegalArgumentException("Invalid gender");
    }
}
