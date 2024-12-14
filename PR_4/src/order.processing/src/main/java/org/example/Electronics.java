package org.example;
import lombok.Getter;
import lombok.ToString;

@Getter// поля хоп-хоп мають методи доступа :)
@ToString(callSuper = true) // виводить поля класу + поля продукта
public class Electronics extends Product {
    private String warranty;  //  поле для сохр інфи про гарантію

    // Конструктор з новим полем warranty
    public Electronics(String name, double price, String description) { //при створенні нового об'єкта класу
        super(name, price, description);
        this.warranty = warranty; // ініт нового поля
    }

    // Метод для оновлення гарантії
    public void updateWarranty(String newWarranty) {
        this.warranty = newWarranty; // хош мінять значення полів?...
    }
}
