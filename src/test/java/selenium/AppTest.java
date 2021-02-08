package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;
    
    String sueldo = "1400000";
    String ahorro = "8000000";
    
    By txtSueldo = By.id("sueldo");
    By txtAhorro = By.id("ahorro");
    
    By txtImpuesto = By.name("impuesto");
    By txtDxc = By.name("dxc");
    By txtSaldo = By.name("saldo");
    
    By btnCalcular = By.id("calcular");
        
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://54.84.190.180:5000/");
    }

    @Test
    public void testBusquedaAutomationPractice() throws InterruptedException {
    	
    	Thread.sleep(3000);
    	
    	System.out.println("Autocompletando textos...");
    	driver.findElement(txtSueldo).sendKeys(sueldo);
    	driver.findElement(txtAhorro).sendKeys(sueldo);
    	
    	System.out.println("Enviando formulario...");
		driver.findElement(btnCalcular).click();
		
		Thread.sleep(5000);
		
		System.out.println("Verificando resultados...");
		
		assertEquals("0", driver.findElement(txtImpuesto).getAttribute("value"));
		assertEquals("1020110", driver.findElement(txtDxc).getAttribute("value"));
		assertEquals("379890", driver.findElement(txtSaldo).getAttribute("value"));
		
    }
    
    @After
	public void tearDown() {
		driver.close();
	}
}