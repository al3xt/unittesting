package com.practicalunittesting.collections;

import com.practicalunittesting.mocks.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper around list
 * Created by otsukanov on 5/25/2015.
 */
public class UserList {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
