package com.performans.step_definitions;

import com.performans.pages.KayitPage;
import com.performans.utilities.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KayitPageStepDefs {

    KayitPage kayitPage = new KayitPage();

    @Given("User is at the kayit page")
    public void user_is_at_the_kayit_page() {
        kayitPage.navigateToKayitPage();
    }

    @Then("User should see five registration categories")
    public void user_should_see_five_registration_categories(List<String> expectedCategoriesList) {

        List<String> actualCategoriesList = BrowserUtil.getAllText(kayitPage.registrationCategoriesTextList);
        assertEquals(expectedCategoriesList, actualCategoriesList);

    }

    @When("User clicks any {string}")
    public void user_clicks_any(String categoryName) {
        kayitPage.selectCategoryByName(categoryName);
        BrowserUtil.waitFor(3);
    }
    @Then("The category is selected and SEÇ VE DEVAM ET button is visible")
    public void the_category_is_selected_and_seç_ve_devam_et_button_is_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
