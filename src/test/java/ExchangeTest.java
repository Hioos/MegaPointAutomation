import org.apache.tools.ant.types.resources.Last;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExchangeTest extends TestBase{
    HomePage homePage;
    ExchangePage exchangePage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    PurchasePage purchasePage;
    OrderHistory orderHistory;
    LastOrder lastOrder;
    OnlinePaymentPage onlinePaymentPage;
    AllVoucherPage allVoucherPage;
    VoucherCodePage voucherCodePage;
    GiftPage giftPage;
    LikedPage likedPage;
    PermissionPage permissionPage;
    ShopPage shopPage;
        @Test
            public void BuyProductCoD() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                ProductPage productPage = new ProductPage(driver);
                CartPage cartPage = new CartPage(driver);
                OrderHistory orderHistory = new OrderHistory(driver);
                PurchasePage purchasePage = new PurchasePage(driver);
                LastOrder lastOrder = new LastOrder(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.ExchangeClick(); //Step 4
                exchangePage.swipeTimeCustom(10); //Step 5
                exchangePage.ProductClick(); //Step 6
                Thread.sleep(3000);
                productPage.BuyNow(); //Step 7
                productPage.BuyConfirmClick(); //Step 8
                cartPage.clickPlus(); //Step 9
                cartPage.clickMinus(); //Step 10
                int amount = cartPage.getAmount(); //Step 11
                String productName = cartPage.getProductName(); //Step 12
                int productPrice = cartPage.getProductPrice(); //Step 13
                cartPage.PurchaseClick(); //Step 14
                Thread.sleep(8000);
                int purchaseProductPrice = purchasePage.getUnitPrice();
                Assert.assertEquals(purchaseProductPrice,productPrice); //Step 15
                String purchaseProductName = purchasePage.getProductName();
                Assert.assertEquals(purchaseProductName,productName); //Step 16
                int purchaseAmount = purchasePage.getAmount();
                Assert.assertEquals(purchaseAmount,amount); //Step 17
                purchasePage.swipeScreenCustom(0.5,0.6,0.5,0.2); //Step 18
                Thread.sleep(5000);
                int actualFinalPrice = purchasePage.getFinalPrice();
                purchasePage.CoDClick(); //Step 21
                Thread.sleep(5000);
                purchasePage.OrderClick(); //Step 22
                Thread.sleep(5000);
                int priceHistory = orderHistory.getPrice();
                Assert.assertEquals(priceHistory,actualFinalPrice);
            }

        @Test //failed1
            public void OnlinePaymentPurchase() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                ProductPage productPage = new ProductPage(driver);
                CartPage cartPage = new CartPage(driver);
                OrderHistory orderHistory = new OrderHistory(driver);
                PurchasePage purchasePage = new PurchasePage(driver);
                LastOrder lastOrder = new LastOrder(driver);
                OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.ExchangeClick(); //Step 4
                exchangePage.swipeTimeCustom(10); //Step 5
                exchangePage.ProductClick(); //Step 6
                Thread.sleep(3000);
                productPage.BuyNow(); //Step 7
                productPage.BuyConfirmClick(); //Step 8
                cartPage.clickPlus(); //Step 9
                cartPage.clickMinus(); //Step 10
                int amount = cartPage.getAmount(); //Step 11
                String productName = cartPage.getProductName(); //Step 12
                int productPrice = cartPage.getProductPrice(); //Step 13
                cartPage.PurchaseClick(); //Step 14
                Thread.sleep(8000);
                int purchaseProductPrice = purchasePage.getUnitPrice();
                Assert.assertEquals(purchaseProductPrice,productPrice); //Step 15
                String purchaseProductName = purchasePage.getProductName();
                Assert.assertEquals(purchaseProductName,productName); //Step 16
                int purchaseAmount = purchasePage.getAmount();
                Assert.assertEquals(purchaseAmount,amount); //Step 17
                purchasePage.swipeScreenCustom(0.5,0.6,0.5,0.2); //Step 18
                Thread.sleep(5000);
                int actualFinalPrice = purchasePage.getFinalPrice();
                purchasePage.OnlinePaymentClick(); //Step 21
                Thread.sleep(5000);
                purchasePage.OrderClick(); //Step 22
                Thread.sleep(8000);
                onlinePaymentPage.isOnlinePaymentDisplayed(); //Step 23
                driver.closeApp(); //Step 24
        }
        @Test
            public void UseFreeVoucher() throws InterruptedException {
                driver.launchApp();//Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                AllVoucherPage allVoucherPage = new AllVoucherPage(driver);
                VoucherPage voucherPage = new VoucherPage(driver);
                VoucherCodePage voucherCodePage = new VoucherCodePage(driver);
                GiftPage giftPage = new GiftPage(driver);
                PermissionPage permissionPage = new PermissionPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.ExchangeClick(); //Step 4
                Thread.sleep(5000);
                exchangePage.AllVoucherClick(); //Step 5
                permissionPage.OneTime(); //Step 6
                allVoucherPage.FreeVoucherClick(); //Step 7
                String shopName = voucherPage.getShopName();
                voucherPage.UseClick(); //Step 8
                voucherCodePage.checkBarCode(); //Step 9
                voucherCodePage.checkQRCode(); //Step 10
                String code = voucherCodePage.getVoucherCode();
                driver.navigate().back(); //Step 11
                String usedCode = voucherPage.getVoucherCode();
                Assert.assertEquals(usedCode,code); //Step 12
                driver.navigate().back(); //Step 13
                allVoucherPage.GiftClick(); //Step 14
                String actualShopName = giftPage.getShopName();
//                System.out.println(shopName +" " + actualShopName);
                Assert.assertEquals(actualShopName,shopName); //Step 15
//                String lastVoucher = giftPage.getLastVoucherCode();
                giftPage.ClickUseVoucher(); //Step 17
                String usedVoucher = voucherCodePage.getVoucherCode();
                Assert.assertEquals(usedVoucher,usedCode); //Step 18
                driver.closeApp(); //Step 19
            }
        @Test //failed 4
            public void UsePaidVoucher() throws InterruptedException{
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                AllVoucherPage allVoucherPage = new AllVoucherPage(driver);
                VoucherPage voucherPage = new VoucherPage(driver);
                OnlinePaymentPage onlinePaymentPage =new OnlinePaymentPage(driver);
                PermissionPage permissionPage = new PermissionPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.ExchangeClick(); //Step 4
                Thread.sleep(5000);
                exchangePage.AllVoucherClick(); //Step 5
                permissionPage.OneTime(); //Step 6
                allVoucherPage.PaidVoucherClick(); //Step 7
                voucherPage.UseClick(); //Step 8
                voucherPage.NotificationNextText(); //Step 9
                Thread.sleep(3000);
                voucherPage.NotificationNextText(); //Step 10
                Thread.sleep(10000);
                onlinePaymentPage.isOnlinePaymentDisplayed(); //Step 11
                driver.closeApp(); //Step 12
        }
        @Test
            public void LikeProduct() throws InterruptedException {
                driver.launchApp();//Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                ProductPage productPage = new ProductPage(driver);
                GiftPage giftPage = new GiftPage(driver);
                LikedPage likedPage = new LikedPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.ExchangeClick(); //Step 4
                exchangePage.swipeTimeCustom(10); //Step 5
                exchangePage.ProductClick(); //Step 6
                String productName = productPage.getProductName();
                productPage.LikeProduct(); //Step 7
                driver.navigate().back(); //Step 8
                homePage.GiftClick(); //Step 9
                Thread.sleep(3000);
                giftPage.LikedClick(); //Step 10
                likedPage.LikedProductClick(); //Step 11
                likedPage.LastLikedProductClick(); //Step 12
                String likedProductName = productPage.getProductName();
                Assert.assertEquals(likedProductName,productName); //Step 13
                productPage.LikeProduct(); //Step 14
                driver.closeApp();//Step 15
            }
        @Test //failed 2
            public void LikeVoucher() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                VoucherPage voucherPage = new VoucherPage(driver);
                GiftPage giftPage = new GiftPage(driver);
                LikedPage likedPage = new LikedPage(driver);
                AllVoucherPage allVoucherPage = new AllVoucherPage(driver);
                PermissionPage permissionPage = new PermissionPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.ExchangeClick();//Step 4
                Thread.sleep(3000);
                exchangePage.AllVoucherClick();//Step 5
                permissionPage.OneTime(); //Step 6
                allVoucherPage.PaidVoucherClick(); //Step 7
                Thread.sleep(5000);
                String shopName = voucherPage.getShopName(); //Step 8
                voucherPage.clickLike(); //Step 9
                driver.navigate().back(); //Step 10
                allVoucherPage.GiftClick(); //Step 11
                Thread.sleep(3000);
                giftPage.LikedClick(); //Step 12
                likedPage.LikedVoucherClick(); //Step 13
                likedPage.clickLasLikedVoucher(); //Step 14
                String shopNameactual = voucherPage.getShopName(); //Step 15
                Assert.assertEquals(shopNameactual,shopName); //Step 16
                voucherPage.clickLike();
                driver.closeApp(); //Step 17
        }
        @Test
            public void ShareProduct() throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                ExchangePage exchangePage = new ExchangePage(driver);
                ProductPage productPage = new ProductPage(driver);
                PermissionPage permissionPage = new PermissionPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.ExchangeClick(); //Step 4
                exchangePage.swipeTimeCustom(10); //Step 5
                exchangePage.ProductClick(); //Step 6
                productPage.ShareProduct();//Step 7
                permissionPage.isShareDisplayed(); //Step 8
                driver.closeApp(); //Step 9
        }
        @Test //failed 3
            public void ShareVoucher() throws InterruptedException{
            driver.launchApp(); //Step 1
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            ExchangePage exchangePage = new ExchangePage(driver);
            VoucherPage voucherPage = new VoucherPage(driver);
            PermissionPage permissionPage = new PermissionPage(driver);
            AllVoucherPage allVoucherPage = new AllVoucherPage(driver);
            Thread.sleep(10000);
            homePage.MyAccountClick(); //Step 2
            loginPage.LoginTrue(); //Step 3
            homePage.ExchangeClick(); //Step 4
            Thread.sleep(5000);
            exchangePage.AllVoucherClick(); //Step 5
            permissionPage.OneTime(); //Step 6
            allVoucherPage.PaidVoucherClick(); //Step 7
            voucherPage.clickShare(); //Step 8
            permissionPage.isShareDisplayed(); //Step 9
            driver.closeApp(); //Step 10
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
            homePage.MyAccountClick();//Step 2
            loginPage.LoginTrue(); //Step 3
            homePage.ExchangeClick(); //Step 4
            Thread.sleep(3000);
            exchangePage.swipeTimeCustom(10);//Step 5
            exchangePage.ProductClick();//Step 6
            Thread.sleep(3000);
            productPage.swipeScreenCustom(0.5,0.95,0.5,0.05);//Step 7
            Thread.sleep(3000);
            String Product_ShopName = productPage.getShopName();
            productPage.clickShopPage();//Step 8
            String Shop_ShopName = shopPage.getShopName();
            int bool = shopPage.followStatus();
            int followerBefore = shopPage.getFollower();
            shopPage.FollowUnfollow(); //Step 9
            int followerAfter = shopPage.getFollower();
                if(bool == 1){
                    Assert.assertEquals(followerAfter,followerBefore-1); //Step 10.1
                    Assert.assertEquals(shopPage.followStatusText(),"Theo dõi"); //Step 10.2
                }
                else{
                    Assert.assertEquals(followerAfter,followerBefore+1); //Step 11.1
                    Assert.assertEquals(shopPage.followStatusText(),"Đã theo dõi"); //Step 11.2
                }
            Assert.assertEquals(Shop_ShopName,Product_ShopName); //Step 12
            driver.closeApp(); //Step 13
        }
}
