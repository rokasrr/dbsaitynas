package lt.rokas.db.kirneilio.entity;

import lt.rokas.db.kirneilio.enums.FoodType;

import javax.persistence.*;

/**
 * Food entity class
 */
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private FoodType foodType;

    public Food() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
}

