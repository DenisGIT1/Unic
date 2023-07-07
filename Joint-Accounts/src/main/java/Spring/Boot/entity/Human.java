package Spring.Boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "human")
@Setter
@Getter
@NoArgsConstructor
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "human_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "account_human",
            joinColumns = { @JoinColumn(name = "human_id") },
            inverseJoinColumns = { @JoinColumn(name = "account_id") })
    private Set<Account> accounts = new HashSet<>();

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
        account.getHumans().add(this);
    }

    public void removeAccount(int accountId) {
        Account account = this.accounts.stream().filter(t -> t.getId() == accountId).findFirst().orElse(null);
        if (account != null) {
            this.accounts.remove(account);
            account.getHumans().remove(this);
        }
    }
}