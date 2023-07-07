package Spring.Boot.service;

import Spring.Boot.entity.Account;
import Spring.Boot.entity.Human;

import java.util.List;
import java.util.Set;

public interface HumanService {

    public List<Human> findAllHumans();

    public Human findHuman(int id);

    public Human saveHuman(Human human);

    public Human updateHuman(Human human, int id);

    public String deleteHuman(int id);

    public Set<Account> getAccountsOfHuman(int id);

}