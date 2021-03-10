package sauceDemo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.*;

public class sauceDemo {
    SelenideElement userNameField = $(By.name("user-name"));
    SelenideElement passwordField = $(By.name("password"));
    SelenideElement logginButton = $(By.id("login-button"));
    SelenideElement wrongCredentialsMessage = $("div#login_button_container>div>form>h3");
    SelenideElement siteMenu = $(By.id("react-burger-menu-btn"));
    SelenideElement logoutButton = $(By.id("logout_sidebar_link"));
    SelenideElement firstProduct = $x("(//div[@class='inventory_item_price']/following-sibling::button)[1]");
    SelenideElement secondProduct = $x("(//div[@class='inventory_item_price']/following-sibling::button)[2]");
    SelenideElement thirdProduct = $x("(//div[@class='inventory_item_price']/following-sibling::button)[3]");
    SelenideElement fourthProduct = $x("(//div[@class='inventory_item_price']/following-sibling::button)[4]");
    SelenideElement fifthProduct = $x("(//div[@class='inventory_item_price']/following-sibling::button)[5]");
    SelenideElement sixthProduct = $x("(//div[@class='inventory_item_price']/following-sibling::button)[6]");
    SelenideElement firstProductInCart = $x("(//button[text()='REMOVE'])[1]");
    SelenideElement secondProductInCart = $x("(//button[text()='REMOVE'])[2]");
    SelenideElement thirdProductInCart = $x("(//button[text()='REMOVE'])[3]");
    SelenideElement fourthProductInCart = $x("(//button[text()='REMOVE'])[4]");
    SelenideElement fifthProductInCart = $x("(//button[text()='REMOVE'])[5]");
    SelenideElement sixthProductInCart = $x("(//button[text()='REMOVE'])[6]");
    SelenideElement cart = $(By.id("shopping_cart_container"));
    SelenideElement continueShoppingButton = $x("//div[@class='cart_footer']//a[1]");
    SelenideElement checkoutButton = $x("//a[@class='btn_action checkout_button']");
    SelenideElement continueBuyingProcedureButton = $x("//input[@type='submit']");
    SelenideElement finishButton = $x("//a[@class='btn_action cart_button']");
    SelenideElement succsessBuyingMessage = $x("//h2[text()='THANK YOU FOR YOUR ORDER']");
    SelenideElement SecondSuccsessBuyingMessage = $x("//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']");

    SelenideElement elementBackpack = $x("//div[text()='Sauce Labs Backpack']");
    SelenideElement elementBoltTshirt = $x("//div[text()='Sauce Labs Bolt T-Shirt']");
    SelenideElement elementBike = $x("//div[text()='Sauce Labs Bike Light']");
    SelenideElement elementBoltJacket = $x("//div[text()='Sauce Labs Fleece Jacket']");
    SelenideElement elementRedTshirt = $x("//div[text()='Test.allTheThings() T-Shirt (Red)']");
    SelenideElement elementBoltOnesie = $x("//div[text()='Sauce Labs Onesie']");

    SelenideElement firstNameField = $x("//input[@data-test='firstName']");
    SelenideElement lastNameField = $x("//input[@data-test='lastName']");
    SelenideElement zipCodeField = $x("//input[@data-test='postalCode']");

    @Step("Fill login={login} and passwords field={passwd}")
    public sauceDemo fillLoginForm(String login, String passwd) {
        userNameField.shouldBe(visible).sendKeys(login);
        passwordField.shouldBe(visible).sendKeys(passwd);
        return this;
    }

    @Step
    public void pressLoginButton() {
        logginButton.click();
    }

    @Step
    public sauceDemo wrongCredentialsMessage() {
        wrongCredentialsMessage.shouldHave(text("Username and password do not match any user in this service"));
        return this;
    }

    @Step
    public sauceDemo successBuyingMessage() {
        succsessBuyingMessage.shouldHave(text("THANK YOU FOR YOUR ORDER"));
        SecondSuccsessBuyingMessage.shouldHave(text("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        return this;
    }

    @Step
    public sauceDemo userLockedMessage() {
        wrongCredentialsMessage.shouldHave(text("Sorry, this user has been locked out."));
        return this;
    }

    @Step
    public void logoutProcedure() {
        siteMenu.shouldBe(visible).click();
        logoutButton.shouldBe(visible).click();
    }

    @Step
    public void addAllProductToCart() {
        firstProduct.shouldBe(visible).click();
        secondProduct.shouldBe(visible).click();
        thirdProduct.shouldBe(visible).click();
        fourthProduct.shouldBe(visible).click();
        fifthProduct.shouldBe(visible).click();
        sixthProduct.shouldBe(visible).click();
    }

    @Step
    public void removeAllProductFromCart() {
        sixthProductInCart.shouldBe(visible).click();
        fifthProductInCart.shouldBe(visible).click();
        fourthProductInCart.shouldBe(visible).click();
        thirdProductInCart.shouldBe(visible).click();
        secondProductInCart.shouldBe(visible).click();
        firstProductInCart.shouldBe(visible).click();
    }

    @Step
    public void goToCart() {
        cart.shouldBe(visible).click();
    }

    @Step
    public void goToProductList() {
        continueShoppingButton.shouldBe(visible).click();
    }

    @Step
    public void checkIfItemsPresentInCart() {
        elementBackpack.shouldBe(visible);
        elementBoltTshirt.shouldBe(visible);
        elementBike.shouldBe(visible);
        elementBoltJacket.shouldBe(visible);
        elementRedTshirt.shouldBe(visible);
        elementBoltOnesie.shouldBe(visible);
    }

    @Step
    public void checkIfItemsNotPresentInCart() {
        elementBackpack.shouldNotBe(visible);
        elementBoltTshirt.shouldNotBe(visible);
        elementBike.shouldNotBe(visible);
        elementBoltJacket.shouldNotBe(visible);
        elementRedTshirt.shouldNotBe(visible);
        elementBoltOnesie.shouldNotBe(visible);
    }

    @Step
    public void goToBuyingForm() {
        checkoutButton.shouldBe(visible).click();
    }

    @Step("Fill First Name={firstName}, Last Name={lastName} and zip code={zipCode}")
    public void fillBuyingForm(String firstName, String lastName, String zipCode) {
        firstNameField.shouldBe(visible).sendKeys(firstName);
        lastNameField.shouldBe(visible).sendKeys(lastName);
        zipCodeField.shouldBe(visible).sendKeys(zipCode);
    }

    @Step
    public void ClickContinueButtonInBuyingForm() {
        continueBuyingProcedureButton.shouldBe(visible).click();
    }

    @Step
    public void clickFinishButton() {
        finishButton.shouldBe(visible).click();
    }
}
