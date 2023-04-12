package com.example.MyCRUDBootApp.dao;


import com.example.MyCRUDBootApp.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    public List<User> index() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(long id, User updateUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setSurname(updateUser.getSurname());
        userToBeUpdated.setAge(updateUser.getAge());

    }

    public void delete(long id) {
        entityManager.remove(show(id));
    }
}
