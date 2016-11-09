/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.management.dao;

import com.user.management.model.User;
import java.util.List;

/**
 *
 * @author Atanas Kyurkchiev
 */
public interface UserManagementDAO {

    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

//    void deleteAllUsers();

    public boolean isUserExist(String firstName, String email);

}
