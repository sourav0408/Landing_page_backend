package com.example.landing_page.controller;

import com.example.landing_page.entity.Item;
import com.example.landing_page.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<Item> saveItem(@RequestParam("name") String name,
                                         @RequestParam("text") String text,
                                         @RequestParam("icon") MultipartFile iconFile) throws IOException {
        // Create the uploads directory if it doesn't exist
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Validate file type (optional)
        if (!iconFile.getContentType().startsWith("image/")) {
            return ResponseEntity.badRequest().body(null); // Bad request if not an image
        }

        // Generate a unique filename using the current timestamp
        String fileName = System.currentTimeMillis() + "_" + iconFile.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Save the image file to the directory
        Files.write(filePath, iconFile.getBytes());

        // Create an Item object and set its properties
        Item item = new Item();
        item.setName(name);
        item.setText(text);
        item.setIcon(fileName); // Save the filename (not the file itself) to the database

        // Save the item using the ItemService
        Item savedItem = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem); // Return created status
    }

    // Get image from image name
    @GetMapping("/image/{fileName}")
    public ResponseEntity<byte[]> fetchImage(@PathVariable("fileName") String fileName) throws IOException {
        // Build the file path
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Check if the file exists
        if (!Files.exists(filePath)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // File not found
        }

        // Read the image file as byte[]
        byte[] image = Files.readAllBytes(filePath);

        // Set the headers for image content type
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", Files.probeContentType(filePath));  // Automatically determine the content type

        // Return the image file in the response
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> fetchImageById(@PathVariable("id") Long id) throws IOException {
        // Retrieve the item from the database
        Item item = itemService.getItemById(id);

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Item not found
        }

        // Get the image file name
        String fileName = item.getIcon();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Check if the file exists
        if (!Files.exists(filePath)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // File not found
        }

        // Read the image file as byte[]
        byte[] image = Files.readAllBytes(filePath);

        // Set the headers for image content type
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", Files.probeContentType(filePath));

        // Return the image file in the response
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    // Get all items
    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems(); // Fetch all items from the service
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Item not found
        }

        itemService.deleteItem(id); // Call the delete method in the service
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 No Content
    }
}

//working
/*
package com.example.landing_page.controller;

import com.example.landing_page.entity.Item;
import com.example.landing_page.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {


    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public Item saveItem(@RequestParam("name") String name,
                         @RequestParam("text") String text,
                         @RequestParam("icon") MultipartFile iconFile) throws IOException {
        // Create the uploads directory if it doesn't exist
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Generate a unique filename using the current timestamp
        String fileName = System.currentTimeMillis() + "_" + iconFile.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Save the image file to the directory
        Files.write(filePath, iconFile.getBytes());

        // Create an Item object and set its properties
        Item item = new Item();
        item.setName(name);
        item.setText(text);
        item.setIcon(fileName); // Save the filename (not the file itself) to the database

        // Save the item using the ItemService
        return itemService.saveItem(item);
    }
//get image from image name
    @GetMapping("/image/{fileName}")
    public ResponseEntity<byte[]> fetchImage(@PathVariable("fileName") String fileName) throws IOException {
        // Build the file path
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Read the image file as byte[]
        byte[] image = Files.readAllBytes(filePath);

        // Set the headers for image content type
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", Files.probeContentType(filePath));  // Automatically determine the content type

        // Return the image file in the response
        System.out.println("Fetching image from: " + filePath.toString());
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }


    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> fetchImageById(@PathVariable("id") Long id) throws IOException {
        // Retrieve the item from the database
        Item item = itemService.getItemById(id);

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Item not found
        }

        // Get the image file name
        String fileName = item.getIcon();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        // Check if the file exists
        if (!Files.exists(filePath)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // File not found
        }

        // Read the image file as byte[]
        byte[] image = Files.readAllBytes(filePath);

        // Set the headers for image content type
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", Files.probeContentType(filePath));

        // Return the image file in the response
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    //get all item
    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems(); // Fetch all items from the service
    }
}*/
