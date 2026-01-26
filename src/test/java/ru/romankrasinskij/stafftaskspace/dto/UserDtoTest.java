package ru.romankrasinskij.stafftaskspace.dto;

import static org.mockito.Mockito.spy;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@ExtendWith(MockitoExtension.class)
public class UserDtoTest {

    private UserDto spyUserDto = spy(new UserDto());
    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private Validator validator = validatorFactory.getValidator();
    private Set<ConstraintViolation<UserDto>> violations;

    @BeforeEach
    public void init() {
        spyUserDto.setFirstName("FIRST_NAME");
        spyUserDto.setPassword("PASSword123+");
        spyUserDto.setUsername("USERNAME");
        spyUserDto.setEmail("EMAIL@EMAIL.COM");
        spyUserDto.setLastName("LAST_NAME");
        spyUserDto.setDateOfBirth("01.01.2001");
        spyUserDto.setPhoneNumber("79001112233");
    }

    private void testValidation(String fieldName, String messageText) {
        violations = validator.validate(spyUserDto);

        assertThat(violations)
            .extracting(ConstraintViolation::getPropertyPath)
            .asString()
            .contains(fieldName);

        assertThat(violations)
            .anyMatch(v -> v.getMessage().equals(messageText));

    }

    @Test
    public void whenFirstNameHasOnlySpaces_thenNotBlankFails() {
        spyUserDto.setFirstName(" ");
        testValidation("firstName", "The name cannot be empty");
    }

    @Test
    public void whenFirstNameIsNull_thenNotBlankFails() {
        spyUserDto.setFirstName(null);
        testValidation("firstName", "The name cannot be empty");
    }

    @Test
    public void whenFirstNameIsTooShort_thenSizeFails() {
        spyUserDto.setFirstName("s");
        testValidation("firstName", "The length of the first name can be from 2 to 30 characters");
    }

    @Test
    public void whenFirstNameIsTooLong_thenSizeFails() {
        spyUserDto.setFirstName("FIRST_NAME_LONGER_THAN_30_CHARS");
        testValidation("firstName", "The length of the first name can be from 2 to 30 characters");
    }

    @Test
    public void whenLastNameHasOnlySpaces_thenNotBlankFails() {
        spyUserDto.setLastName(" ");
        testValidation("lastName", "The last name cannot be empty");
    }

    @Test
    public void whenLastNameIsNull_thenNotBlankFails() {
        spyUserDto.setLastName(null);
        testValidation("lastName", "The last name cannot be empty");
    }

    @Test
    public void whenLastNameIsTooShort_thenSizeFails() {
        spyUserDto.setLastName("s");
        testValidation("lastName", "The length of the last name can be from 2 to 30 characters");
    }

    @Test
    public void whenLastNameIsTooLong_thenSizeFails() {
        spyUserDto.setLastName("LAST_NAME_LONGER_THAN_30_CHARACTERS");
        testValidation("lastName", "The length of the last name can be from 2 to 30 characters");
    }

    @Test
    public void whenPatronymicIsTooShort_thenSizeFails() {
        spyUserDto.setPatronymic("s");
        testValidation("patronymic", "The length of the patronymic can be from 2 to 30 characters");
    }

    @Test
    public void whenPatronymicIsTooLong_thenSizeFails() {
        spyUserDto.setPatronymic("PATRONYMIC_LONGER_THAN_30_CHARACTERS");
        testValidation("patronymic", "The length of the patronymic can be from 2 to 30 characters");
    }

    @Test
    public void whenDateOfBirthHasOnlySpaces_thenNotBlankFails() {
        spyUserDto.setDateOfBirth(" ");
        testValidation("dateOfBirth", "The date of birth cannot be empty");
    }

    @Test
    public void whenDateOfBirthIsNull_thenNotBlankFails() {
        spyUserDto.setDateOfBirth(null);
        testValidation("dateOfBirth", "The date of birth cannot be empty");
    }

    @Test
    public void whenDateOfBirthIsTooShort_thenSizeFails() {
        spyUserDto.setDateOfBirth("s");
        testValidation("dateOfBirth", "The length of the date of birth can be 10 characters");
    }

    @Test
    public void whenDateOfBirthIsTooLong_thenSizeFails() {
        spyUserDto.setDateOfBirth("DATE_OF_BIRTH_LONGER_THAN_10_CHARACTERS");
        testValidation("dateOfBirth", "The length of the date of birth can be 10 characters");
    }

