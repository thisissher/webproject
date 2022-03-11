package org.generation.webproject;

import org.generation.webproject.controller.*;
import org.generation.webproject.service.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemControllerTest {

    /*Create the instance object (1) the dependent object - ItemService (2) Own object -
    ItemController

    1) We wanted to do a unit testing for ItemController object - e.g. test the methods
     from the ItemController. (getItems, findItemById, delete methods)

     2) We need to determine which object that ItemController object depend on
     (ItemService Object) - Mock the ItemService Object - creating the ItemService
     Object with access to all it's methods so that I can use in this test for
     verification

     Mockito.verify method : used to check that certain action takes place, used for
     the testing methods code to make sure that specified methods are called
     */

    ItemController itemController;
    ItemService itemService;

    @BeforeAll
    public void setup() {
        //Mockito.mock method : create a mock object of a class or an interface, able to
        // use its methods to perform verification for our testing object (ItemController)
        itemService = Mockito.mock(ItemService.class);
        itemController = new ItemController(itemService);
    }

    @Test
    public void listItemService()
    {
        Mockito.reset(itemService);
        itemController.getItems();
        Mockito.verify(itemService).all();
    }

    @Test
    public void findItemService()
    {
        Mockito.reset(itemService);
        int id = 34;
        itemController.findItemById(id);
        Mockito.verify(itemService).findById(id);
    }

    @Test
    public void deleteItemService()
    {
        Mockito.reset(itemService);
        int id = 34;
        itemController.delete(id);
        Mockito.verify(itemService).delete(id);
    }
}
