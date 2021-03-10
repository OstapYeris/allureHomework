package saucedemoTests;

import base.SelenideBase;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import sauceDemo.sauceDemo;

public class sauceDemoTests extends SelenideBase {

    @Test
    @Description("Chec login with invalid credentials")
    @Severity(SeverityLevel.MINOR)
    public void testInvalidCredentialsLogin () {
        open("");
        new sauceDemo().fillLoginForm("wrong_login", "wrong_password").pressLoginButton();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/");
        new sauceDemo().wrongCredentialsMessage();
    }

    @Test
    @Description("Chec locked customer login procedure")
    @Severity(SeverityLevel.BLOCKER)
    public void testLockedCustomerLogin () {
        open("");
        new sauceDemo().fillLoginForm("locked_out_user", "secret_sauce").pressLoginButton();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/");
        new sauceDemo().userLockedMessage();
    }

    @Test
    @Description("Chec performance customer login procedure")
    @Severity(SeverityLevel.BLOCKER)
    public void testPerformanceCustomerLogin () {
        open("");
        new sauceDemo().fillLoginForm("performance_glitch_user", "secret_sauce").pressLoginButton();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/inventory.html");
        new sauceDemo().logoutProcedure();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/");
    }

    @Test
    @Description("Chec problem customer login procedure")
    @Severity(SeverityLevel.BLOCKER)
    public void testProblemCustomerLogin () {
        open("");
        new sauceDemo().fillLoginForm("problem_user", "secret_sauce").pressLoginButton();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/inventory.html");
        new sauceDemo().logoutProcedure();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/");
    }

    @Test
    @Description("Chec standard customer login procedure")
    @Severity(SeverityLevel.BLOCKER)
    public void testStandardCustomerLogin () {
        open("");
        new sauceDemo().fillLoginForm("standard_user", "secret_sauce").pressLoginButton();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    @Description("Chec adding to cart and remove from cart")
    @Severity(SeverityLevel.BLOCKER)
    public void testAddingAndRemoveFromCart () {
        open("");
        new sauceDemo().fillLoginForm("standard_user", "secret_sauce").pressLoginButton();
        new sauceDemo().addAllProductToCart();
        new sauceDemo().goToCart();
        new sauceDemo().checkIfItemsPresentInCart();
        new sauceDemo().removeAllProductFromCart();
        new sauceDemo().checkIfItemsNotPresentInCart();
    }
//
//    @Test
//    @Description("Check remove items from cart")
//    @Severity(SeverityLevel.BLOCKER)
//    public void testRemoveProductsFromCart () {
//        open("");
//        new sauceDemo().fillLoginForm("standard_user", "secret_sauce").pressLoginButton();
//        new sauceDemo().goToCart();
//        new sauceDemo().removeAllProductFromCart();
//        new sauceDemo().checkIfItemsNotPresentInCart();
//    }

    @Test
    @Description("Check redirect to cart and back")
    @Severity(SeverityLevel.BLOCKER)
    public void testRedirect () {
        open("");
        new sauceDemo().fillLoginForm("standard_user", "secret_sauce").pressLoginButton();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/inventory.html");
        new sauceDemo().goToCart();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/cart.html");
        new sauceDemo().goToProductList();
        Assert.assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    @Description("Check direct to cart and back")
    @Severity(SeverityLevel.BLOCKER)
    public void testBuyingProcedure () {
        open("");
        new sauceDemo().fillLoginForm("standard_user", "secret_sauce").pressLoginButton();
        new sauceDemo().addAllProductToCart();
        new sauceDemo().goToCart();
        new sauceDemo().goToBuyingForm();
        new sauceDemo().fillBuyingForm("Ostap", "Homework", "37030" );
        new sauceDemo().ClickContinueButtonInBuyingForm();
        new sauceDemo().clickFinishButton();
        new sauceDemo().successBuyingMessage();
    }
}
