package main;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.util.*;
import data.Product;

public class Scraper {

    public static List<Product> scrapeProducts(String url) {
        List<Product> products = new ArrayList<>();
        boolean isPrinted = false;
        while (url != null) {
            try {
                Document doc = Jsoup.connect(url) 
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36") 
                        .header("Accept-Language", "*") 
                        .get();
                if(!isPrinted) {
                System.out.println("Page Title: " + doc.title());
                System.out.println("Crawled Pages: ");
                isPrinted = true;
                }
                System.out.println(doc.title());
                Elements productElements = doc.select("li.product");
                for (Element productElement : productElements) {
                    Product p = new Product();
                    p.setUrl(productElement.select("a").attr("href"));
                    p.setPrice(productElement.select("span").text());
                    p.setName(productElement.select("h2").text());
                    p.setImage(productElement.select("img").attr("src"));

                    products.add(p);
                }
                
                //crawl until pages run out
                Element nextButton = doc.selectFirst("a.next");
                if (nextButton != null) {
                    String nextPageUrl = nextButton.attr("href");
                    if (!nextPageUrl.startsWith("http")) {
                        nextPageUrl = url + nextPageUrl.replaceFirst("^/", "");
                    }
                    url = nextPageUrl; // update URL for next iteration
                } else {
                    url = null; // no more pages, so exit loop
                }

            } catch (IOException e) {
                throw new RuntimeException("Error while fetching data", e);
            }
        }
        
        return products;
    }

    public static void main(String[] args) {
        String startUrl = "https://www.scrapingcourse.com/ecommerce/";
        List<Product> scrapedProducts = scrapeProducts(startUrl);

        System.out.println("Scraped Products:");
        for (Product product : scrapedProducts) {
            System.out.println(product);
        }
    }
}
