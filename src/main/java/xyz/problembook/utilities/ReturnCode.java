package xyz.problembook.utilities;

public final class ReturnCode {
    public static int noErrors = 0;

    public static int userNameExists = 11;
    public static int studentRegistrationNumberExists = 12;
    public static int studentLoginIncorrectCredentials = 13;
    public static int studentLoginNoEntry = 14;

    public static int teacherNameExists = 21;
    public static int teacherLoginIncorrectCredentials = 23;
    public static int teacherLoginNoEntry = 24;

    public static boolean isNoErrors(int value) {
        return noErrors == value;
    }

    public static boolean isStudentNameExists(int value) {
        return userNameExists == value;
    }


}
