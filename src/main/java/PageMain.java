import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMain {
    public WebDriver webDriver;
    protected static String url = "https://www.n11.com/";


    @Before
    public void openChrome (){
        System.setProperty("webdriver.chrome.driver", "driversR/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }


    public void checkUrl(){
        Assert.assertTrue(url.contains("https://www.n11.com/"));
        System.out.println("Ana Sayfa Kontrolü Yapıldı."+url);

    }


    public void checkLogin(){
        Assert.assertNotNull("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div/div/a[1]");
        System.out.println("Login Kontrolü Yapıldı.");
    }

    public void checkSecondPage(){
        Assert.assertTrue("https://www.n11.com/arama?q=Bilgisayar&pg=2".contains("https://www.n11.com/arama?q=Bilgisayar&pg=2"));
        System.out.println("İkinci Sayfa Kontrolü Yapıldı.");
    }

    public void checkCart(){
        Assert.assertTrue("<h2 class='title'>Sepetiniz Boş</h2>".contains("Sepetiniz Boş"));
        System.out.println("Sepetin Boş Olup Olmadığı Kontrol Edildi.");
    }

    public void checkPrice(String priceCheck){
        WebElement basketPrice = findElementByXPathS("//*[@id='unf-p-id']/div/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div/h1");
        String basketPriceString = basketPrice.getText();
        Assert.assertTrue(Boolean.parseBoolean("<span class='price'>"+basketPriceString+"</span>".equals(priceCheck)));
        System.out.println("Ürün Fiyatı ile Sepet Fiyatı Kontrol Edildi.");

    }

    public void checkProductIncrease(){

        Assert.assertTrue("//*[@id='quantity_127021897309']".contains("2"));
        System.out.println("Ürün Adedinin 2 Olduğu Kontrol Edildi.");

    }


    public  void  ElementToBeClickableAndClick(By element){
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println(element+" ");

    }


    public WebElement findElementByXPathS(String xpath){
        WebElement element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    public  void ElementSendKey(By element, String sendkey){
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(sendkey);
        System.out.println( "Sayfanın Tıklanabilir Olması Beklendi ve Tıklandı.");
    }
    public void clickElementByXPathS(String xpath){
        webDriver.findElement(By.xpath(xpath)).click();
    }


    @After
    public void quitChrome() throws InterruptedException{
        Thread.sleep(8000);
        webDriver.quit();
    }

}
