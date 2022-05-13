import org.testng.Assert;
import org.testng.annotations.Test;

public class AccumulatePageTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    AccumulatePointPage accumulatePointPage;
    DataPageClass dataPageClass;
    RechargePage rechargePage;
    AllPartnerPage allPartnerPage;
    OnlinePaymentPage onlinePaymentPage;
    PartnerPage partnerPage;
        @Test
            public void RechargePhoneCredit() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                AccumulatePointPage accumulatePointPage = new AccumulatePointPage(driver);
                RechargePage rechargePage = new RechargePage(driver);
                OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.AccumulateClick(); //Step 4
                Thread.sleep(3000);
                accumulatePointPage.RechargePhoneClick(); //Step 5
                rechargePage.clickRecharge(); //Step 6
                rechargePage.selectDenomination(); //Step 7
                rechargePage.clickBuy(); //Step 8
                rechargePage.clickATM(); //Step 9
                onlinePaymentPage.isOnlinePaymentDisplayed(); //Step 10
                driver.closeApp(); //Step 11
            }
        @Test
            public void BuyData() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                AccumulatePointPage accumulatePointPage = new AccumulatePointPage(driver);
                DataPageClass dataPageClass = new DataPageClass(driver);
                OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.AccumulateClick(); //Step 4
                Thread.sleep(3000);
                accumulatePointPage.DataClick(); //Step 5
                dataPageClass.ChooseDataPack(); //Step 6
                dataPageClass.clickBuyData(); //Step 7
                onlinePaymentPage.isOnlinePaymentDisplayed(); //Step 8
                driver.closeApp(); //Step 9
        }
        @Test
            public void Partner() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                AccumulatePointPage accumulatePointPage = new AccumulatePointPage(driver);
                DataPageClass dataPageClass = new DataPageClass(driver);
                AllPartnerPage allPartnerPage = new AllPartnerPage(driver);
                PartnerPage partnerPage = new PartnerPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.AccumulateClick(); //Step 4
                Thread.sleep(3000);
                accumulatePointPage.SeeAllPartnerClick(); //Step 5
                allPartnerPage.swipeTimeCustom(10); //Step 6
                String percentage = allPartnerPage.GetPercentage();
                allPartnerPage.ChoosePartnerClick(); //Step 7
                String Partnerpercentage = partnerPage.getPartnerPercent();
                Assert.assertEquals(Partnerpercentage,percentage); //Step 8
                partnerPage.PartnerWebsite(); //Step 9
                String asserts =partnerPage.PartnerWebsiteForAssert();
                Assert.assertEquals(asserts,"Mua hàng"); //Step 10
                driver.closeApp(); //Step 11
        }
}
