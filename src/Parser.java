import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    Document document;
    Elements container;
    Elements name;
    Elements price;
    Elements id;
    Elements description;


    public Parser(String url) throws IOException {
        document = Jsoup.connect(url).get();
    }

    public void getCategory(){
        // #categories .sub-menu-item .sub-menu-link
        Elements category = document.select("#categories");
        System.out.println(category.toString());
    }

    public void getData(String containerValue,String nameValue,String priceValue, String descriptionValue) {
        //ArrayList<Product> products =new ArrayList<>();
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

        //System.out.println(products.toString());

    }


}
