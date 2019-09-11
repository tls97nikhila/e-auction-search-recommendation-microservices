package com.stackroute.springbootneo4jexample1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    @Id
    @JsonProperty("name")
    private String name;
    @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    private List<RentItems> rentItems;
    public List<RentItems> getRentItems() {
        return rentItems;
    }
}
