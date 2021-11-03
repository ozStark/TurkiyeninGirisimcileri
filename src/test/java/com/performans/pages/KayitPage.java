package com.performans.pages;

import com.performans.utilities.BrowserUtil;
import com.performans.utilities.ConfigurationReader;
import com.performans.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class KayitPage {


    public KayitPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='check-list-item']/h4")
    public List<WebElement> registrationCategoriesTextList;

    @FindBy(xpath = "//div[@class='check-list-item']")
    public List<WebElement> registrationCategoriesBox;

    @FindBy(xpath = "//div[@class='check-list-item selected']")
    public WebElement selectedCategory;

    @FindBy(xpath = "//div[@class='check-list-item selected']/button")
    public WebElement selectedCategoryButton;

    public final String firstCategory = registrationCategoriesTextList.get(0).getText();
    String secondCategory = registrationCategoriesTextList.get(1).getText();
    String thirdCategory = registrationCategoriesTextList.get(2).getText();
    String fourthCategory = registrationCategoriesTextList.get(3).getText();
    String fifthCategory = registrationCategoriesTextList.get(4).getText();

    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public void navigateToKayitPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    public void selectCategoryByName(String nameOfCategory){
        List<String> categoryList = BrowserUtil.getAllText(registrationCategoriesTextList);
        JavascriptExecutor jse =(JavascriptExecutor)Driver.getDriver();
        WebElement category;
        for (int i = 0; i < categoryList.size(); i++) {
            category = registrationCategoriesBox.get(i);
            if(categoryList.get(i).equals(nameOfCategory)){
                //jse.executeScript("arguments[0].scrollIntoView(true);", category);
                actions.moveToElement(category).perform();
                wait.until(ExpectedConditions.elementToBeClickable(category));
                category.click();
                break;
            }
        }
    }




    public boolean verifyCategoryIsSelected(){

        return false;
    }


}
