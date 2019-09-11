package com.stackroute.springbootneo4jexample1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentItems {

    @Id
    @JsonProperty("itemid")
    private Long itemid;
    @JsonProperty("itemName")
    private String itemName;
    @JsonProperty("itemDescription")
    private String itemDescription;
    //private String owner;

}
