package com.practicalunittesting.mocks;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Test for UserServiceImpl
 * Created by Alexey on 02.05.2015.
 */
public class UserServiceImplTest {

    public static final String TEST_PASSWORD = "MagicWord";

    public static final String ENCRYPTED_PASSWORD = "MagicWordMd5";

    private UserDAO userDAO = mock(UserDAO.class);
    
    private SecurityService securityService = mock(SecurityService.class);

    private User user = mock(User.class);

    @Test
    public void testAssignNewPasswordToUser() throws Exception {
        when(user.getPassword()).thenReturn(TEST_PASSWORD);
        when(securityService.md5(TEST_PASSWORD)).thenReturn(ENCRYPTED_PASSWORD);
        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);
        userService.assignPassword(user);
        verify(user).setPassword(ENCRYPTED_PASSWORD);
        verify(securityService).md5(TEST_PASSWORD);
        verify(userDAO).updateUser(user);
    }

    @Test(expected = NullPointerException.class)
    public void testAssignNewPasswordToUserWithoutOldPassword() throws Exception {
        when(user.getPassword()).thenReturn(null);
        when(securityService.md5(null)).thenThrow(new NullPointerException());
        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);
        userService.assignPassword(user);
    }

    @Test(expected = IllegalStateException.class)
    public void testAssignNewPasswordToUserWhenDAOThrowsException() throws Exception {
        when(user.getPassword()).thenReturn(TEST_PASSWORD);
        when(securityService.md5(TEST_PASSWORD)).thenReturn(ENCRYPTED_PASSWORD);
        doThrow(new IllegalStateException()).when(userDAO).updateUser(user);
        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);
        userService.assignPassword(user);
    }

}
