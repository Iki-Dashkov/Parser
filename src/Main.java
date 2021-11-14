import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String url ="https://f.ua/";
        Parser parser = new Parser(url);

        String containerValue = "container";
        String nameValue = "div[class=title]";
        String priceValue = "div[class=price]";
        String descriptionValue = "ul[class=sv]";

        parser.getData(containerValue,nameValue,priceValue,descriptionValue);
    }
}
