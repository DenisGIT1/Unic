package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    private int id;
    private int number;
    private Set<Human> humans = new HashSet<>();

}