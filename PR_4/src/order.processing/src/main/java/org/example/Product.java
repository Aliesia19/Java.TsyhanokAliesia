package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter  //методи доступу
@Setter
@AllArgsConstructor
@ToString
public class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price) { // негативний працс
        this(name, price, null);  // описа нема - значення null
    }

    public void updateDescription(String newDescription) { // обнова опису після зміни
        this.description = newDescription;
    }
}
