package com.user.management.dao;

import com.user.management.model.User;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Transactional
@Repository

/**
 *
 * @author Atanas Kyurkchiev
 */
public class UserManagementDAOImpl implements UserManagementDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    @Override
    public List<User> findAllUsers() {
        String hql = "FROM User as u ORDER BY u.id";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    public User findById(long id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public User findByName(String name) {
        return hibernateTemplate.get(User.class, name);
    }

    @Override
    public void saveUser(User user) {
        hibernateTemplate.save(user);
//        user.setId(counter.incrementAndGet());
//        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        User u = findById(user.getId());
        u.setFirstname(user.getFirstname());
        u.setLastname(user.getLastname());
        u.setDob(user.getDob());
        u.setEmail(user.getEmail());
        hibernateTemplate.update(u);
    }

    @Override
    public void deleteUserById(long id) {

        hibernateTemplate.delete(findById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean isUserExist(String firstName, String email) {
        String hql = "FROM User as u WHERE u.firstname = ? and u.email = ?";
        List<User> usersExistList = (List<User>) hibernateTemplate.find(hql, firstName, email);
        return usersExistList.size() > 0 ? true : false;
    }

}
