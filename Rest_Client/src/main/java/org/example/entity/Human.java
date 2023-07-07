package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Human {

    private int id;
    private String name;
    private String surname;
    private Set<Account> accounts = new HashSet<>();

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Human(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}