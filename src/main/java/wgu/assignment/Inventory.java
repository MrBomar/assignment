package wgu.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public static Part lookupPart(int partId) {
        int index = -1;
        for (int i = 0; i < allParts.size(); i++) {
            if(partId == allParts.get(i).getId()) {
                index = i;
            };
        }
        return allParts.get(index);
    }

    public static Product lookupProduct(int productId) {
        int index = -1;
        for(int i = 0; i < allProducts.size(); i++) {
            if(productId == allProducts.get(i).getId()) {
                index = i;
            }
        }
        return allProducts.get(index);
    }

    public static ObservableList<Part> lookupPart(String partName) {
        //FIXME - Add logic to return a list result of a string search using partName and allParts
        return allParts;
    }

    public static ObservableList<Product> lookupProduct(String productName) {
        //FIXME - Add logic to return a list result of a sting search using productName and allProducts
        return allProducts;
    }

    public static void updatePart(int index, Part selectedPart) {
        //Step 1 - Delete the old part
        deletePart(lookupPart(selectedPart.getId()));

        //Step 2 - Add the selected part
        addPart(selectedPart);
    }

    public static void updateProduct(int index, Product selectedProduct) {
        //Step 1 - Delete the old part
        deleteProduct(lookupProduct(selectedProduct.getId()));

        //Step 2 - Add the selected product
        addProduct(selectedProduct);
    }

    public static boolean deletePart(Part selectedPart) {
        return getAllParts().remove(selectedPart);
    }

    public static boolean deleteProduct(Product selectedProduct) {
        return getAllProducts().remove(selectedProduct);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
