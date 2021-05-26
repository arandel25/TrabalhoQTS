package util;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Componentes {

    private WebDriver driver;
    private Select comboEscolaridade;
    private Select comboEsporte;
    private WebElement botao;
    private Alert alert;

    public void inicializa() {
        String chromeDriver = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");
    }

    public void fechaNavegador() {
        driver.quit();
    }

    public void testeTextField(String elementoNome) {
        driver.findElement(By.id("elementosForm:" + elementoNome)).sendKeys("Senac");
    }

    public void validaTextField(String elementoNome) {
        Assert.assertEquals("Senac", driver.findElement(By.id("elementosForm:" + elementoNome)).getAttribute("value"));
    }

    public void validaTextFieldVazio(String elementoNome) {
        Assert.assertEquals("", driver.findElement(By.id("elementosForm:" + elementoNome)).getAttribute("value"));
    }

    public void testeTextArea() {
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste\nTrabalho\nProfessora: Angélica");
    }

    public void validaTextArea() {
        Assert.assertEquals("Teste\nTrabalho\nProfessora: Angélica", driver.findElement(By.id("elementosForm:sugestoes"))
                .getAttribute("value"));
    }

    public void testeRadioButton() {
        driver.findElement(By.id("elementosForm:sexo:0")).click();
    }

    public void validaRadioButton() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    public void testeCheckBox() {
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
    }

    public void validaCheckBox() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
    }

    public void selecionarEscolaridadeComboBox() {
        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
        comboEscolaridade = new Select(elemento);
        comboEscolaridade.selectByValue("superior");
    }

    public void validaEscolaridadeComboBox() {
        Assert.assertEquals("Superior", comboEscolaridade.getFirstSelectedOption().getText());
    }

    public void selecionarEsporteComboMultiplo() {
        WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
        comboEsporte = new Select(elemento);
        comboEsporte.selectByValue("Karate");
    }

    public void validaEsporteComboMultiplo() {
        List<WebElement> allSelectOptions = comboEsporte.getAllSelectedOptions();
        Assert.assertEquals(1, allSelectOptions.size());
    }

    public void clicarBotaoCadastrar() {
        botao = driver.findElement(By.id("elementosForm:cadastrar"));
        botao.click();
    }

    public void validarBotaoCadastrar(String mensagem) {
        alert = driver.switchTo().alert();
        Assert.assertEquals(mensagem, alert.getText());
    }

    public void validaRadioButtonNaoSelecionado() {
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isDisplayed());
    }

    public void validaStatusCadastrado() {
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
    }

    public void preencheTodasInformacoes() {
        testeTextField("nome");
        testeTextField("sobrenome");
        testeRadioButton();
        testeCheckBox();
        selecionarEscolaridadeComboBox();
        selecionarEsporteComboMultiplo();
        testeTextArea();
    }

    public void validaTodasInformacoesPreenchidas() {
        validaTextField("nome");
        validaTextField("sobrenome");
        validaRadioButton();
        validaCheckBox();
        validaEscolaridadeComboBox();
        validaEsporteComboMultiplo();
        validaTextArea();
    }

    public void validaInformacoesStatus() {
        Assert.assertEquals("Nome: Senac", driver.findElement(By.id("descNome")).getText());
        Assert.assertEquals("Sobrenome: Senac", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Frango", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Karate", driver.findElement(By.id("descEsportes")).getText());
        Assert.assertEquals("Sugestoes: Teste Trabalho Professora: Angélica", driver.findElement(By.id("descSugestoes")).getText());
    }
}