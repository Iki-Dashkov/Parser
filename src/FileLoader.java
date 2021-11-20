import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;


public class FileLoader extends Thread{
    @Override
    public void run() {

    }
    /*public void writeProductList(ProductList productList){
        try(FileWriter writer = new FileWriter("productList.txt", false))
        {
                writer.write(String.valueOf(productList));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
     */
    public static void saveToJSONFile(ProductList list, File file){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonLine = gson.toJson(list);
        try(PrintWriter printWriter = new PrintWriter(file)){
            printWriter.println(gsonLine);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static ProductList loadFromJSONFile(File file){
        Gson gson = new Gson();
        ProductList productList = null;
        try{
            productList = gson.fromJson(new FileReader(file), ProductList.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return productList;
    }

}
