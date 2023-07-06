package Spring.Boot.controller;

import Spring.Boot.entity.Account;
import Spring.Boot.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/accounts/findAll")
    public List<Account> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account findAccount(@PathVariable int id) {
        return accountService.findAccount(id);
    }

    @PostMapping("/accounts/save")
    public Account saveAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return account;
    }

    @PutMapping("/accounts/update/{id}")
    public Account updateAccount(@RequestBody Account account, @PathVariable int id) {
        accountService.updateAccount(account, id);
        return account;
    }

    @DeleteMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        return accountService.deleteAccount(id);
    }
}