    @Test
    public void whenDateOfBirthIsInWrongFormat_thenPatternFails() {
        spyUserDto.setDateOfBirth("01/01/2001");
        testValidation("dateOfBirth", "The date of birth format should be as follows: 01.01.2001");
    }

    @Test
    public void whenUsernameHasOnlySpaces_thenNotBlankFails() {
        spyUserDto.setUsername(" ");
        testValidation("username", "The username cannot be empty");
    }

    @Test
    public void whenUsernameIsNull_thenNotBlankFails() {
        spyUserDto.setUsername(null);
        testValidation("username", "The username cannot be empty");
    }

    @Test
    public void whenUsernameIsTooShort_thenSizeFails() {
        spyUserDto.setUsername("s");
        testValidation("username", "The length of the username can be from 5 to 30 characters");
    }

    @Test
    public void whenUsernameIsTooLong_thenSizeFails() {
        spyUserDto.setUsername("USERNAME_LONGER_THAN_30_CHARACTERS");
        testValidation("username", "The length of the username can be from 5 to 30 characters");
    }

    @Test
    public void whenPasswordHasOnlySpaces_thenNotBlankFails() {
        spyUserDto.setPassword(" ");
        testValidation("password", "The password cannot be empty");
    }

    @Test
    public void whenPasswordIsNull_thenNotBlankFails() {
        spyUserDto.setPassword(null);
        testValidation("password", "The password cannot be empty");
    }

    @Test
    public void whenPasswordIsTooShort_thenSizeFails() {
        spyUserDto.setPassword("s");
        testValidation("password", "The length of the password can be from 8 to 30 characters");
    }

    @Test
    public void whenPasswordIsTooLong_thenSizeFails() {
        spyUserDto.setPassword("PASSWORD_LONGER_THAN_30_CHARACTERS");
        testValidation("password", "The length of the password can be from 8 to 30 characters");
    }

    @Test
    public void whenPasswordIsInWrongFormat_thenPatternFails() {
        spyUserDto.setPassword("INVALID_PASSWORD");
        testValidation("password", "The password must be between 8 and 20 characters long "
                                 + "and contain upper and lower case letters as well as special characters");
    }

    @Test
    public void whenEmailIsHasOnlySpaces_thenNotBlankFails() {
        spyUserDto.setEmail(" ");
        testValidation("email", "The email cannot be empty");
    }

    @Test
    public void whenEmailIsNull_thenNotBlankFails() {
        spyUserDto.setEmail(null);
        testValidation("email", "The email cannot be empty");
    }

    @Test
    public void whenEmailIsTooShort_thenSizeFails() {
        spyUserDto.setEmail("s");
        testValidation("email", "The length of the email can be from 5 to 30 characters");
    }

    @Test
    public void whenEmailIsTooLong_thenSizeFails() {
        spyUserDto.setEmail("THIS_EMAIL_LONGER_THAN_30_CHARACTERS");
        testValidation("email", "The length of the email can be from 5 to 30 characters");
    }

    @Test
    public void whenEmailIsInWrongFormat_thenEmailFails() {
        spyUserDto.setEmail("email@");
        testValidation("email", "The email format should be as follows: email@example.com");
    }

    @Test
    public void whenPhoneNumberHasOnlySpaces_thenNotBlankFails() {
        spyUserDto.setPhoneNumber(" ");
        testValidation("phoneNumber", "The phone number cannot be empty");
    }

    @Test
    public void whenPhoneNumberIsNull_thenNotBlankFails() {
        spyUserDto.setPhoneNumber(null);
        testValidation("phoneNumber", "The phone number cannot be empty");
    }

    @Test
    public void whenPhoneNumberIsTooShort_thenSizeFails() {
        spyUserDto.setPhoneNumber("s");
        testValidation("phoneNumber", "The length of the phone number can be 11 characters");
    }

    @Test
    public void whenPhoneNumberIsTooLong_thenSizeFails() {
        spyUserDto.setPhoneNumber("PHONE_NUMBER_LONGER_THAN_11_CHARACTERS");
        testValidation("phoneNumber", "The length of the phone number can be 11 characters");
    }

    @Test
    public void whenPhoneNumberIsInWrongFormat_thenPatternFails() {
        spyUserDto.setPhoneNumber("+79001112233");
        testValidation("phoneNumber", "The phone number format should be as follows: 79001112233");
    }
}
