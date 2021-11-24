package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.UserAccountPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserAccountTest extends Base {
    UserAccountPage userAccountPage;

    @Test(priority = 4,enabled = true,description = "Verification of User Page Title")
    public void verifyUserPage() throws IOException {}
}
