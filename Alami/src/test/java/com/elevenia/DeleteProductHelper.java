package com.elevenia;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteProductHelper {
    WebDriver driver;

    public DeleteProductHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void access_web() {
        this.driver.get("https://www.elevenia.co.id/");
        this.driver.manage().window().maximize();
    }

    public void search_keyword(String keyword) throws Throwable {
        String ColumnSearch = "//*[@id=\"AKCKwd\"]";
        WebDriverWait wait = new WebDriverWait(this.driver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ColumnSearch)));
        this.driver.findElement(By.xpath(ColumnSearch)).sendKeys(new CharSequence[]{keyword});
        this.driver.findElement(By.xpath(ColumnSearch)).sendKeys(new CharSequence[]{Keys.ENTER});
    }

    public void select_category_product_terlaris() throws Throwable {
        String SortProductTerlaris = "//*[@id=\"searchCondition_wrap\"]/div[1]/ul/li[2]/a";
        WebDriverWait wait = new WebDriverWait(this.driver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SortProductTerlaris)));
        this.driver.findElement(By.xpath(SortProductTerlaris)).click();
    }

    public void select_first_product_in_page() throws Throwable {
        String Product = "//div[@id=\"product_listing\"]/ul/ul[1]/li[1]";
        WebDriverWait wait = new WebDriverWait(this.driver, 35L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Product)));
        boolean staleElement = true;

        while(staleElement) {
            try {
                this.driver.findElement(By.xpath(Product)).click();
                staleElement = false;
            } catch (StaleElementReferenceException var5) {
                staleElement = true;
            }
        }

    }

    public void update_product(String QTY) throws Throwable {
        String Quantity = "//input[@name='optionStock']";
        WebDriverWait wait = new WebDriverWait(this.driver, 35L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Quantity)));
        this.driver.findElement(By.xpath(Quantity)).clear();
        this.driver.findElement(By.xpath(Quantity)).sendKeys(new CharSequence[]{QTY});
    }

    public void direct_to_cart_page() throws Throwable {
        String ButtanAddToCart = "/html/body/section/section/form[1]/div[1]/div[3]/div[6]/a[1]";
        this.driver.findElement(By.xpath(ButtanAddToCart)).click();
        String AcceptPopup = "//*[@id=\"mo_lay144\"]/div[2]/a[1]";
        WebDriverWait wait = new WebDriverWait(this.driver, 35L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AcceptPopup)));
        this.driver.findElement(By.xpath(AcceptPopup)).click();
    }

    public void change_courier() throws Throwable {
        String ButtonCourier = "//*[@id=\"frmTmall\"]/table/tbody/tr/td[6]/a[1]";
        this.driver.findElement(By.xpath(ButtonCourier)).click();
    }

    public void cancel_change_courier() throws Throwable {
        String ButtonCancel = "//*[@id=\"frm\"]/article/p[3]/a[2]";
        this.driver.switchTo().frame("ifrLayer");
        this.driver.findElement(By.xpath(ButtonCancel)).click();
        this.driver.switchTo().defaultContent();
    }

    public void delete_product_in_the_cart() throws Throwable {
        String ButtonDelete = "//*[@id=\"frmTmall\"]/table/tbody/tr/td[7]/a[2]";
        WebDriverWait wait = new WebDriverWait(this.driver, 35L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ButtonDelete)));
        this.driver.findElement(By.xpath(ButtonDelete)).click();
        String PopupVerification = "//*[@id=\"chkDelPopY\"]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PopupVerification)));
        this.driver.findElement(By.xpath(PopupVerification)).click();
    }

    public void should_be(String ExpecResult, String ExpectMsg) throws Throwable {
        String Result = "//*[@id=\"frmTmall\"]/table/tbody/tr/td/strong";
        String ActualResult = this.driver.findElement(By.xpath(Result)).getText();
        if (ExpecResult.equalsIgnoreCase("Success")) {
            Assert.assertEquals(ExpectMsg, ActualResult);
        } else {
            Assert.assertNotEquals(ExpecResult, ActualResult);
        }

    }
}
