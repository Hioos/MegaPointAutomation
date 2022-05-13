import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends  TestBase{
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
        @Test(testName = "loginPage",dataProvider = "login")
            public void LoginPage(String number,String password,Integer result) throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                MyAccountPage myAccountPage = new MyAccountPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.SendKeysNumberTextbox(number); //Step 3
                            String d = loginPage.getNumber(); //Step 4
                loginPage.NextButtonClick(); //Step 5
            if(result == 2 || result ==3) {
                if (result == 2) {
                    Assert.assertEquals(loginPage.getTextNotification(), "Vui lòng nhập số điện thoại hợp lệ !"); //Step 6.1
                    driver.closeApp(); //Step 6.2
                } else if (result == 3) {
                    Thread.sleep(5000);
                    String expectedNumber = "Nhập OTP Đã Gửi Tới " + d;
                    String actualNumber = loginPage.getNewNumberIns();
                    System.out.println(expectedNumber);
                    System.out.println(actualNumber);
                    Assert.assertEquals(actualNumber, expectedNumber); //Step 7.1
                    driver.closeApp(); //Step 7.2
                }
            }
            else {
                if (result == 1) {
                    loginPage.SendKeysPassWordTextbox(password); //Step 8
                    loginPage.LogInButtonClick(); //Step 9
                    Assert.assertEquals(loginPage.getTextNotification(), "Thông tin đăng nhập không đúng, vui lòng kiểm tra lại số điện thoại và mật khẩu!"); //Step 9.1
                    driver.closeApp(); //Step 10.1
                } else if (result == 0) {
                    homePage.MyAccountClick(); //Step 11.1
                    String userNumber = myAccountPage.getUserNumber();
                    Assert.assertEquals(userNumber, d); //Step 11.2
                    driver.closeApp(); //Step 11.3
                }
            }
        }
        @DataProvider
            public Object[][] login(){
                return new Object[][]{
                        new Object[]{"0393704472","1234",1},
                        new Object[]{"039370447222","",2},
                        new Object[]{"xyzsynchro","",2},
                        new Object[]{"0947583082","",3}
                };
    }
}
