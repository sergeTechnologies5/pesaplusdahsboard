package com.lanstar.pesaplusdashboard.utils;

import com.lanstar.pesaplusdashboard.payload.User;

public class Utils {
    // Logged in loggedInUser
    private static User loggedInUser;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Utils.loggedInUser = loggedInUser;
    }
}
