package com.agile.shoppingcart;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void addItem_singleItem_containsSingleItem() {
        //arrange

        Item apple = ItemMother.apple();
        //act
        shoppingCart.addItem(apple);
        //assert
        assertTrue(shoppingCart.containsItem(apple));

    }

     @Test
    public void addItem_multipleItem_containsMultipleItems() {
        //arrange
    
        Item apple = ItemMother.apple();
        Item banana = ItemMother.banana();
        //act
        shoppingCart.addItem(apple);
        shoppingCart.addItem(banana);
        //assert
        assertTrue(shoppingCart.containsItem(apple) && shoppingCart.containsItem(banana));

    }

    @Test
    public void removeItem_removeApple_containsBanana() {
        //arrange

        Item apple = new Item("apple", 1.00, 1);
        Item banana = new Item("banana", 0.50, 1);
        shoppingCart.addItem(apple);
        shoppingCart.addItem(banana);
        //act
        shoppingCart.removeItem(apple);
        //assert
        assertTrue(!shoppingCart.containsItem(apple) && shoppingCart.containsItem(banana));

    }

    @Test
    public void removeItem_removeInvalidItem_cartUnchanged() {
        //arrange

        Item apple = new Item("apple", 1.00, 1);
        Item banana = new Item("banana", 0.50, 1);
        shoppingCart.addItem(apple);
        //act
        shoppingCart.removeItem(banana);
        //assert
        assertTrue(shoppingCart.containsItem(apple));

    }
    
    @Test
    public void calculateTotal_appleAndBanana_returnsTotal() {
        //arrange

        Item apple = new Item("apple", 1.00, 1);
        Item banana = new Item("banana", 0.50, 1);
        shoppingCart.addItem(apple);
        shoppingCart.addItem(banana);
        double expected = 1.50;
        //act
        double actual = shoppingCart.calculateTotal();
        //assert
        assertEquals(expected, actual, 0.001);

    }

    @Test
    public void calculateTotal_noItems_returnsTotal() {
        //arrange

        double expected = 0.00;
        //act
        double actual = shoppingCart.calculateTotal();
        //assert
        assertEquals(expected, actual, 0.001);

    }

    @Test
    public void addItem_twoApples_updatesQuantity() {
        //arrange

        Item apple = new Item("apple", 1.00, 1);
    
  
        //act
        shoppingCart.addItem(apple);
        shoppingCart.addItem(apple);

        //assert
        assertTrue(shoppingCart.getItemQuantity(apple) == 2);

    }

    @Test
    public void setItemQuantity_setQuantityToThree_updatesQuantity() {
        //arrange

        Item apple = new Item("apple", 1.00, 1);
        shoppingCart.addItem(apple);
  
        //act
        shoppingCart.setItemQuantity(apple, 3);;
        

        //assert
        assertTrue(shoppingCart.getItemQuantity(apple) == 3);

    }

    @Test
    public void removeItem_removeFromEmptyCart_cartUnchanged() {
        //arrange

        Item apple = new Item("apple", 1.00, 1);
        //act
        shoppingCart.removeItem(apple);
        //assert
        assertTrue(!shoppingCart.containsItem(apple));

    }

    @Test
    public void calculateTotal_emptyCart_returnsZero() {
        //arrange

        double expected = 0.00;
        //act
        double actual = shoppingCart.calculateTotal();
        //assert
        assertEquals(expected, actual, 0.00);
    }
}



