package domain;

import java.sql.Date;

public class UserService {

    private UserDAO userDataAccess;

    public UserService() {
        userDataAccess = new UserDAO();
    }

    public User getUser(String usertype, String userid, String password) {
        User user = null;
        try {
            user = userDataAccess.userRetrieve(usertype, userid, password);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public void userCreate(String usertype, String userid, String password, String username, String email, String tel, String address) {
        userDataAccess.userCreate(usertype, userid, password, username, email, tel, address);
    }
}