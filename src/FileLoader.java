import java.io.FileWriter;

public class FileLoader extends Thread{
    @Override
    public void run() {

    }
    public void writeProductList(ProductList productList){
        try(FileWriter writer = new FileWriter("productList.txt", false))
        {
                writer.write(String.valueOf(productList));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
