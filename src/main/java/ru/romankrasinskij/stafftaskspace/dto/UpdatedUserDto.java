package ru.romankrasinskij.stafftaskspace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdatedUserDto {

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2,
          max = 30,
          message = "The length of the first name can be from 2 to 30 characters")
    private String firstName;

    @NotBlank(message = "The last name cannot be empty")
    @Size(min = 2,
          max = 30,
          message = "The length of the last name can be from 2 to 30 characters")
    private String lastName;

    @Size(min = 2,
          max = 30,
          message = "The length of the patronymic can be from 2 to 30 characters")
    private String patronymic;

    @NotBlank(message = "The date of birth cannot be empty")
    @Size(min = 10,
          max = 10,
          message = "The length of the date of birth can be 10 characters")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[1,2])\\.(19|20)\\d{2}$",
             message = "The date of birth format should be as follows: 01.01.2001"
    )
    private String dateOfBirth;

    @NotBlank(message = "The username cannot be empty")
    @Size(min = 5,
          max = 30,
          message = "The length of the username can be from 5 to 30 characters")
    private String username;

    @NotBlank(message = "The email cannot be empty")
    @Size(min = 5,
          max = 30,
          message = "The length of the email can be from 5 to 30 characters")
    @Email(message = "The email format should be as follows: email@example.com")
    private String email;

    @NotBlank(message = "The phone number cannot be empty")
    @Size(min = 11,
          max = 11,
          message = "The length of the phone number can be 11 characters")
    @Pattern(regexp = "\\d{11}",
             message = "The phone number format should be as follows: 79001112233"
    )
    private String phoneNumber;
    private String telegramUsername;
    private String company;
    private String department;
    private String appointment;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelegramUsername() {
        return telegramUsername;
    }

    public void setTelegramUsername(String telegramUsername) {
        this.telegramUsername = telegramUsername;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "UserDto [lastName=" + lastName + ", firstName=" + firstName + ", patronymic=" + patronymic
                + ", dateOfBirth=" + dateOfBirth + ", username=" + username + ", email="
                + email + ", phoneNumber=" + phoneNumber + ", telegramUsername=" + telegramUsername + ", company="
                + company + ", department=" + department + ", appointment=" + appointment + "]";
    }
}
