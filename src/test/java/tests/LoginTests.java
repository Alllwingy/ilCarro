package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void positiveLoginTestWithUserDTOTest() {

        UserDTO userDTO = new UserDTO("testqa20@gmail.com", "123456Aa$");

        apple.getUserHelper().login(userDTO);
        Assert.assertTrue(apple.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginTestWithUserDTOWith() {

        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("testqa20@gmail.com")
                .withPassword("123456Aa$");

        apple.getUserHelper().login(userDTOWith);
        Assert.assertTrue(apple.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginTestWithUserDTOLombok() {

        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aa$")
                .build();

        apple.getUserHelper().login(userDTOLombok);
        Assert.assertTrue(apple.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }
}
