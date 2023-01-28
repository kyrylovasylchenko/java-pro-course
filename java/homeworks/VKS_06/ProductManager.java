package homeworks.VKS_06;


import java.util.*;
import java.util.stream.Collectors;



public class ProductManager {
   private final List<Product> productsContainer = new ArrayList<>();

    public void add(Product product){
        productsContainer.add(product);
    }

    public List<Product> findBook(){
        return productsContainer.stream()
                .filter(o1 -> o1.getType().equalsIgnoreCase("book") && o1.getPrice() > 250)
                .toList();
    }


    public List<Product> findDiscountBook(){
        return productsContainer.stream()
                .filter(o1 -> o1.getType().equalsIgnoreCase("book") && o1.isDiscount())
                .peek(o1 -> o1.setPrice(o1.getPrice() - (o1.getPrice()*10/100)))
                .toList();
    }

    public Product findCheapestBook(){
        return productsContainer.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new ProductNotFoundException("Book not found"));
    }

    public List<Product> findLastAddedProduct(){
        return productsContainer.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Product::getCreateDate)))
                .limit(3).toList();
    }

    public Double countPriceBooks(){
        return productsContainer.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book") && product.getCreateDate().getYear() == 2023
                        && product.getPrice() < 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String,List<Product>> sortProductByType(){
        return productsContainer.stream().collect(Collectors.groupingBy(Product::getType));
    }





}
