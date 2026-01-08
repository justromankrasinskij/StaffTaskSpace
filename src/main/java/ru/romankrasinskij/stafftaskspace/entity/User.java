package ru.romankrasinskij.stafftaskspace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final String dateOfBirth;
    private final String username;
    private final String passwordHash;
    private final String email;
    private final String phoneNumber;
    private final String telegramUsername;
    private final String company;
    private final String department;
    private final String appointment;

    private User(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.patronymic = builder.patronymic;
        this.dateOfBirth = builder.dateOfBirth;
        this.username = builder.username;
        this.passwordHash = builder.passwordHash;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.telegramUsername = builder.telegramUsername;
        this.company = builder.company;
        this.department = builder.department;
        this.appointment = builder.appointment;
    }

    public User() {
        this(new Builder());
    }

    public static class Builder {

        private String lastName;
        private String firstName;
        private String patronymic;
        private String dateOfBirth;
        private String username;
        private String passwordHash;
        private String email;
        private String phoneNumber;
        private String telegramUsername;
        private String company;
        private String department;
        private String appointment;

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder passwordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder telegramUsername(String telegramUsername) {
            this.telegramUsername = telegramUsername;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder appointment(String appointment) {
            this.appointment = appointment;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public long getId() {
        return id;
    }

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

    public String getPasswordHash() {
        return passwordHash;
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

    public void setId(long id) {
        this.id = id;
    }
}
