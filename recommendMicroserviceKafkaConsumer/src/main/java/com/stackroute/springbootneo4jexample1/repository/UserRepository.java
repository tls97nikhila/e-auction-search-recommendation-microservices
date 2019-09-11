package com.stackroute.springbootneo4jexample1.repository;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.RentItems;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.model.WishlistProduct;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("MATCH (p:Product) RETURN p")
    Collection<RentItems> getAllProducts();

    @Query("MERGE (u:User {userEmail : {userEmail} , userEmail : {userEmail} , category : {category} , products : {products }) return u")
    User saveUser(@Param("userEmail") String userEmail, @Param("userName")String userName, @Param("category") List<String> category,@Param("products") List<RentItems> rentItems);

    @Query(" MATCH (u:User {name:'Nikhila'})-[:LIKES]->(c:Category) return c")
    Collection<Category> getAllLikes();
   // @Query("Create (u:User {name: {name}, emailid)")

    @Query("MATCH (u:User {name:'Pranee'})-[:LIKES]->(:Category)<-[:BELONGS_TO]-(p:Product) RETURN p")
    Collection<RentItems> getAllRecommendProducts();

    @Query("MERGE (n:WishlistProduct { id: {id}, name: {name}, des:{des} })")
    WishlistProduct saveMyFav(@Param("id") Long id, @Param("name")String name, @Param("des") String des);

    @Query("MATCH (p:WishlistProduct) RETURN p")
    Collection<WishlistProduct> getMyFavs();

    @Query("Match (p:WishlistProduct {name : {name}}) detach delete p")
    Collection<WishlistProduct> deleteWLProductByName(@Param("name") String name);







}