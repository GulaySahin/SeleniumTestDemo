import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class TestMethods extends PageMain {

    public void  checkTitle() {

        checkUrl();


    }

    public void closePopUp()throws  InterruptedException{
        Thread.sleep(10000);
        findElementByXPathS("//*[@id='dengage-push-perm-slide']/div/div[2]/div/button[1]").click();

    }

    public void loginKontrol(String email, String password) throws InterruptedException{

        findElementByXPathS("//*[@id='header']/div/div/div[2]/div[2]/div[2]/div/div/a[1]").click();
        Thread.sleep(2000);
        findElementByXPathS("//*[@id='email']").sendKeys(email);
        findElementByXPathS("//*[@id='password']").sendKeys(password);
        findElementByXPathS("//*[@id='loginButton']").click();
        Thread.sleep(2000);
        findElementByXPathS("//*[@id='header']/div/a/img").click();
        checkLogin();

    }

    public void search() throws InterruptedException{
        ElementSendKey(By.xpath("//*[@id='searchData']"), "Bilgisayar");
        ElementToBeClickableAndClick(By.xpath(("//*[@id='header']/div/div/div[2]/div[1]/div/a")));
        Thread.sleep(6000);
    }

    public void secondPage() throws InterruptedException{
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        WebElement secondPage = webDriver.findElement(By.xpath("//div[@id='view']//ul[@class='clearfix']//li['27']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",secondPage);
        ElementToBeClickableAndClick(By.xpath("//*[@id='contentListing']/div/div/div[2]/div[5]/a[2]"));
        checkSecondPage();
    }

    public  void randomProduct() throws InterruptedException{
        List<WebElement> products = webDriver.findElements(By.xpath("//div[@id='view']//ul[@class='clearfix']//li//a[@class='plink']"));

        Random random = new Random();
        int randomProduct = random.nextInt(products.size());
        int productNumberLi = randomProduct+1;

        WebElement clickedItem = findElementByXPathS("//div[@id='view']//ul[@class='clearfix']//li["+productNumberLi+"]//a");
        String clickedItemString = clickedItem.getText();
        System.out.println("Clicked Item : "+clickedItemString);

        products.get(randomProduct).click();
        Thread.sleep(6000);

        WebElement selectedProduct = findElementByXPathS("//*[@id='unf-p-id']/div/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div/h1");
        String selectedProductString = selectedProduct.getText();

        System.out.println(""+selectedProductString);
        clickElementByXPathS("//*[@id='unf-p-id']/div/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[2]/a");
        Thread.sleep(6000);



        clickElementByXPathS("//*[@id='header']/div/div/div[2]/div[2]/div[4]/a");
        clickElementByXPathS("//*[@id='userKvkkModal']/div/span[1]");


    }

    public void productIncrease(){
        clickElementByXPathS("//*[@id='newCheckout']/div/div[1]/div[2]/div[1]/section[2]/table[2]/tbody/tr/td[3]/div[1]/div/span[1]");

        checkProductIncrease();
    }

    public void deleteProduct(){
        clickElementByXPathS("//*[@id='newCheckout']/div/div[1]/div[2]/div[1]/section[2]/table[2]/tbody/tr/td[1]/div[3]/div[2]/span[1]");

        checkCart();
    }


}
