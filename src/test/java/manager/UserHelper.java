package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

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
    By checkBoxRegistrationFormXPath = By.xpath("//*[@id='terms-of-use']");

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

    public boolean validatePopUpMessageSuccessAfterLogin() {

        return isTextEqual(textSuccessLoginPopUp, "Logged in success");
    }

    public void register(UserDTOLombok userDTOLombok) {

        clickBase(btnRegistrationNavigatorMenu);
        typeTextBase(inputNameForm, userDTOLombok.getName());
        typeTextBase(inputLastNameForm, userDTOLombok.getLastName());
        typeTextBase(inputEmailForm, userDTOLombok.getEmail());
        typeTextBase(inputPasswordForm, userDTOLombok.getPassword());
//        jsClickBase(checkBoxRegistrationForm);
        clickByXY(checkBoxRegistrationFormXPath, 1,1 );
        clickBase(btnYalla);
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {

        return isTextEqual(textSuccessRegistrationPopUp, "REGISTERED");
    }
}