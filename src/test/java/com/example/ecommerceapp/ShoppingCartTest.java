package com.example.ecommerceapp;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.repo.CartRepo;
import com.example.ecommerceapp.service.CartService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public void testAddtoCart(){

        boolean productAvail=false;

        User u=new User();
        u.setUserId(2);
        Cart cart=null;

        List<Cart> items= cartRepo.findByUser(u);
        assertEquals(4, items.size());


        Product product= entityManager.find(Product.class, 9 );
        User user=entityManager.find(User.class,2);


        Cart item=new Cart();
        item.setProduct(product);
        item.setUser(u);
        item.setQuantity(1);
        for(Cart c: items){

            Logger log = LoggerFactory.getLogger(this.getClass());
            log.info("item: "+item.getProduct().getProductId() );

            log.info("dataB: "+c.getProduct().getProductId());
            if(c.getProduct().getProductId().equals(item.getProduct().getProductId())
                    && c.getUser().getUserId().equals(u.getUserId())){

                productAvail=true;
                cart =c;
            }

        }
        if(!productAvail){

            Cart savedItem=  cartRepo.save(item);
            assertTrue(savedItem.getCart_id()>0);
        }else{

            cartRepo.updateQuantityByCartId((cart.getQuantity()+1),cart.getCart_id(),user.getUserId());

        }
    }

    @Test
    public void testUpdateCart(){


    }

    @Test
    public void  testAddOneCartItem(){
       Product product= entityManager.find(Product.class, 9 );
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
        u.setUserId(2);

      List<Cart> items= cartRepo.findByUser(u);
      assertEquals(4, items.size());
    }
}
