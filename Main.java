import java.util.*;
import java.util.Scanner;
class Product{
    int id;
    String name;
    String type;
    double price;
    public Product(int id, String name, String type, double price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
class ECommerce{
   LinkedList<Product> products = new LinkedList<>();
   Scanner sc = new Scanner(System.in);
   public LinkedList<Product> prod = new LinkedList<>();
    public void Add(Product data){
        prod.add(data);
    }
    public void run(){
        int choice;
        do{
            System.out.printf("|---Enter your choice---|\n1.) Display Products\n2.) Add to cart\n3.) Remove from cart\n4.) Display Cart\n5.) Checkout\n6.) Exit\n");
            choice = sc.nextInt();
            switch(choice){
                case 1: displayProduct(); break;
                case 2: addToCart(); break;
                case 3: removeFromCart(); break;
                case 4: displayCart(); break;
                case 5: checkout(); System.exit(0); break;
                case 6: System.exit(0); break;
                default : System.out.println("Invalid choice! Enter again");
            }
        }while(choice!=5);
    }
    public void displayProduct(){
        System.out.println(" ");
        for(Product item: prod){
            System.out.println(item.id + " - " + item.name + " - $" + item.price);
        }
        System.out.println(" ");
    }
    public void addToCart(){
        System.out.println("Enter the ID of the product to be added: ");
        int iD = sc.nextInt();
        Product result = findProductByID(prod, iD);
        if(result == null){
            System.out.println("Invalid Product ID!");
        }
        products.add(result);
        System.out.println("Product added into cart");
    } 
    public void removeFromCart(){
        System.out.println("Enter the ID of the product to be removed: ");
        int iD = sc.nextInt();
        Product result = findProductByID(products, iD);
        if(result == null){
            System.out.println("This product doesn't exist in the cart");
        }
        int index = Nodecount(result, iD);
        products.remove(index);
    } 
    public Product findProductByID(LinkedList<Product> products, int id){
        for(Product produ: products){
            if(produ.id == id){
                return produ;
            }
        }
        return null;
}
    public void displayCart(){
        double totalCost = 0;
        System.out.println(" ");
        for(Product item: products){
            System.out.println(item.id + " - " + item.name + " - $" + item.price);
            totalCost+=item.price;
        }
        System.out.println("Total price : $" + totalCost);
        System.out.println(" ");
    }
    public void checkout(){
        double totalCost = 0;
        System.out.println(" ");
        for(Product item: products){
            totalCost+=item.price;
        }
        System.out.println("Bill amount : $" + totalCost);
        int transaction;
        System.out.println("How would you like to pay the bill?");
        System.out.println("Press 1 to pay using credit/debit card");
        System.out.println("Press 2 to pay in cash");
        System.out.println("Press 3 to pay through UPI");
        transaction = sc.nextInt();
        if(transaction == 0 || transaction > 3){
            System.out.println("Invalid payment method");
            System.out.println(" ");
            checkout();
        }
        else{
            System.out.println("Payment successful!!");
            System.out.println("Thank You! Visit again :)");
            System.out.println(" ");
        }
        return;
    }
    private int Nodecount(Product product, int id){
        Product head = products.peek();
        int value = 0;
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            if(head.id == product.id)
                return 0;
                Product element = iterator.next();
                value++;
                if(element.id == product.id)
                    return value;
        }
        return -1;
    }
}
public class Main{
    public static void main(String[] args) {
        ECommerce s = new ECommerce();
        s.Add(new Product(1, "Hide & Seek biscuit", "Biscuit", 10));
        s.Add(new Product(2, "Dairy Milk", "Chocolate", 50));
        s.Add(new Product(3, "Coca Cola", "Cool Drinks", 40));
        s.Add(new Product(4, "Dell Laptop", "Laptop", 40000));
        s.Add(new Product(5, "Samsung Phone", "SmartPhone", 35000));
        s.Add(new Product(6, "Prestige Cooker", "Cooker", 2000));
        s.run();
    }
}