package com.practicalunittesting.mocks;

/**
 * Service for password encryption
 * Created by Alexey on 02.05.2015.
 */
public interface SecurityService {

    /**
     * Encrypts given password using md5 algorithm
     * @param password
     * @return encrypted password
     */
    public String md5(String password);
}
