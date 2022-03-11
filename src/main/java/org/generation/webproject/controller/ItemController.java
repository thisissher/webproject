package org.generation.webproject.controller;


import org.generation.webproject.component.*;
import org.generation.webproject.controller.dto.*;
import org.generation.webproject.repository.entity.Item;
import org.generation.webproject.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Value("${image.folder}")
    private String imageFolder;

    //Mapping the API calls from the client to the respective methods (endpoint) to
    // handle the HTTP request call (GET, POST, DELETE, PUT)

    //How to handle the HTTP request from the client - Controller Class Object is
    // dependent on ItemServiceMySQL Class object (Dependency Injection)

    private final ItemService itemService;

    public ItemController(@Autowired ItemService itemService)
    {
        this.itemService = itemService;
    }

    //1 Client send a GET HTTP request to the Controller through the REST API
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }


    //2 Client send a GET HTTP request with the item ID to the Controller
    //CORS - Cross-origin resource sharing
    @CrossOrigin
    @GetMapping("/{id}")
    public Item  findItemById(@PathVariable Integer id)
    {
        return itemService.findById( id );
    }

    //3 Client send a DELETE HTTP request with the item ID
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id)
    {
        itemService.delete(id);
    }

    //4 Client send a POST HTTP request with all the item data (name, description, image
    // filename, style, price, image object)
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="name", required = true) String name,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="imageUrl", required = true) String imageUrl,
                       @RequestParam(name="style", required = true) String style,
                       @RequestParam(name="price", required = true) double price,
                       @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {

        //Part 1: provide the ability to save the image file into the directory in the
        // Server
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        //Part 2: Other data (name, description, ...) store into the database
        //productimages/images/t-shirt_new.jpeg
        String fullPath = imageFolder + '/' + imageUrl;

        //Create an instance object of the ItemDTO (Data Transfer Object) to store all
        // the data that is sent from the Client
        ItemDTO itemDto = new ItemDTO(name, description, fullPath, style, price);
        itemService.save(new Item(itemDto));
    }



}
