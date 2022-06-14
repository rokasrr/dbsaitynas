package lt.rokas.db.kirneilio.utils;

import lt.rokas.db.kirneilio.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ContractPopulatorTest {

    ContractPopulator contractPopulator;

    @BeforeEach
    void setUp() {
        contractPopulator = new ContractPopulator();
    }


    @Test
    void createUserNameTest() {
        String name = "name";
        String email = "email";
        String phone = "phone";
        User user = contractPopulator.createUser(name, email, phone);
        Assert.assertTrue(user.getFirstName().equals(name));

    }

    @Test
    void createUserEmailTest() {
        String name = "name";
        String email = "email";
        String phone = "phone";
        User user = contractPopulator.createUser(name, email, phone);
        Assert.assertTrue(user.getEmail().equals(email));
    }

    @Test
    void createUserPhoneTest() {
        String name = "name";
        String email = "email";
        String phone = "phone";
        User user = contractPopulator.createUser(name, email, phone);
        Assert.assertTrue(user.getPhoneNumber().equals(phone));
    }
}