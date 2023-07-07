package Spring.Boot.service;

import Spring.Boot.entity.Account;
import Spring.Boot.exception.AccountOpeningBanException;
import Spring.Boot.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccount(@PathVariable int id) {
        Account account = accountRepository.findById(id).get();
        if(account==null){
            throw new AccountOpeningBanException("There is no account with ID = "
                    + id + " in Database");
        }
        return account;
    }    @Override


    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(@RequestBody Account account, @PathVariable int id) {
        return accountRepository.save(account);
    }

    @Override
    public String deleteAccount(@PathVariable int id) {
        accountRepository.deleteById(id);
        return "Account with ID = " + id + " was deleted";
    }
}
