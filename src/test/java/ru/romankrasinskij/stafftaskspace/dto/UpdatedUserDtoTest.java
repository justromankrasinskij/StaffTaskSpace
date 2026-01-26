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
public class UpdatedUserDtoTest {

    private UpdatedUserDto spyUpdatedUserDto = spy(new UpdatedUserDto());
    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private Validator validator = validatorFactory.getValidator();
    private Set<ConstraintViolation<UpdatedUserDto>> violations;

    @BeforeEach
    public void init() {
        spyUpdatedUserDto.setFirstName("FIRST_NAME");
        spyUpdatedUserDto.setUsername("USERNAME");
        spyUpdatedUserDto.setEmail("EMAIL@EMAIL.COM");
        spyUpdatedUserDto.setLastName("LAST_NAME");
        spyUpdatedUserDto.setDateOfBirth("01.01.2001");
        spyUpdatedUserDto.setPhoneNumber("79001112233");
    }

    private void testValidation(String fieldName, String messageText) {
        violations = validator.validate(spyUpdatedUserDto);

        assertThat(violations)
            .extracting(ConstraintViolation::getPropertyPath)
            .asString()
            .contains(fieldName);

        assertThat(violations)
            .anyMatch(v -> v.getMessage().equals(messageText));

    }

    @Test
    public void whenFirstNameHasOnlySpaces_thenNotBlankFails() {
        spyUpdatedUserDto.setFirstName(" ");
        testValidation("firstName", "The name cannot be empty");
    }

    @Test
    public void whenFirstNameIsNull_thenNotBlankFails() {
        spyUpdatedUserDto.setFirstName(null);
        testValidation("firstName", "The name cannot be empty");
    }

    @Test
    public void whenFirstNameIsTooShort_thenSizeFails() {
        spyUpdatedUserDto.setFirstName("s");
        testValidation("firstName", "The length of the first name can be from 2 to 30 characters");
    }

    @Test
    public void whenFirstNameIsTooLong_thenSizeFails() {
        spyUpdatedUserDto.setFirstName("FIRST_NAME_LONGER_THAN_30_CHARS");
        testValidation("firstName", "The length of the first name can be from 2 to 30 characters");
    }

    @Test
    public void whenLastNameHasOnlySpaces_thenNotBlankFails() {
        spyUpdatedUserDto.setLastName(" ");
        testValidation("lastName", "The last name cannot be empty");
    }

    @Test
    public void whenLastNameIsNull_thenNotBlankFails() {
        spyUpdatedUserDto.setLastName(null);
        testValidation("lastName", "The last name cannot be empty");
    }

    @Test
    public void whenLastNameIsTooShort_thenSizeFails() {
        spyUpdatedUserDto.setLastName("s");
        testValidation("lastName", "The length of the last name can be from 2 to 30 characters");
    }

    @Test
    public void whenLastNameIsTooLong_thenSizeFails() {
        spyUpdatedUserDto.setLastName("LAST_NAME_LONGER_THAN_30_CHARACTERS");
        testValidation("lastName", "The length of the last name can be from 2 to 30 characters");
    }

    @Test
    public void whenPatronymicIsTooShort_thenSizeFails() {
        spyUpdatedUserDto.setPatronymic("s");
        testValidation("patronymic", "The length of the patronymic can be from 2 to 30 characters");
    }

    @Test
    public void whenPatronymicIsTooLong_thenSizeFails() {
        spyUpdatedUserDto.setPatronymic("PATRONYMIC_LONGER_THAN_30_CHARACTERS");
        testValidation("patronymic", "The length of the patronymic can be from 2 to 30 characters");
    }

    @Test
    public void whenDateOfBirthHasOnlySpaces_thenNotBlankFails() {
        spyUpdatedUserDto.setDateOfBirth(" ");
        testValidation("dateOfBirth", "The date of birth cannot be empty");
    }

    @Test
    public void whenDateOfBirthIsNull_thenNotBlankFails() {
        spyUpdatedUserDto.setDateOfBirth(null);
        testValidation("dateOfBirth", "The date of birth cannot be empty");
    }

