package com.company.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.company.project.base.BasePage;

public class SearchResultsPage extends BasePage {

    // Represents each individual product card on the search results page
    private By productCards =
            By.cssSelector("[data-component-type='s-search-result']");

    // Represents the product name INSIDE a product card
    private By productName =
            By.cssSelector("h2 span");

    // Represents the product price INSIDE a product card
    private By productPrice =
            By.cssSelector(".a-price-whole");


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    // Returns the total number of product cards displayed
    public int getProductCount() {

        List<WebElement> products =
                driver.findElements(productCards);

        return products.size();
    }


    // Returns the names of all products displayed on the page
    public List<String> getProductNames() {

        List<WebElement> products =
                driver.findElements(productCards);

        return products.stream()
                .map(product -> product.findElement(productName).getText())
                // .map(WebElement::getText)
                .toList();
    }


    // Returns the price of a specific product
    public String getProductPrice(String productNameToFind) {

        List<WebElement> products =
                driver.findElements(productCards);

        for (WebElement product : products) {

            // Find the name inside the current product card
            String name =
                    product.findElement(productName).getText();

            // Check whether this is the product we are looking for
            if (name.equalsIgnoreCase(productNameToFind)) {

                // Find the price inside the SAME product card
                return product.findElement(productPrice).getText();
            }
        }

        throw new RuntimeException(
                "Product not found: " + productNameToFind
        );
    }

  
    
    
 // Finds the matching product, clicks it, and handles both same-tab and new-tab navigation.
    public void selectProduct(String productNameToFind) {

        String originalWindow = driver.getWindowHandle();
        int originalWindowCount = driver.getWindowHandles().size();

        List<WebElement> products =
                driver.findElements(productCards);

        for (WebElement product : products) {

            String name =
                    product.findElement(productName).getText();

            if (name.equalsIgnoreCase(productNameToFind)) {

                // Click the product link, not only the title span.
                WebElement productLink =
                        product.findElement(By.xpath(".//h2/ancestor::a[1] | .//h2//a[1]"));

                productLink.click();

                // Amazon may open the product in a new tab or in the same tab.
                wait.until(currentDriver ->
                        currentDriver.getWindowHandles().size() > originalWindowCount
                                || currentDriver.getCurrentUrl().contains("/dp/")
                                || currentDriver.getCurrentUrl().contains("/gp/product/")
                );

                // If a new tab opened, switch to it.
                if (driver.getWindowHandles().size() > originalWindowCount) {
                    switchToNewWindow(originalWindow);

                return;
            }
        }

        throw new RuntimeException(
                "Product not found: " + productNameToFind
        );
    }
    
    }
}
