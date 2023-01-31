package ExercicioFixEnums;

import ExercicioFixEnums.entities.Client;
import ExercicioFixEnums.entities.Order;
import ExercicioFixEnums.entities.OrderItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import ExercicioFixEnums.entities.OrderStatus;
import ExercicioFixEnums.entities.Product;

import java.util.Locale;

public class application {
    public static void main(String[] args) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        
        System.out.print("Email: ");
        String email = sc.nextLine();
        
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        
        Client client = new Client(name, email, birthDate);
        
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
                        
        Order order = new Order(new Date(), status, client);
        
        System.out.print("How many items to this order?: ");
        Integer num = sc.nextInt();
        
        for(int i=0; i<num; i++){
            sc.nextLine();
            System.out.printf("Enter #%d item data: ", i+1);
            System.out.print("\nProduct name: ");
            String productName = sc.nextLine();
            
            System.out.print("Price: ");
            double productPrice = sc.nextDouble();
                        
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            
            order.addItem(orderItem);
        }
        
        System.out.println();
        System.out.println(order);  
        sc.close();
    }
    
}
