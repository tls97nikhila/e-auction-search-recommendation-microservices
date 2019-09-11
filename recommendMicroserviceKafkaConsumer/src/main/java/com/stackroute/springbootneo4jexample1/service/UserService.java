package com.stackroute.springbootneo4jexample1.service;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.RentItems;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.model.WishlistProduct;
import com.stackroute.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }
    public Collection<RentItems> getAllProdcts() { return userRepository.getAllProducts(); }
    public Collection<RentItems> getAllRecm() { return userRepository.getAllRecommendProducts(); }
    public Collection<Category> getAllLikes(){ return userRepository.getAllLikes();}
    public  Collection<WishlistProduct> getMyFavs(){ return userRepository.getMyFavs();}
    public WishlistProduct saveMyFav(WishlistProduct wishlistProduct){
        WishlistProduct savedFav=userRepository.saveMyFav(wishlistProduct.getItemid(),wishlistProduct.getItemName(),wishlistProduct.getItemDescription());
        return savedFav;
    }

    public User saveUser(User user){
        User savedUser=userRepository.save(user);
        return savedUser;
    }

    public Collection<WishlistProduct> deleteWLProductByName(WishlistProduct wishlistProduct){

         userRepository.deleteWLProductByName(wishlistProduct.getItemName());


        return  userRepository.getMyFavs();
    }


}
