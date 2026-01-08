package ru.romankrasinskij.stafftaskspace.dto;

public class UpdatedUserDto {

    private String lastName;
    private String firstName;
    private String patronymic;
    private String dateOfBirth;
    private String username;
    private String email;
    private String phoneNumber;
    private String telegramUsername;
    private String company;
    private String department;
    private String appointment;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTelegramUsername() {
        return telegramUsername;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public String getAppointment() {
        return appointment;
    }
}
