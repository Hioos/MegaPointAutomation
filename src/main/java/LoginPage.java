import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageBase{

    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
@AndroidFindBy(accessibility = "btnphone")
    MobileElement NumberTextbox;
@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
    MobileElement NextButton;
@AndroidFindBy(accessibility = "btnpass")
    MobileElement PassWordTextbox;
@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
    MobileElement LogInButton;
@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
    MobileElement NotificationText;
@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
    MobileElement NewNumberInstruction;
public void SendKeysNumberTextbox(String number){
    clear(NumberTextbox);
    sendKeys(NumberTextbox,number);
}
public void NextButtonClick(){
    click(NextButton);
}
public void SendKeysPassWordTextbox(String password){
    clear(PassWordTextbox);
    sendKeys(PassWordTextbox,password);
}
public void LogInButtonClick(){
    driver.hideKeyboard();
    click(LogInButton);
    click(LogInButton);
}
public String getTextNotification(){
    return getText(NotificationText);
}
public String getNumber(){
    return getText(NumberTextbox);
}
public String getNewNumberIns(){
    return  getText(NewNumberInstruction);
}
public void LoginTrue(){
    SendKeysNumberTextbox("0393704472");
    NextButtonClick();
    SendKeysPassWordTextbox("0000");
    LogInButtonClick();
}
public boolean isLoginDisplayed(){
    return isDisplayed(NumberTextbox);
}
}
