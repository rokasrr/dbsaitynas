package lt.rokas.db.kirneilio.entity;

import lt.rokas.db.kirneilio.enums.FoodType;
import lt.rokas.db.kirneilio.enums.SaunaType;

import javax.persistence.*;

@Entity
public class Sauna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private SaunaType type;

    public Sauna() {

    }

    public Sauna(double price, SaunaType type) {
        this.price = price;
        this.type = type;
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

    public SaunaType getType() {
        return type;
    }

    public void setType(SaunaType type) {
        this.type = type;
    }
}
