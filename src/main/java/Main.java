

import be.model.Account;
import be.model.UserDetail;
import be.service.AccountService;
import be.service.UserDetailService;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        UserDetailService userDetailService = new UserDetailService();
        // Adding new accounts
        accountService.addAccount("mausam_tiwari", "mausam111");

        // Get an account
        Account account = accountService.getAccount("mausam_tiwari");
        System.out.println("Account details: " + account);

        // Get all accounts
        List<Account> accounts = accountService.getAccounts();
        System.out.println("All accounts:");
        for (Account acc : accounts) {
            System.out.println(acc);
        }

        // Deleting an account
        accountService.deleteAccount("vini_jr");


        // Adding new user details
        UserDetail userDetail1 = new UserDetail("Mausam", "Tiwari", "mausam@intec.com", account);
        userDetailService.addUserDetail(userDetail1);


        // Getting user details
        UserDetail userDetail = userDetailService.getUserDetail("john@intec.com");
        System.out.println("Retrieved user detail: " + userDetail);

        // Getting all user details
        List<UserDetail> userDetailsList = userDetailService.getAllUserDetails();
        System.out.println("All user details:");
        for (UserDetail ud : userDetailsList) {
            System.out.println(ud);
        }

        // Updating user detail
        userDetail.setFirstName("Johnny");
        userDetailService.updateUserDetail(userDetail);

        // Deleting user detail
        userDetailService.deleteUserDetail("toni@intec.com");
    }
}
