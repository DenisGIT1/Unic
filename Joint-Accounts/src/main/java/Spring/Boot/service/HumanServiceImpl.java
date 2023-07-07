package Spring.Boot.service;

import Spring.Boot.entity.Account;
import Spring.Boot.entity.Human;
import Spring.Boot.exception.AccountOpeningBanException;
import Spring.Boot.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class HumanServiceImpl implements HumanService{


    private final HumanRepository humanRepository;
    @Override
    public List<Human> findAllHumans() {
        return humanRepository.findAll();
    }

    @Override
    public Human findHuman(@PathVariable int id) {
        Human human = humanRepository.findById(id).get();
        if(human==null){
            throw new AccountOpeningBanException("There is no human with ID = "
            + id + " in Database");
        }
        return human;
    }

    @Override
    public Human saveHuman(@RequestBody Human human) {
        return humanRepository.save(human);
    }

    @Override
    public Human updateHuman(@RequestBody Human human, @PathVariable int id) {
        return humanRepository.save(human);
    }

    @Override
    public String deleteHuman(@PathVariable int id) {
        humanRepository.deleteById(id);
        return "Human with ID = " + id + " was deleted";
    }

    @Override
    public Set<Account> getAccountsOfHuman(@PathVariable int id) {
        Human human = humanRepository.findById(id).get();
        if(human==null){
            throw new AccountOpeningBanException("There is no human with ID = "
                    + id + " in Database");
        }
        Set<Account> accounts = human.getAccounts();
        return accounts;
    }
}