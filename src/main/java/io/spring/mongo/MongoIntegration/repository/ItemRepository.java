package io.spring.mongo.MongoIntegration.repository;

import io.spring.mongo.MongoIntegration.model.GroceryItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The API implementation happens in the repository.
 * It acts as a link between the model and the database,
 * and has all the method of CRUD operations.
 */


//We first create an ItemRepository public interface which extends
//the MongoRepository interface
@Repository
public interface ItemRepository extends MongoRepository<GroceryItems, String> {

    //Requires a parameter for the query, i.e., the field to filter
    //the query by
    @Query("{name:'?0'}")
    GroceryItems findItemByName(String name);

    @Query(value = "{name:'?0'}", fields = "{'name':1, 'quantity':1}")
    List<GroceryItems> findAll(String category);

    public long count();
}
