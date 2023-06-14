package com.example.dao.user;

import com.example.dao.DbHelper;
import com.example.domain.user.User;

public class UserDaoImpl implements UserDao {


    public void create(User user) {
        final String query = "INSERT into users (username, password, first_name, last_name, register_date) VALUES ('" + user.getUsername() + "' , '" + user.getPassword() + "', '" + user.getFirstName() + "', '"+ user.getLastName() +"', " + System.currentTimeMillis() +")";
        DbHelper.runModifiyQuery(query);
    }

    public User read(Integer integer) {
        return null;
    }

    public void update(Integer integer, User user) {

    }

    public void delete(Integer integer) {

    }
}
