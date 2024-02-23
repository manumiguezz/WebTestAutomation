package com.solvd.carina.demo.gui.amazon.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonSearchBar extends AbstractUIObject {

    @FindBy(xpath = "//*[@aria-describedby='searchDropdownDescription']")
    private ExtendedWebElement selectCategoryButton;
    @FindBy(xpath = "//*[@id='nav-search-dropdown-card']")
    private List <ExtendedWebElement> categorySelectList;
    @FindBy(css = "input#twotabsearchtextbox")
    private ExtendedWebElement searchInputField;
    @FindBy()
    private List<ExtendedWebElement> searchResultsList;
    @FindBy(css = "input#nav-search-submit-button")
    private ExtendedWebElement searchButton;

    public AmazonSearchBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickSelectCategoryButton () {
        selectCategoryButton.click();
    }

    public void typeSearchInputField (String searchInput) {
        searchInputField.type(searchInput);
    }

    public void clickSearchButton () {
        searchButton.click();
    }

    public List<String> getCategorySelectList (String containingKeys) {
        String category;
        List<String> list = null;

        for (int i = 0; i < categorySelectList.size(); i++) {
            category = categorySelectList.get(i).toString();
            if (category.contains(containingKeys)) {
                list.add(category);
            }
        }

        return list;
    }


}
