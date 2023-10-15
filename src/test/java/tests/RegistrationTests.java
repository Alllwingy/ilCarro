package tests;

import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {

        apple.navigateToMainPage();
    }

    @AfterMethod
    public void afterMethod() {

        apple.getUserHelper().pause(1);
        apple.getUserHelper().logoutIfLogin();
    }

    @Test
    public void positiveRegistrationTestWithUserDTOLombok() {

        String email = randomUtils.generateEmail(7);

        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .name("Test")
                .lastName("Set")
                .email(email)
                .password("123456Aa$")
                .build();

        apple.getUserHelper().registration(userDTOLombok);
        Assert.assertTrue(apple.getUserHelper().validatePopUpMessageSuccessAfterRegistration());

        apple.getUserHelper().pause(1);

        apple.getUserHelper().clickOkPopUpSuccessLogin();
//        apple.getUserHelper().clickOkPopUpSuccess(String.valueOf(Keys.ENTER));
    }

    @Test
    public void negativeRegistrationTestWrongEmail() {

        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .name("Test")
                .lastName("Set")
                .email("yttb.hh")
                .password("123456Aa$")
                .build();

        apple.getUserHelper().registration(userDTOLombok);
        Assert.assertTrue(apple.getUserHelper().validateMessageWrongEmail());
    }

    @Test
    public void negativeRegistrationTestEmptyEmail() {

        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .name("Test")
                .lastName("Set")
                .email("")
                .password("123456Aa$")
                .build();

        apple.getUserHelper().registration(userDTOLombok);
        Assert.assertTrue(apple.getUserHelper().validateMessageEmptyEmail());
    }

    @Test
    public void negativeRegistrationTestWrong() {

        String email = randomUtils.generateEmail(7);

        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .name("Test")
                .lastName("Set")
                .email(email)
                .password("123456$")
                .build();

        apple.getUserHelper().registration(userDTOLombok);
        Assert.assertTrue(apple.getUserHelper().validateMessageWrongPassword());
    }
}
