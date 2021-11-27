import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Parser {
    Document document;
    Elements container;
    Elements name;
    Elements price;
    Elements id;
    Elements description;
    List<String> list = new ArrayList<>();;


    public Parser(String url) throws IOException {
        document = Jsoup.connect(url).get();
    }

    public void getCategory(){
        Element body = document.body();
        Elements categoryContainer = body.getElementsByClass("f-subrubric__container");
        Elements categoryTitle = categoryContainer.select("f-subrubric__title");
        Elements categoryLinks = categoryContainer.select("a[class=f-subrubric__subcategories-link]");
        // ???
        for (Element link : categoryLinks) {
            list.add(link.attr("abs:href"));
        }
        System.out.println(list.toString());

    }

    public void getData(String containerValue,String nameValue,String priceValue, String descriptionValue) throws IOException {
        //ArrayList<Product> products =new ArrayList<>();
        for (String link : list) {
            document = Jsoup.connect(link).get();
        }
        Element body = document.body();
        container = body.getElementsByClass(containerValue);
        name = container.select(nameValue);
        price = container.select(priceValue);
        id = container.select("div[class=img]").select("span[class=product_code]");
        description = container.select(descriptionValue);

        /*for (Element element : name) {
          //System.out.println(element.text());
            Product product = new Product(id.text(),name.text(),price.text(),description.text());
            products.add(product);
        }
         */

        System.out.println(name.text());

    }


}
