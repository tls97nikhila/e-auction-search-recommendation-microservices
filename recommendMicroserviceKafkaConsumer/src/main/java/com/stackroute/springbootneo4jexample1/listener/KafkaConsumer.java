package com.stackroute.springbootneo4jexample1.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
@Service
public class KafkaConsumer {
    @Autowired
    UserRepository userRepository;
       @KafkaListener(topics = "kafka-Example4")
    public void consume(String user) throws IOException {
        System.out.println(user);
        User obj = new ObjectMapper().readValue(user, User.class);
        System.out.println(userRepository.save(obj));
    }
       //public void consume(String user) throws IOException {
//        System.out.println(item);
//        Item obj = new ObjectMapper().readValue(daoUser, Item.class);
//        obj.setPassword(bcryptEncoder.encode(obj.getPassword()));
          // Item item = new Item();
//        item.setItemName(user.setRentItems());
        //   System.out.println(user);
           //item.setItemName(item.getItemName());
//        itemDao.save(item);
           //itemRepository.addItem(item);

}
