package Selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AllianzUITest {

    private static final String WEB_SITE_URL = "https://b2c-es.uat.booking.allianz-assistance.com/iframe.html?angularparams=/TRAVEL/B2C/ES/es_ES/step-1";
    private static final Long MILISECONDS = 3000L;

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 35);
    }

    @Test
    public void shouldBeAbleToContractInsurancePolicy() throws InterruptedException {

        driver.get(WEB_SITE_URL);

        WebElement frame = driver.findElement(By.id("booking-iframe-id"));
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.switchTo().frame(frame);

        //VACACIONES-CALCULAR
        Thread.sleep(MILISECONDS);
        WebElement dropDownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-id='typeOfCover']")));
        dropDownButton.click();

        WebElement selectVacaciones = driver.findElement(By.xpath("//*[@data-normalized-text='<span class=\"text\">Vacaciones</span>']"));
        selectVacaciones.click();

        WebElement selectTipoViaje = driver.findElement(By.xpath("//*[@data-id='travelCategory']"));
        selectTipoViaje.click();

        WebElement noCrucero = driver.findElement(By.xpath("//*[@data-normalized-text='<span class=\"text\">No crucero</span>']"));
        noCrucero.click();

        WebElement selectDestino = driver.findElement(By.xpath("//*[@data-id='multiDestination']"));
        selectDestino.click();

        WebElement destino = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[8]/div/div[2]/div[1]/div/input"));
        destino.sendKeys("Gre");

        WebElement element1 = driver.findElement(By.xpath("//*[@data-normalized-text='<span class=\"text\">Grecia</span>']"));
        element1.click();
        selectDestino.click();

        WebElement fechaViaje = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[11]/div[2]/div[2]/div"));
        fechaViaje.click();

        WebElement diaInicio = driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[4]/td[4]"));
        diaInicio.click();

        WebElement fechaViaje2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[11]/div[3]/div[2]/div"));
        fechaViaje2.click();

        WebElement nextmonth = driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[3]"));
        nextmonth.click();

        WebElement diaFin = driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]"));
        diaFin.click();

        WebElement numViajero = driver.findElement(By.xpath("//*[@data-id='numberOfPerson']"));
        numViajero.click();

        driver.findElement(By.xpath("//*[@data-normalized-text='<span class=\"text\">1 </span>']")).click();

        driver.findElement(By.id("ageAtDeparture1")).sendKeys("30");
        driver.findElement(By.id("pricePerPerson1")).sendKeys("1500");
        driver.findElement(By.id("submit")).click();

        //IMPORTE

        driver.findElement(By.xpath("//*[@id=\"step-2\"]/ng-include[1]/div/span/div[1]/ng-include/div/h3"));
        driver.findElement(By.xpath("//*[@id=\"step-2\"]/ng-include[1]/div/span/div[2]/ng-include/div/h3"));
        driver.findElement(By.xpath("//*[@id=\"step-2\"]/ng-include[1]/div/span/div[3]/ng-include/div/h3"));

        driver.findElement(By.xpath("//*[@id=\"step-2\"]/ng-include[1]/div/span/div[1]/ng-include/div/ng-include[2]/div/button")).click();

        //DATOS DEL VIAJE

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[5]/div[1]/div/div[1]/div[1]/label[3]")).click();
        driver.findElement(By.id("billingFirstName")).sendKeys("Jheni");
        driver.findElement(By.id("billingLastName")).sendKeys("Gomes");
        WebElement tipoDoc = driver.findElement(By.xpath("//*[@data-id='billingPersonalIDType']"));
        tipoDoc.click();
        tipoDoc.click();
        driver.findElement(By.id("billingVat")).sendKeys("Z6586036Z");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[5]/div[6]/div[2]/div[2]/div[1]/div")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/table/tbody/tr/td/span[11]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr/td/span[12]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[4]/td[4]")).click();
        driver.findElement(By.id("billingAddress")).sendKeys("Calle 35");
        driver.findElement(By.id("billingZipCode")).sendKeys("28033");
        driver.findElement(By.id("billingCity")).sendKeys("Madrid");
        driver.findElement(By.id("billingProvince")).sendKeys("Madrid");
        driver.findElement(By.id("billingPhoneNumber")).sendKeys("628430300");
        driver.findElement(By.id("billingEmail")).sendKeys("prueba@gmail.com");
        WebElement nombre1 = driver.findElement(By.id("firstName1"));
        nombre1.sendKeys("Jheni");
        String valorIntroducido = nombre1.getAttribute("value");
        driver.findElement(By.id("lastName1")).sendKeys("Gomes");
        driver.findElement(By.id("dateOfBirth1")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/table/tbody/tr/td/span[11]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr/td/span[7]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[4]/td[4]")).click();
        driver.findElement(By.id("vat1")).sendKeys("Z6586036Z");
        driver.findElement(By.id("confirmDisclaimer")).click();
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        //RESUMEN
        WebElement valorTablaResumen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"report\"]/div/div/div[2]/div/div[2]/table/tbody/tr/td[1]")));
        assertEquals(valorTablaResumen.getText(), valorIntroducido);
        Thread.sleep(MILISECONDS);
        driver.findElement(By.id("submit")).click();

        //PAGO
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardholderName")));

        element.sendKeys("Jheniree Gomes");
        driver.findElement(By.id("paymentCardNumber")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("securityCode")).sendKeys("999");
        driver.findElement(By.id("expiry")).sendKeys("0622");
        driver.findElement(By.id("submit")).click();


        //CONFIRMACION
        WebElement confirmacionFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[1]/div/div/div/div/div/div[2]/h3[1]")));
        assertEquals("Confirmación de transacción", confirmacionFinal.getText());

        driver.close();
    }
}