    @Test
    public void whenDateOfBirthIsTooShort_thenSizeFails() {
        spyUpdatedUserDto.setDateOfBirth("s");
        testValidation("dateOfBirth", "The length of the date of birth can be 10 characters");
    }

    @Test
    public void whenDateOfBirthIsTooLong_thenSizeFails() {
        spyUpdatedUserDto.setDateOfBirth("DATE_OF_BIRTH_LONGER_THAN_10_CHARACTERS");
        testValidation("dateOfBirth", "The length of the date of birth can be 10 characters");
    }

    @Test
    public void whenDateOfBirthIsInWrongFormat_thenPatternFails() {
        spyUpdatedUserDto.setDateOfBirth("01/01/2001");
        testValidation("dateOfBirth", "The date of birth format should be as follows: 01.01.2001");
    }

    @Test
    public void whenUsernameHasOnlySpaces_thenNotBlankFails() {
        spyUpdatedUserDto.setUsername(" ");
        testValidation("username", "The username cannot be empty");
    }

    @Test
    public void whenUsernameIsNull_thenNotBlankFails() {
        spyUpdatedUserDto.setUsername(null);
        testValidation("username", "The username cannot be empty");
    }

    @Test
    public void whenUsernameIsTooShort_thenSizeFails() {
        spyUpdatedUserDto.setUsername("s");
        testValidation("username", "The length of the username can be from 5 to 30 characters");
    }

    @Test
    public void whenUsernameIsTooLong_thenSizeFails() {
        spyUpdatedUserDto.setUsername("USERNAME_LONGER_THAN_30_CHARACTERS");
        testValidation("username", "The length of the username can be from 5 to 30 characters");
    }

    @Test
    public void whenEmailIsHasOnlySpaces_thenNotBlankFails() {
        spyUpdatedUserDto.setEmail(" ");
        testValidation("email", "The email cannot be empty");
    }

    @Test
    public void whenEmailIsNull_thenNotBlankFails() {
        spyUpdatedUserDto.setEmail(null);
        testValidation("email", "The email cannot be empty");
    }

    @Test
    public void whenEmailIsTooShort_thenSizeFails() {
        spyUpdatedUserDto.setEmail("s");
        testValidation("email", "The length of the email can be from 5 to 30 characters");
    }

    @Test
    public void whenEmailIsTooLong_thenSizeFails() {
        spyUpdatedUserDto.setEmail("THIS_EMAIL_LONGER_THAN_30_CHARACTERS");
        testValidation("email", "The length of the email can be from 5 to 30 characters");
    }

    @Test
    public void whenEmailIsInWrongFormat_thenEmailFails() {
        spyUpdatedUserDto.setEmail("email@");
        testValidation("email", "The email format should be as follows: email@example.com");
    }

    @Test
    public void whenPhoneNumberHasOnlySpaces_thenNotBlankFails() {
        spyUpdatedUserDto.setPhoneNumber(" ");
        testValidation("phoneNumber", "The phone number cannot be empty");
    }

    @Test
    public void whenPhoneNumberIsNull_thenNotBlankFails() {
        spyUpdatedUserDto.setPhoneNumber(null);
        testValidation("phoneNumber", "The phone number cannot be empty");
    }

    @Test
    public void whenPhoneNumberIsTooShort_thenSizeFails() {
        spyUpdatedUserDto.setPhoneNumber("s");
        testValidation("phoneNumber", "The length of the phone number can be 11 characters");
    }

    @Test
    public void whenPhoneNumberIsTooLong_thenSizeFails() {
        spyUpdatedUserDto.setPhoneNumber("PHONE_NUMBER_LONGER_THAN_11_CHARACTERS");
        testValidation("phoneNumber", "The length of the phone number can be 11 characters");
    }

    @Test
    public void whenPhoneNumberIsInWrongFormat_thenPatternFails() {
        spyUpdatedUserDto.setPhoneNumber("+79001112233");
        testValidation("phoneNumber", "The phone number format should be as follows: 79001112233");
    }
}
