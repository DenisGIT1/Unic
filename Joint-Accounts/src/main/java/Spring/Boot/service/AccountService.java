package Spring.Boot.service;

import Spring.Boot.entity.Account;
import java.util.List;

public interface AccountService {

    public List<Account> findAllAccounts();

    public Account findAccount(int id);

    public Account saveAccount(Account account);

    public Account updateAccount(Account account, int id);

    public String deleteAccount(int id);

}