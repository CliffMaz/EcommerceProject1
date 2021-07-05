package com.example.ecommerceapp;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.repo.CartRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ShoppingCartTest {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void  testAddOneCartItem(){
       Product product= entityManager.find(Product.class, 5 );
        User u=entityManager.find(User.class,2);


        Cart item=new Cart();
        item.setProduct(product);
        item.setUser(u);
        item.setQuantity(1);

      Cart savedItem=  cartRepo.save(item);
      assertTrue(savedItem.getCart_id()>0);


    }

    private void assertTrue(boolean b) {
    }

    @Test
    public void testGetCartItem(){
        User u=new User();
        u.setUserId(1);

      List<Cart> items= cartRepo.findByUser(u);
      assertEquals(3, items.size());
    }
}
