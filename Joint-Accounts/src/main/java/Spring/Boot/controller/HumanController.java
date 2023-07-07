package Spring.Boot.controller;

import Spring.Boot.entity.Account;
import Spring.Boot.entity.Human;
import Spring.Boot.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HumanController {


    private final HumanService humanService;


    @GetMapping("/humans/findAll")
    public List<Human> findAllHumans() {
        return humanService.findAllHumans();
    }

    @GetMapping("/humans/{id}")
    public Human findHuman(@PathVariable int id) {
        return humanService.findHuman(id);
    }

    @PostMapping("/humans/save")
    public Human saveHuman(@RequestBody Human human) {

        return humanService.saveHuman(human);
    }

    @PutMapping("/humans/update/{id}")
    public Human updateHuman(@RequestBody Human human, @PathVariable int id) {
        return humanService.updateHuman(human, id);
    }

    @DeleteMapping("/humans/delete/{id}")
    public String deleteHuman(@PathVariable int id) {

        return humanService.deleteHuman(id);
    }

    @GetMapping("/humans/getAccounts/{id}")
    @ResponseBody
    public Set<Account> getAccountsOfHuman(@PathVariable int id) {
        return humanService.getAccountsOfHuman(id);
    }

}