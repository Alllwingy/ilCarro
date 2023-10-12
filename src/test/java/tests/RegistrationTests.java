package tests;

import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test
    public void positiveRegistrationTestWithUserDTOLombok() {

        String email = randomUtils.generateEmail(7);

        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .name("Test")
                .lastName("Set")
                .email(email)
                .password("123456Aa$")
                .build();

        apple.getUserHelper().register(userDTOLombok);
        Assert.assertTrue(apple.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }
}
