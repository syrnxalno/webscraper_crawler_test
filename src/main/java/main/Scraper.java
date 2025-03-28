package main;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.util.*;
import data.Product;

public class Scraper{
	public static void main(String args[]) {
		Document doc;
		
		try {
			doc = Jsoup.connect("https://www.scrapingcourse.com/ecommerce/")
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
					.header("Accept-Language","*")
					.get();
			Elements productEle = doc.select("li.product");
			List<Product> products = new ArrayList<>();
			System.out.println("Page Title :"+doc.title());
			for(Element productElement : productEle) {
				Product p = new Product();
				p.setUrl(productElement.select("a").attr("href"));
				p.setPrice(productElement.select("span").text());
				p.setName(productElement.select("h2").text());
				p.setImage(productElement.select("img").attr("src"));
				
				products.add(p);
				products.toString();
				System.out.println(products);
			}
		}
		catch(IOException e){
			throw new RuntimeException(e);
		}
	}
}