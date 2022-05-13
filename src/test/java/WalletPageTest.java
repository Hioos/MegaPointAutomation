import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WalletPageTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    WalletPage walletPage;
    AddCardPage addCardPage;
        @Test(dataProvider = "dp")
            public void AddCard(String code,String result) throws InterruptedException {
            driver.launchApp(); //Step 1
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            WalletPage walletPage = new WalletPage(driver);
            AddCardPage addCardPage = new AddCardPage(driver);
            Thread.sleep(10000);
            homePage.MyAccountClick(); //Step 2
            loginPage.LoginTrue(); //Step 3
            homePage.WalletClick(); //Step 4
            walletPage.ClickAddCard(); //Step 5
            addCardPage.SendKeysCardTextbox(code); //Step 6
            addCardPage.clickNext(); //Step 7
            String NotificationText = addCardPage.getNotification();
            Assert.assertEquals(NotificationText,result);
        }
        @DataProvider
            public Object[][] dp(){
                return new Object[][]{
                        new Object[]{addCardPage.randomTextbox(),"Mã thẻ không chính xác. Quý khách vui lòng kiểm tra lại"},
                        new Object[]{"","Vui lòng nhập mã thẻ"}
                };
        }
}
