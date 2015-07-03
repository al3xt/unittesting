package com.practicalunittesting.collections;

import com.practicalunittesting.mocks.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

/**
 * Tests for UserList
 * Created by otsukanov on 5/25/2015.
 */
public class UserListTest {

    private UserList userList = new UserList();

    @Test
    public void shouldReturnEmptyListIfNoneAdded()
    {
        assertThat(userList.getUsers(), empty());
        assertThat(userList.getUsers(), hasSize(0));
    }

    @Test
    public void shouldReturnOneUserListIfOneAdded()
    {
        User user = mock(User.class);
        userList.addUser(user);
        List<User> users = userList.getUsers();
        assertThat(users, notNullValue());
        assertThat(users, hasSize(1));
        assertThat(users, contains(user));
    }

    @Test
    public void shouldReturnTwoUsersListIfTwoAdded()
    {
        User firstUser = mock(User.class);
        User secondUser = mock(User.class);
        userList.addUser(firstUser);
        userList.addUser(secondUser);
        List<User> users = userList.getUsers();
        assertThat(users, notNullValue());
        assertThat(users, hasSize(2));
        assertThat(users, containsInAnyOrder(firstUser, secondUser));
    }

}
