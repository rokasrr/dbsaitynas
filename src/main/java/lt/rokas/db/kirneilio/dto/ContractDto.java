package lt.rokas.db.kirneilio.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Contract DTO class
 */
public class ContractDto {
    String firstName;
    String email;
    String phone;
    String comments;
    String extraOrder;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date exitDate;
    boolean boat;
    boolean food;
    boolean sheets;
    boolean tennis;
    boolean sauna;
    boolean hotTub;
    private Long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String password) {
        this.comments = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public boolean isBoat() {
        return boat;
    }

    public void setBoat(boolean boat) {
        this.boat = boat;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isSheets() {
        return sheets;
    }

    public void setSheets(boolean sheets) {
        this.sheets = sheets;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isTennis() {
        return tennis;
    }

    public void setTennis(boolean tennis) {
        this.tennis = tennis;
    }

    public boolean isSauna() {
        return sauna;
    }

    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }

    public boolean isHotTub() {
        return hotTub;
    }

    public void setHotTub(boolean hotTub) {
        this.hotTub = hotTub;
    }

    public String getExtraOrder() {
        return extraOrder;
    }

    public void setExtraOrder(String extraOrder) {
        this.extraOrder = extraOrder;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
