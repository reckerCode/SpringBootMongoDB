package io.spring.mongo.MongoIntegration.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//We use the annotation @Document to set the
//collection name that will be used by the model
//If the collection doesn't exist, MongoDB will create it
@Getter
@Setter
@Document("groceryitems")
public class GroceryItems {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;

    public GroceryItems(String id, String name, int quantity, String category) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
