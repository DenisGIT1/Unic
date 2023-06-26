package mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class MyController {

    @RequestMapping("/first")
    public String showFirstView() {
        return "first";
    }

    @RequestMapping("/askForm")
    public String askFormEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "askForm";
    }

    @RequestMapping("/showForm")
    public String showFormEmployee(@Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "askForm";
        } else {
            return "showForm";
        }
    }
}