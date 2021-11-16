import java.util.ArrayList;

public class ProductList {

    private ArrayList<Product> products;

    public ProductList() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public boolean add(Product product) {
        for (Product product1 : products) {
            if (product1.getName().equals(product.getName())) {
                return false;
            }
        }
        products.add(product);
        return true;
    }

    public int getSize() {
        return products.size();
    }

    @Override
    public String toString() {
        return "ProductList{" + System.lineSeparator()
                + products;
    }
}
