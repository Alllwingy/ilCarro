package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void positiveLoginUserDTO() {

        UserDTO userDTO = new UserDTO("testqa20@gmail.com", "123456Aa$");

        apple.getUserHelper().login(userDTO);
        Assert.assertTrue(apple.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserDTOWith() {

        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("testqa20@gmail.com")
                .withPassword("123456Aa$");

        apple.getUserHelper().login(userDTOWith);
        Assert.assertTrue(apple.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }
}
