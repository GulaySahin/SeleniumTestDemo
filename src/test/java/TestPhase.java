import org.junit.Test;

public class TestPhase extends TestMethods {

    @Test
    public void testEt() throws InterruptedException{
        checkTitle();
        closePopUp();
        loginKontrol("deneme@gmail.com","denemesifre");
        search();
        secondPage();
        randomProduct();
        //checkPrice(selectedProductString);
        productIncrease();
        deleteProduct();
    }
}
