package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValidCredentials
 *      Enter “Admin” username
 *      Enter “admin123 password
 *      Click on ‘LOGIN’ button
 *      Verify the ‘Dashboard’ text is display
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    static String baseUrl = " https://opensource-demo.orangehrmlive.com/"; // base URL

    @Before
    public void setUp () {
        openBrowser(baseUrl); // calling method from BaseTest class to open and set-up the browser
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("Admin"); // find element for username field and enter valid username
        driver.findElement(By.name("password")).sendKeys("admin123"); // find element for password field and enter valid password
        driver.findElement(By.xpath("//button[@type = 'submit']")).click(); // find element for submit button and click
        // find element to verify the redirection from the re-directed page
        String actualText = driver.findElement(By.xpath("//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        String expectedText = "Dashboard"; // expected text in the re-directed page
        Assert.assertEquals(expectedText, actualText); // verify expected and actual text
    }

    @After
    public void tearTown () {
        closeBrowser(); // calling method from BaseTest class to close the browser
    }

}
