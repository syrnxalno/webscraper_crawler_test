//unit test to be written later

package com.example;

import data.Product;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScraperTest {

    @Test
    public void testScrapeProductsReturnsList() {
        // todo : replace with replica
        String testUrl = "https://www.scrapingcourse.com/ecommerce/";
        List<Product> products = Scraper.scrapeProducts(testUrl);

        assertNotNull(products, "Product list should not be null");
        assertFalse(products.isEmpty(), "Product list should not be empty");

        for (Product p : products) {
            // todo : possible stringent validations
            assertNotNull(p.getName(), "Product name should not be null");
            assertNotNull(p.getPrice(), "Product price should not be null");
            assertNotNull(p.getUrl(), "Product URL should not be null");
            assertNotNull(p.getImage(), "Product image should not be null");
        }
    }
}
