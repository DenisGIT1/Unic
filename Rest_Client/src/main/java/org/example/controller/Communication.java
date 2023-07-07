package org.example.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.entity.Human;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Communication {

    private RestTemplate restTemplate = new RestTemplate();
    private final String URL = "http://localhost:8080/humans";

    public List<Human> getAllHuman(){

        ResponseEntity<List<Human>> responseEntity =
                restTemplate.exchange(URL + "/findAll", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Human>>() {});
        List<Human> humans = responseEntity.getBody();
        return humans;
    }

    public Human getHuman(int id){

        Human human = restTemplate.getForObject(URL + "/" + id, Human.class);
        return  human;
    }

    public void saveHuman(Human human){
        int id = human.getId();
        if(id == 0){
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL + "/save", human, String.class);
            System.out.println("New human was added in DB");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URL + "/update/" + id, human);
            System.out.println("Human with ID " + id + " was updated");
        }
    }

    public void deleteHuman(int id) {
        restTemplate.delete(URL + "/delete/" + id);
        System.out.println("Human with ID " + id + " was deleted");
    }
}