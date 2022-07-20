package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroComSucessoPage {

    public WebDriver driver;

    @FindBy(id = "firstname")
    WebElement primeiroNome;

    @FindBy(id = "lastname")
    WebElement sobrenome;

    @FindBy(id = "userName")
    WebElement nomeUsuario;

    @FindBy(id = "password")
    WebElement senha;

    @FindBy(id = "register")
    WebElement botaoRegistro;

    @FindBy(id = "newUser")
    WebElement botaoNovoUsuario;

    @FindBy(className = "main-header")
    WebElement textoHeader;

    @FindBy(id = "gotologin")
    WebElement botaoVolteAoLogin;

    public CadastroComSucessoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPrimeiroNome(String strPrimeiroNome) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        primeiroNome.sendKeys(strPrimeiroNome);
    }

    public void setSobrenome(String strSobrenome) {
        sobrenome.sendKeys(strSobrenome);
    }

    public void setNomeUsuario(String strNomeUsuario) {
        nomeUsuario.sendKeys(strNomeUsuario);
    }

    public void setSenha(String strSenha) {
        senha.sendKeys(strSenha);
    }

    public void clickButtonNovoUsuario() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        botaoNovoUsuario.click();
    }

    public void clickCheckboxNaoSouRobo() {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.recaptcha-checkbox-checked")));
        driver.switchTo().defaultContent();
    }

    public void clickButtonRegistro() {
        botaoRegistro.click();
    }

    public String getValidaRetornoAPaginaCadastro() {
        driver.navigate().refresh();
        return textoHeader.getText();
    }

    public void clickButtonVolteAoLogin() {
        botaoVolteAoLogin.click();
    }
}


