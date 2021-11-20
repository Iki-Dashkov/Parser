import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String url ="https://f.ua/";
        Parser parser = new Parser(url);

        String containerValue = "container";
        String nameValue = "div[class=title]";
        String priceValue = "div[class=price]";
        String descriptionValue = "ul[class=sv]";

        //parser.getData(containerValue,nameValue,priceValue,descriptionValue);
        ProductList list = new ProductList();
        Product product = new Product("11","name1",111,"description");
        Product product2 = new Product("22","name2",222,"description");
        Product product3 = new Product("33","name3",333,"description");
        list.add(product);
        list.add(product2);
        list.add(product3);

        //save to JSON file -> text.json
        FileLoader.saveToJSONFile(list, new File("text.json"));
        //get data from JSON file: text.json ->listFromJSON
        ProductList listFromJSON = FileLoader.loadFromJSONFile(new File("text.json"));
        System.out.println(listFromJSON.toString());

    }
}
