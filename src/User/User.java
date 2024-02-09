package src.User;

public class User {
    String surname;
    String name;
    String middleName;
    String birthDay;
    String phoneNumber;
    String gender;


    public User(String surname, String name, String MiddleName, String birthDay, String phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.middleName = MiddleName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurName() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>", surname, name, middleName, birthDay, phoneNumber, gender);
    }
}
