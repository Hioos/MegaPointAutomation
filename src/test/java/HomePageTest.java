import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
    HomePage homePage;
    MyAccountPage myAccountPage;
    EditProfilePage editProfilePage;
    LoginPage loginPage;
    OrderHistory orderHistory;
    LastOrder lastOrder;
    NotificationPage notificationPage;
    AllBrandPage allBrandPage;
    BrandPage brandPage;

        @Test(testName = "UpdateInformation", dataProvider = "UpdateInfo")
            public void updateProfile(String name,String number, String address,String result) throws InterruptedException {
                driver.launchApp(); //Step 1
                HomePage homePage = new HomePage(driver);
                MyAccountPage myAccountPage = new MyAccountPage(driver);
                EditProfilePage editProfilePage = new EditProfilePage(driver);
                LoginPage loginPage = new LoginPage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick(); //Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.MyAccountClick(); //Step 4
                myAccountPage.clickEditProfile();//Step 5
                editProfilePage.SendKeysName(name); //Step 6
                String UserNameUpdate = editProfilePage.getUserName();
                editProfilePage.SendKeysPhoneNumber(number); //Step 7
                editProfilePage.chooseDoB(); //Step 8
                editProfilePage.chooseGender(); //Step 9
                editProfilePage.swipeScreen(); //Step 10
                editProfilePage.chooseCity(); //Step 11
                editProfilePage.chooseDistrict();//Step 12
                editProfilePage.chooseWard(); //Step 13
                editProfilePage.SendKeyAddress(address); //Step 14
                editProfilePage.UpdateConfirm(); //Step 15
                if(result == "true"){
                    String userName = myAccountPage.getUserName();
                    Assert.assertEquals(userName,UserNameUpdate); //Step 16.1
                }
                else {
                    String actualResult = editProfilePage.getNotificationText();
                    Assert.assertEquals(actualResult,result); //Step 17.1
                }
                driver.closeApp(); //Step 18
        }
        @Test
            public void AddUse() throws InterruptedException {
                driver.launchApp(); //Step 1
                LoginPage loginPage = new LoginPage(driver);
                AddUsePage addUsePage =new AddUsePage(driver);
                HomePage homePage = new HomePage(driver);
                Thread.sleep(10000);
                homePage.MyAccountClick();//Step 2
                loginPage.LoginTrue(); //Step 3
                homePage.AddUseClick(); //Step 4
                addUsePage.isBarCodeDisplayed(); //Step 5
                addUsePage.isQRCodeDisplayed(); //Step 6
                addUsePage.clickSeeCode(); //Step 7
                String FirstCode = addUsePage.getCode();
                addUsePage.clickUpdateCode(); //Step 8
                String SecondCode = addUsePage.getCode();
                Assert.assertNotEquals(FirstCode,SecondCode); //Step 9
                driver.closeApp();
        }
    @Test
    public void CancelOrder() throws  InterruptedException{
        driver.launchApp(); //Step 1
        OrderHistory orderHistory = new OrderHistory(driver);
        LastOrder lastOrder = new LastOrder(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(10000);
        homePage.MyAccountClick();
        loginPage.LoginTrue(); //Step 2
        homePage.MyAccountClick(); //Step 3
        myAccountPage.clickHistory(); //Step 4
        String orderId = orderHistory.getOrderId();
        orderHistory.LastOrderClick(); //Step 23
        Thread.sleep(5000);
        lastOrder.swipeScreenCustom(0.5,0.6,0.5,0.2); //Step 24
        Thread.sleep(3000);
        lastOrder.CancelOrderClick(); //Step 28
        lastOrder.SendKeysCancelOrderReason(); //Step 29
        lastOrder.CancelOrderConfirmClick(); //Step 30
        String canceledId = orderHistory.getCanceledId();
        Assert.assertEquals(canceledId,orderId); //Step 31
        driver.closeApp(); //Step 32
    }
    @Test
    public void Events() throws  InterruptedException{
        driver.launchApp(); //Step 1
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        NotificationPage notificationPage = new NotificationPage(driver);
        Thread.sleep(10000);
        homePage.MyAccountClick(); //Step 2
        loginPage.LoginTrue(); //Step 3
        homePage.BellClick(); //Step 4
        notificationPage.swipeTimeCustom(10); //Step 5
        Thread.sleep(3000);
        String eventTitle = notificationPage.getEventTitle();
        String eventDesc = notificationPage.getEventDesc();
        notificationPage.clickEvent(); //Step 6
        String eventPopupTitle = notificationPage.getEventPopUpTitle();
        String eventPopupDesc = notificationPage.getEventPopUpDesc();
        Assert.assertEquals(eventPopupTitle,eventTitle); //Step 7
        Assert.assertTrue(eventPopupDesc.contains(eventDesc)); //Step 8
        driver.closeApp(); //Step 9
        }
    @Test(dataProvider = "dp2")
    public void Brands(String keyword, int result) throws InterruptedException {
        driver.launchApp();//Step 1
        HomePage homePage = new HomePage(driver);
        AllBrandPage allBrandPage = new AllBrandPage(driver);
        BrandPage brandPage = new BrandPage(driver);
        Thread.sleep(20000);
        homePage.swipeScreenCustom(0.5, 0.8, 0.5, 0.2); //Step 2
        Thread.sleep(3000);
        homePage.SeeAllBrand();//Step 3
        allBrandPage.sendKeysSearch(keyword); //Step 4
        if (result == 0) {
            allBrandPage.isBrandNotDisplayed();
        } else {
            String allPageBrandName = allBrandPage.getBrandName();
            allBrandPage.clickBrand(); //Step 5
            String BrandName = brandPage.getBrandName();
            Assert.assertEquals(BrandName, allPageBrandName); //Step 6
            driver.closeApp(); //Step 7

        }
    }
        @DataProvider
                public Object[][] UpdateInfo(){
                        return new Object[][]{
                                new Object[]{editProfilePage.randomNameGen(),editProfilePage.randomNumberGen(),"112 Tay Son","true"},
                                new Object[]{"",editProfilePage.randomNumberGen(),"113 Tay Son","Vui lòng điền các thông tin bắt buộc !"},
                                new Object[]{editProfilePage.randomNameGen(),"","114 Tay Son","Vui lòng nhập số điện thoại hợp lệ !"},
                                new Object[]{editProfilePage.randomNameGen(),editProfilePage.randomNumberGen(),"115 Tay Son","Vui lòng điền các thông tin bắt buộc !"},
                        };
        }
        @DataProvider
                public Object[][] dp2(){
                        return new Object[][]{
                                new  Object[]{"Kyna",1},
                                new Object[]{"",1},
                                new Object[]{"xyzsynchro",0}
                        };
        }

}
