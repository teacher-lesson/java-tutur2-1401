package com.example;

import com.example.dao.user.UserDao;
import com.example.dao.user.UserDaoImpl;
import com.example.service.user.UserService;
import com.example.service.user.UserServiceImpl;
import com.example.view.login.LoginForm;

import javax.swing.*;

import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static javax.swing.UIManager.*;

public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDao);


        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            getLogger(LoginForm.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm(userService).setVisible(true);
            }
        });
    }
}
