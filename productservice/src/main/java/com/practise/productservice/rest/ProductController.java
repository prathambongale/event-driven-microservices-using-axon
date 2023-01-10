package com.practise.productservice.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.axonframework.commandhandling.gateway.CommandGateway;
import com.practise.productservice.command.CreateProductCommand;

/**
 * ProductController
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand
                .builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String returnValue;
        
        try {
            // send and wait command will send and wait the command to exicute
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception exception) {
            returnValue = exception.getLocalizedMessage();
        }
        
        return returnValue;
    }

    @GetMapping
    public String getProduct() {
        return "HTTP GET Handled" + env.getProperty("local.server.port");
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP PUT Handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP DELETE Handled";
    }
}