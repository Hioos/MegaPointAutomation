import org.testng.annotations.Test;

public class AuthenticationTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    WalletPage walletPage;
    GiftPage giftPage;
    ExchangePage exchangePage;
    AllPartnerPage allPartnerPage;
    PermissionPage permissionPage;
    ProductPage productPage;
    ShopPage shopPage;
    CartPage cartPage;
    VoucherPage voucherPage;
    AllVoucherPage allVoucherPage;
        @Test
            public void MyAccount() throws InterruptedException {
                driver.launchApp();//Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.isLoginDisplayed(); //Step 3
                driver.closeApp(); //Step 4
        }
        @Test
            public void AddUse() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                Thread.sleep(10000);
                homePage.AddUseClick(); //Step 2
                loginPage.isLoginDisplayed();//Step 3
                driver.closeApp(); //Step 4
        }
        @Test
            public void ChargePoint() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                PermissionPage permissionPage = new PermissionPage(driver);
                Thread.sleep(10000);
                homePage.ChargePointClick(); //Step 2
                permissionPage.OneTime(); //Step 3
                loginPage.isLoginDisplayed();//Step 4
                driver.closeApp(); //Step 5
        }
        @Test
            public void GiftScan() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                PermissionPage permissionPage = new PermissionPage(driver);
                Thread.sleep(10000);
                homePage.ScanGiftClick(); //Step 2
                permissionPage.OneTime(); //Step 3
                loginPage.isLoginDisplayed();//Step 4
                driver.closeApp(); //Step 5
        }
        @Test
            public void Partner() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                AccumulatePointPage accumulatePointPage = new AccumulatePointPage(driver);
                AllPartnerPage allPartnerPage = new AllPartnerPage(driver);
                Thread.sleep(10000);
                homePage.AccumulateClick(); //Step 3
                accumulatePointPage.SeeAllPartnerClick(); //Step 4
                allPartnerPage.swipeTimeCustom(10); //Step 5
                allPartnerPage.ChoosePartnerClick(); //Step 6
                loginPage.isLoginDisplayed(); //Step 7
                driver.closeApp(); //Step 8
        }
        @Test
            public void Wallet() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                WalletPage walletPage = new WalletPage(driver);
                Thread.sleep(10000);
                homePage.WalletClick(); //Step 2
                loginPage.isLoginDisplayed(); //Step 3
                driver.closeApp(); //Step 4
        }
        @Test
            public void Gift() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                GiftPage giftPage = new GiftPage(driver);
                Thread.sleep(10000);
                homePage.GiftClick(); //Step 2
                loginPage.isLoginDisplayed(); //Step 3
                driver.closeApp(); //Step 4
        }
        @Test
            public void FollowShop() throws InterruptedException{
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                ProductPage productPage = new ProductPage(driver);
                ShopPage shopPage = new ShopPage(driver);
                Thread.sleep(10000);
                homePage.ExchangeClick(); //Step 2
                exchangePage.swipeTimeCustom(10); //Step 3
                exchangePage.ProductClick(); //Step 4
                Thread.sleep(3000);
                productPage.swipeScreenCustom(0.5,0.95,0.5,0.05); //Step 5
                productPage.clickShopPage(); //Step 6
                shopPage.FollowUnfollow(); //Step 7
                loginPage.isLoginDisplayed(); //Step 8
                driver.closeApp(); //Step 9
        }
        @Test
            public void likeProduct() throws  InterruptedException{
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                ProductPage productPage = new ProductPage(driver);
                Thread.sleep(10000);
                homePage.ExchangeClick(); //Step 2
                exchangePage.swipeTimeCustom(20); //Step 3
                exchangePage.ProductClick(); //Step 4
                Thread.sleep(3000);
                productPage.LikeProduct(); //Step 5
                loginPage.isLoginDisplayed(); //Step 6
                driver.closeApp(); //Step 7
        }
        @Test
            public void buyProduct() throws  InterruptedException{
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                ProductPage productPage = new ProductPage(driver);
                CartPage cartPage = new CartPage(driver);
                Thread.sleep(10000);
                homePage.ExchangeClick(); //Step 2
                exchangePage.swipeTimeCustom(20); //Step 3
                exchangePage.ProductClick(); //Step 4
                Thread.sleep(3000);
                productPage.BuyNow(); //Step 5
                productPage.BuyConfirmClick(); //Step 6
                cartPage.PurchaseClick(); //Step 7
                loginPage.isLoginDisplayed(); //Step 8
                driver.closeApp(); //Step 9
        }
        @Test
            public void likeVoucher() throws InterruptedException{
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                VoucherPage voucherPage = new VoucherPage(driver);
                AllVoucherPage allVoucherPage = new AllVoucherPage(driver);
                PermissionPage permissionPage = new PermissionPage(driver);
                Thread.sleep(10000);
                homePage.ExchangeClick(); //Step 2
                Thread.sleep(3000);
                exchangePage.AllVoucherClick(); //Step 3
                permissionPage.OneTime(); //Step 4
                allVoucherPage.PaidVoucherClick(); //Step 5
                voucherPage.clickLike();  //Step 6
                loginPage.isLoginDisplayed(); //Step 7
                driver.closeApp(); //Step 8
        }
}
