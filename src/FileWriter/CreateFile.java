package src.FileWriter;

import src.User.User;

import java.io.*;


public class CreateFile {


    public void createFile(User user) {
        String fileName = user.getSurName();
        boolean haveFile = searchFile(fileName);
        if (haveFile) {
            try (FileWriter writer = new FileWriter(String.format("D:\\GeekBrains\\0.HW\\Excemption_itog_hw\\src\\People\\%s.txt", fileName), true)) {
                writer.write(user + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (FileWriter writer = new FileWriter(String.format("D:\\GeekBrains\\0.HW\\Excemption_itog_hw\\src\\People\\%s.txt", fileName))) {
                writer.write(user + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean searchFile(String name) {
        File file = new File(String.format("D:\\GeekBrains\\0.HW\\Excemption_itog_hw\\src\\People\\%s.txt", name));
        if (file.exists()) {
            System.out.println("A user with the same last name was found");
            return true;
        } else {
            System.out.println("A user with this last name was not found. A new file will be created");
            return false;
        }
    }
}
