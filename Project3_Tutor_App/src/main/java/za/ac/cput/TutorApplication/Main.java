package za.ac.cput.TutorApplication;

import za.ac.cput.database.Database;
import za.ac.cput.database.StaffDatabase;
import za.ac.cput.guis.LoginA;

public class Main {
    public static void main(String[] args) {
        new Database();
        new StaffDatabase();
        new LoginA().setVisible(true);
    }
}