# webscraper_crawler_test
- Java-based web scraper built with JSoup to extract product details (name, price, image URL, and product URL) from <a href="https://www.scrapingcourse.com/ecommerce/">test site</a>.
- Crawls pagination elements
- Intended solely for educational purposes

## Setup
1. Clone the Repository
```sh
git clone https://github.com/syrnxalno/webscraper_crawler_test.git
cd webscraper_crawler_test
```
2. Clean setup using Maven
```sh
mvn clean package
```
2. Run the scraper
```sh
java -cp target/webscraper_crawler_test.jar main.Scraper
```
or use Maven
```sh
mvn exec:java -Dexec.mainClass="main.Scraper"
```
3. Troubleshoot
```sh
mvn clean install
```
for missing dependencies

