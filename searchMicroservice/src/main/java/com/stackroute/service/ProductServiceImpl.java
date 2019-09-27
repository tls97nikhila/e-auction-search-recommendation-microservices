package com.stackroute.service;

import com.stackroute.domain.Items;
import com.stackroute.domain.RentItems;
import com.stackroute.domain.User;
import com.stackroute.exception.ProductNotFoundException;
import com.stackroute.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Override
    public User saveUser(User user) {
        return productRepository.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return productRepository.findAll();
    }


    @Override
    public List<RentItems> getProductByName(String name) throws ProductNotFoundException {
        List<User> users = productRepository.getProductByName(name);
        List<RentItems> items = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {

//             System.out.println(users.get(i).getRentItems().toString());
            List<RentItems> rentItems = new ArrayList<>();
            rentItems=users.get(i).getRentItems();

            for(int j=0;j<rentItems.size();j++)
            {
                RentItems rentItem=rentItems.get(j);
                if(rentItem.getItemName().equals(name))
                {
                    items.add(rentItem);
                }
                System.out.println("rentItem");
                System.out.println(rentItem);
            }
            System.out.println("rentItems");
            System.out.println(rentItems);
         }
//            System.out.println(user);
//            if (user.isEmpty()) {
//                throw new ProductNotFoundException("Product not found");
//            }
        System.out.println(".............................");
        System.out.println(name);
            System.out.println(items.toString());
//            return product;


        return items;
    }
}

