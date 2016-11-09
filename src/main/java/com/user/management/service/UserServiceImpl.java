package com.user.management.service;

import com.user.management.dao.UserManagementDAO;

import java.util.List;
import org.springframework.stereotype.Service;
import com.user.management.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManagementDAO userManagementDAO;

    @Override
    public List<User> findAllUsers() {
        return userManagementDAO.findAllUsers();
    }

    @Override
    public User findById(long id) {
        User u = userManagementDAO.findById(id);
        return u;
    }

    @Override
    public User findByName(String name) {
        User u = userManagementDAO.findByName(name);
        return u;
    }

    @Override
    public void saveUser(User user) {
        userManagementDAO.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userManagementDAO.updateUser(user);
    }

    @Override
    public void deleteUserById(long id) {

        userManagementDAO.deleteUserById(id);
    }

    @Override
    public boolean isUserExist(String firstname, String email) {
        return userManagementDAO.isUserExist(firstname, email);
    }

//    public void deleteAllUsers() {
//        users.clear();
//    }
//    private static List<User> populateDummyUsers() throws ParseException {
//        List<User> users = new ArrayList<User>();
//        Date date = new Date(2014 - 1900, Calendar.APRIL, 19);
//        users.add(new User(counter.incrementAndGet(), "Atanas", "Kyurkchiev", date, "atanas.kyurkchiev@abv.bg"));
//        return users;
//    }
}
