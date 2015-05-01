package com.practicalunittesting;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test for passworf validator
 * Created by otsukanov on 20.02.2015.
 */
public class PasswordValidatorTest {

    public static final int PASS_MIN_LENGTH = 10;

    public static final int PASS_MAX_LENGTH = 15;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PasswordValidator validator;

    @Before
    public void setUp(){
        validator = new PasswordValidator(PASS_MIN_LENGTH, PASS_MAX_LENGTH);
    }

    @Test(expected = NullPointerException.class)
    public void testValidateNullPassword() throws Exception {
        validator.validate(null);
    }

    @Test
    public void validateTooShortPassword() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Too short password: ShortPass (9 symbols), min length: 10");
        validator.validate("ShortPass");
    }

    @Test
    public void validateTooLongPassword() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Too long password: VeryLongPassword (16 symbols), max length: 15");
        validator.validate("VeryLongPassword");
    }

    @Test
    public void passwordShouldContainUnderscore() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Password should contain '_' but it doesn't: NewPassword");
        validator.validate("NewPassword");
    }

    @Test
    public void passwordShouldContainHash() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Password should contain '#' but it doesn't: New_Password");
        validator.validate("New_Password");
    }

    @Test
    public void shouldThrowExceptionIfPassContainsOnlyCapitalLetters() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Password should contain lower case and capital letters but it doesn't: NEW_#PASSWORD");
        validator.validate("NEW_#PASSWORD");
    }

    @Test
    public void shouldThrowExceptionIfPassContainsOnlyLowerLetters() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Password should contain lower case and capital letters but it doesn't: new_#password");
        validator.validate("new_#password");
    }

    @Test
    public void shouldThrowExceptionIfPassDoesNotContainLetters() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Password should contain lower case and capital letters but it doesn't: ______#######");
        validator.validate("______#######");
    }

    @Test
    public void testValidateCorrectPassword() throws Exception {
        validator.validate("New_#password");
    }
}
