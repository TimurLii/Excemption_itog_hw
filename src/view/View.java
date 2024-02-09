package src.view;

import src.FileWriter.CreateFile;
import src.Validator.Validate;
import src.User.User;

import java.util.Scanner;


public class View {
    Validate validator = new Validate();
    CreateFile createFile = new CreateFile();

    public View() {
    }

    public void run() {
        boolean workProgram = true;
        System.err.println("Start program.");
        while (workProgram) {
            String operation = scan("1.Create user.\n2.End program.\n");
            if (operation.equals("1")) {
                String userData = scan("Enter data: Last name, First name, Middle name, " +
                        "Date of birth (separated by point) , Phone number, gender (separated by space) : \n ");
                User user = createUser(userData);
                if (validUser(user)) {
                    createFile(user);
                    System.err.println("User created.");
                }
            } else {
                System.err.println("End program.");
                workProgram = false;
            }
        }
    }

    public User createUser(String userData) {
        String[] split = userData.split(" ");
        try{
            return new User(split[0], split[1], split[2], split[3], split[4], split[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("Insufficient data.");
        }

    }

    public boolean validUser(User user) {
        return validator.validUser(user);
    }

    public void createFile(User user) {
        createFile.createFile(user);

    }

    private String scan(String message) {
        Scanner in = new Scanner(System.in);
        System.err.printf(message);
        return in.nextLine();
    }
}
