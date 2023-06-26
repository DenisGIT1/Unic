package mvc;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import mvc.validation.CheckEmail;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Employee {

    @Size(min = 2, message = "name must be min 2 symbols")
    private String name;
    @NotBlank(message = "surname is required field")
    private String surname;
    @Min(value = 0, message="must be greater than 0")
    @Max(value = 150, message="must be less than 150")
    private int age;
    private String profession;
    private Map<String, String> professions;
    private String education;
    private String[] languages;
    @Pattern(regexp = "\\d{1}-\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = "please use pattern X-XXX-XXX-XX-XX")
    private String phoneNumber;
    @CheckEmail
    private String email;

    public Employee(){
        professions = new HashMap<>();
        professions.put("Information Technology", "IT");
        professions.put("Human Resources", "HR");
        professions.put("Blogger", "Blogger");
    }
}