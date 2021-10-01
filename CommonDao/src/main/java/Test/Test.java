/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import common.dao.UserDAO;
import common.model.User;

/**
 *
 * @author dicar
 */
public class Test {

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User u = dao.emailValidation("dicarlomtz@gmail.com", "123456");
        System.out.print(u);
    }

}
