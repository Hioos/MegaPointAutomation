import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PermissionPage extends PageBase{
    public PermissionPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    MobileElement OneTime;
@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    MobileElement Foreground;
@AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
    MobileElement Deny;
@AndroidFindBy(id= "android:id/profile_tabhost")
    MobileElement Share;
public void OneTime(){
    click(OneTime);
}
public void Always(){
    click(Foreground);
}
public void Deny(){
    click(Deny);
}
public boolean isShareDisplayed(){
    return isDisplayed(Share);
}
}
