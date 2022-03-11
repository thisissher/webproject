package org.generation.webproject;

import org.generation.webproject.repository.*;
import org.generation.webproject.repository.entity.*;
import org.generation.webproject.service.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemServiceMySQLTest {

    /*
        1) We wanted to test ItemServiceMySQLTest object (methods), e.g. save method -
        takes in an Item object and pass the Item object to the itemRepository object
        for further processing

        2) Dependent object(s) (1) Mock the item object (2) Mock itemRepository object
     */


    // Mocking is done when you invoke methods of a class that has external communication like database calls or rest calls
    //@Mock Annotation is shorthand for the Mockito.mock() method
    @Mock
    ItemRepository itemRepository;

    ItemService itemService;
    Item itemMock;

    @BeforeAll
    public void setup()
    {
        itemService = new ItemServiceMySQL( itemRepository );
        itemMock = Mockito.mock(Item.class);
    }

    @Test
    public void saveCallsItemsRepositorySave()
    {
        Mockito.reset(itemRepository);
        itemService.save(itemMock);                     //To test
        Mockito.verify(itemRepository).save(itemMock);  //To validate
    }
}
