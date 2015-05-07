package com.practicalunittesting.mocks;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
}
