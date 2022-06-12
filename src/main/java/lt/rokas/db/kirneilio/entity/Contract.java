package lt.rokas.db.kirneilio.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    private Reservation reservation;

    @OneToOne(cascade = {CascadeType.ALL})
    private Payment payment;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<LostItem> lostItems;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Equipment> equipmentList;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Sauna> saunaList;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Food> food;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Review> reviews;

    private boolean isSigned;

    @OneToOne(cascade = {CascadeType.ALL})
    private ExtraOrder extraOrder;

    public Contract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<LostItem> getLostItems() {
        return lostItems;
    }

    public void setLostItems(List<LostItem> lostItems) {
        this.lostItems = lostItems;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public ExtraOrder getExtraOrder() {
        return extraOrder;
    }

    public void setExtraOrder(ExtraOrder extraOrder) {
        this.extraOrder = extraOrder;
    }

    public List<Sauna> getSaunaList() {
        return saunaList;
    }

    public void setSaunaList(List<Sauna> saunaList) {
        this.saunaList = saunaList;
    }
}
