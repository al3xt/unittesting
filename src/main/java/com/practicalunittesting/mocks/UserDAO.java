package com.practicalunittesting.mocks;

/**
 * User entity DAO
 * Created by Alexey on 02.05.2015.
 */
public interface UserDAO {

    /**
     * Updates user in database
     * @param user
     */
    public void updateUser(User user);
}
