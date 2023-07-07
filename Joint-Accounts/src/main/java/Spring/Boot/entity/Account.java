package Spring.Boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "account")
@Setter
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;

    @Column(name = "number")
    private int number;

    @ManyToMany(mappedBy = "accounts", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE },
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Human> humans = new HashSet<>();

    public Account(int number) {
        this.number = number;
    }
}