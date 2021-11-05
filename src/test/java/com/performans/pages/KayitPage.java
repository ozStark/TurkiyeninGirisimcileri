package com.performans.pages;

import com.performans.utilities.BrowserUtil;
import com.performans.utilities.ConfigurationReader;
import com.performans.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class KayitPage {


    public KayitPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='check-list-item']/h4")
    public List<WebElement> registrationCategoriesTextList;

    @FindBy(xpath = "//div[@class='check-list-item']")
    public List<WebElement> registrationCategoriesBox;

    @FindBy(xpath = "//div[@class='check-list-item selected']/h4")
    public List<WebElement> selectedCategoryAsList;

    @FindBy(xpath = "//div[@class='check-list-item selected']/button")
    public WebElement selectedCategorySecVeDevamEtButton;


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public void navigateToKayitPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    public void selectCategoryByName(String nameOfCategory) {
        List<String> categoryList = BrowserUtil.getAllText(registrationCategoriesTextList);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement category;
        int size = categoryList.size();
        for (int i = 0; i < size; i++) {
            category = registrationCategoriesTextList.get(i);

            if (categoryList.get(i).equalsIgnoreCase(nameOfCategory)) {

                if(i>2) {
                jse.executeScript("arguments[0].scrollIntoView()", category);
                jse.executeScript("window.scrollBy(0,300)");
                }
                //wait.until(ExpectedConditions.elementToBeClickable(category));
                BrowserUtil.waitFor(1);
                category.click();
                wait.until(ExpectedConditions.visibilityOf(selectedCategoryAsList.get(0)));
                size--;
            }

        }
    }


    public boolean verifyCategoryIsSelected(String selectedCategory) {
        boolean isSelected = false;
        if (selectedCategoryAsList.size() != 0 && selectedCategoryAsList.get(0).getText().equals(selectedCategory)) {
            isSelected = true;
        }
        return isSelected;
    }

//    public static void main(String[] args) {
//
//        KayitPage kayitPage = new KayitPage();
//        kayitPage.navigateToKayitPage();
//
//        kayitPage.selectCategoryByName("1512 ile Yola Çıkan Girişimci");
//        BrowserUtil.waitFor(2);
//        System.out.println(kayitPage.verifyCategoryIsSelected("1512 ile Yola Çıkan Girişimci"));
//        Driver.getDriver().quit();
//    }
}
