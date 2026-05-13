package Controllers;

import Models.Product;

public class BusquedaBinaria {

    public Product findProductByStock(Product[] products, int clave) {
        int index = findProductIndexByStock(products, clave);
        
        if (index != -1) {
            return products[index];
        }
        return null;
    }
    
    public int findProductIndexByStock(Product[] products, int clave) {
        sortProductByStock(products);

        int bajo = 0;
        int alto = products.length - 1;

        while (bajo <= alto) {
            int centro = bajo + (alto - bajo) / 2; 

            if (products[centro].getStock() == clave) {
                return centro; 
            } else if (products[centro].getStock() > clave) {
                alto = centro - 1; 
            } else {
                bajo = centro + 1; 
            }
        }
        return -1; 
    }

    private void sortProductByStock(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j].getStock() > products[j + 1].getStock()) {
                    Product aux = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = aux;
                }
            }
        }
    }

}