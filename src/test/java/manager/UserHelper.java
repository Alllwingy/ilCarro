package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a[contains(@href, '/login')]");
    By btnRegistrationNavigatorMenu = By.xpath("//a[contains(@href, '/registration')]");

    By inputNameForm = By.xpath("//input[@id='name']");

    By inputLastNameForm = By.xpath("//input[@id='lastName']");

    By inputEmailForm = By.xpath("//input[@id='email']");

    By inputPasswordForm = By.xpath("//input[@id='password']");

    By btnYalla = By.xpath("//button[@type='submit']");

    By textSuccessLoginPopUp = By.xpath("//h2[@class='message']");
    By textSuccessRegistrationPopUp = By.xpath("//div[@class='dialog-container']//h1[@class='title']");

    String checkBoxRegistrationFormJS = "document.querySelector('#terms-of-use').click();";
    String buttonOkPopUpString = "document.querySelector(`[type='button']`).click();";
    By checkBoxRegistrationFormXPath = By.xpath("//*[@id='terms-of-use']");

    By buttonLogout = By.xpath("//a[contains(@href, 'logout')]"); //2

    By buttonOkPopUp = By.xpath("//button[@type='button']");

    By errorMessageWrongEmailRegistration = By.xpath("//input[@autocomplete='email']/..//div//div");
    By errorMessageEmptyEmailRegistration = By.xpath("//div[@class='error']/div");

    public void login(UserDTO userDTO) {

        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailForm, userDTO.getEmail());
        typeTextBase(inputPasswordForm, userDTO.getPassword());
        clickBase(btnYalla);
    }

    public void login(UserDTOWith userDTOWith) {

        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailForm, userDTOWith.getEmail());
        typeTextBase(inputPasswordForm, userDTOWith.getPassword());
        clickBase(btnYalla);
    }

    public void login(UserDTOLombok userDTOLombok) {

        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailForm, userDTOLombok.getEmail());
        typeTextBase(inputPasswordForm, userDTOLombok.getPassword());
        clickBase(btnYalla);
    }

    public void registration(UserDTOLombok userDTOLombok) {

        clickBase(btnRegistrationNavigatorMenu);
        typeTextBase(inputNameForm, userDTOLombok.getName());
        typeTextBase(inputLastNameForm, userDTOLombok.getLastName());
        typeTextBase(inputEmailForm, userDTOLombok.getEmail());
        typeTextBase(inputPasswordForm, userDTOLombok.getPassword());
        executeScript(checkBoxRegistrationFormJS);
//        clickByXY(checkBoxRegistrationFormXPath, 1,1 );
        clickBase(btnYalla);
    }

    public boolean validatePopUpMessageSuccessAfterLogin() {

        return isTextEqual(textSuccessLoginPopUp, "Logged in success");
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {

        return isTextEqual(textSuccessRegistrationPopUp, "REGISTERED");
    }

    public boolean validatePopUpMessageLoginIncorrect() {

        return isTextEqual(textSuccessLoginPopUp, "\"Login or Password incorrect\"");
    }

    public boolean validateMessageWrongEmail() {

        return isTextEqual(errorMessageWrongEmailRegistration, "Wrong email format");
    }
    public boolean validateMessageEmptyEmail() {

        return isTextEqual(errorMessageEmptyEmailRegistration, "Email is required");
    }
    public boolean validateMessageWrongPassword() {

        return isTextEqual(errorMessageEmptyEmailRegistration, "Password must contain minimum 8 symbols");
    }

    public void clickOkPopUpSuccessLogin() {

        if (isElementExists(buttonOkPopUp))
            executeScript(buttonOkPopUpString);
//        clickBase(buttonOkPopUp);
    }

    public void clickOkPopUpSuccess(String action) {

//        clickByXY(buttonOkPopUp, 1, 1);

        Actions actions = new Actions(driver);
        actions.sendKeys(action);
    }

    public void logoutIfLogin() {

        if (isElementExists(buttonLogout))
            clickBase(buttonLogout);
    }
}