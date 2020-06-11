package com.vytrack.pages;
//we gave ti craeta corresonded page class
//for each page of application
//login page =login page class
//every page class will store webelements and methods related to that page


import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vytrack.utilities.Driver;

public class LoginPage extends BasePage {
    /*
    We can also use initilazi method as well but we cant use static
     {
        PageFactory.initElements ( Driver.get (), this );
    }
     */


    @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(css = "alert alert-error")
    public WebElement warningMessage;

    public LoginPage ( ) {

        PageFactory.initElements ( Driver.get (), this );

    }

    /*
    reusable login method
    just call this method to login provide username and password
    @parameter userName
    @parameter password

     */

    public void login (String userName, String password) {
        userNameInput.sendKeys ( userName );
        passwordInput.sendKeys ( password, Keys.ENTER );
    }

    public void login (String role) {
        role = role.replace ( " ", "" );
        role = role.toLowerCase ();
        switch (role) {
            case "salesmanager":
                userNameInput.sendKeys ( ConfigurationReader.getProperty ( "SalesManagerUsername" ) );
                passwordInput.sendKeys ( ConfigurationReader.getProperty ( "SalesManagerPassword" ), Keys.ENTER );
                break;
            case "driver":
                userNameInput.sendKeys ( ConfigurationReader.getProperty ( "DriverUsername" ) );
                passwordInput.sendKeys ( ConfigurationReader.getProperty ( "DriverPassword" ), Keys.ENTER );
                break;
            case "storemanager":
                userNameInput.sendKeys ( ConfigurationReader.getProperty ( "StoreManagerUsername" ) );
                passwordInput.sendKeys ( ConfigurationReader.getProperty ( "StoreManagerPassword" ), Keys.ENTER );
                break;
            default:
                System.out.println ( "There is no such a Role" );
                break;

        }
    }


}
