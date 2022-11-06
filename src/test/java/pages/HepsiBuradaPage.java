package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Set;

public class HepsiBuradaPage {
    public HepsiBuradaPage() {


          PageFactory.initElements(Driver.getDriver(),this);}
          JavascriptExecutor jse  = (JavascriptExecutor) Driver.getDriver();
          Actions actions=new Actions(Driver.getDriver());
          @FindBy(id="login")
          public WebElement login;
          @FindBy(xpath="//input[@id='txtUserName']")
          public WebElement email;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement password;
    @FindBy(id = "btnEmailSelect")
    public WebElement passwordSubmit;

    @FindBy(id="myAccount")
    public WebElement myAccount;

    @FindBy(id=  "btnLogin")
    public WebElement loginSubmit;

    @FindBy(css =  "div.SearchBoxOld-ZhPLViH9PNKO0VrBBGLJ")
    public WebElement searchBox;


    @FindBy(xpath =  "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookies;

    @FindBy(xpath = "//div[@class='desktop    voltran-container   sf-moria complete']//li")
    public List<WebElement> productsList;


    @FindBy(xpath =  "//*[text()='Mavi Çatı Yayınları Insan Ne Ile Yaşar - Tolstoy - Maviçatı Yayınları']")
    public WebElement insanNY1;

    @FindBy(xpath =  "//button[@class='add-to-basket button small']")
     public WebElement insanNY2addToCart;

     @FindBy(xpath =  "//*[text()='BiKitapSana']")
    public WebElement sepetimInsanNY2;

    @FindBy(id= "addToCart")
    public WebElement addToCart;

    @FindBy(xpath = "//*[text()='Sepete git']")
    public WebElement goToCart;

    @FindBy(xpath = " //*[text()='Esra Aslan']")
    public WebElement esra;


    @FindBy(xpath = "//*[text()='Casio MTP-V002D-1BUDF Standart Erkek Kol Saati']")
    public WebElement saat1;


     @FindBy(xpath = "//button[@class='add-to-basket button small']")
     public WebElement saat2;


    @FindBy(xpath = "//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement X;

    @FindBy(xpath = "//*[text()='Casio MTP-V002D-1BUDF Standart Erkek Kol Saati'][1]")
    public WebElement sepetimSaat1;

    @FindBy(xpath = "//*[text()='Casio MTP-V002D-1BUDF Standart Erkek Kol Saati'][2]")
    public WebElement sepetimSaat2;



                               // methods//

    public void anasayfayaGit() {

        Driver.getDriver().get(ConfigReader.getProperty("hepsiBuradaUrl"));
        jse.executeScript("arguments[0].click();",cookies); }

        public void login() {
        jse.executeScript("arguments[0].click();",myAccount);
        jse.executeScript("arguments[0].click();",login);

        email.sendKeys("aslanesra035@gmail.com");
        jse.executeScript("arguments[0].click();",loginSubmit);
        password.sendKeys("*********");
        jse.executeScript("arguments[0].click();",passwordSubmit);
        ReusableMethods.waitForVisibility(searchBox,3);}



    public void girisiDogrula() {
        Assert.assertTrue(esra.isDisplayed());
    }




    public void urunSec(){

        jse.executeScript("arguments[0].click();",searchBox);
        actions.sendKeys(searchBox,"İnsan Ne İle Yaşar").sendKeys(Keys.ENTER).perform();
         String ilkSayfaWindowHandleDegeri = Driver.getDriver().getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);
        jse.executeScript("arguments[0].click();",insanNY1);
        Set<String> windowHandleseti = Driver.getDriver().getWindowHandles();
        String ikinciSayfaWindowHandleDegeri = "";
        for (String each : windowHandleseti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)) {
                ikinciSayfaWindowHandleDegeri = each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWindowHandleDegeri);
        jse.executeScript("arguments[0].click();",addToCart);
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].click();",X);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        jse.executeScript("arguments[0].click();",insanNY2addToCart);
        ReusableMethods.waitFor(3);




    }
    public void urunuDogrula(){
        jse.executeScript("arguments[0].click();",goToCart);
        ReusableMethods.waitFor(2);
        String expectedText= "Mavi Çatı Yayınları Insan Ne Ile Yaşar - Tolstoy - Maviçatı Yayınları";
        String actualText1=insanNY1.getText();
        Assert.assertTrue(actualText1.contains(expectedText));
         String actualText2=sepetimInsanNY2.getText();
        Assert.assertTrue(actualText2.contains(expectedText));


    }
    public void cıkısYap(){}


    public void windowsKapat(){
        Driver.getDriver().quit();
    }

    public void ıkıUrunSec(){
        actions.sendKeys(searchBox,"casio saat").sendKeys(Keys.ENTER).perform();
         String saatAnsayfaWH= Driver.getDriver().getWindowHandle();
        jse.executeScript("arguments[0].click();",saat1);
        Set<String> windowHandleseti = Driver.getDriver().getWindowHandles();
        System.out.println(windowHandleseti);
        String saat1WH = "";
        for (String each : windowHandleseti
        ) {
            if (!each.equals(saatAnsayfaWH)) {
                saat1WH = each;
            }
        }
        Driver.getDriver().switchTo().window(saat1WH);
        jse.executeScript("arguments[0].click();",addToCart);
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].click();",X);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        jse.executeScript("arguments[0].click();",saat2);
        jse.executeScript("arguments[0].click();",goToCart);

    }
    public void secilenIkıUrrunDogrulanır(){
        String expectedSaat="Casio";
        String actualSaat1=saat1.getText();
        String actualSaat2=saat1.getText();
        Assert.assertTrue(actualSaat1.contains(expectedSaat));
        Assert.assertTrue(actualSaat2.contains(expectedSaat));

    }


}
