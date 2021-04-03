package Application.Controllers;

import Application.Model.Topics;
import Application.Model.Users;
import Application.Services.TopicsService;
import Application.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@SessionAttributes("newTopic")
@RequestMapping("/forum")
public class TopicsController {

    private final TopicsService topicsService;
    private final UsersService usersService;

    @Autowired
    public TopicsController(TopicsService topicsService, UsersService usersService) {
        this.topicsService = topicsService;
        this.usersService = usersService;
    }

    @GetMapping
    public String listTopic( Model model) {
        model.addAttribute("topics", topicsService.listTopics());
        return "forum/forum";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteTopic(@PathVariable Long id, Model model) {
        model.addAttribute("message", topicsService.deleteTopic(id));
        return "redirect:/forum";
    }

    @GetMapping("/topic/{id}")
    public String showTopic(@PathVariable Long id, Model model){

        model.addAttribute("topic", topicsService.findTopicById(id));
        return "/forum/topic";
    }

    @GetMapping("topicform")
    public String newTopic(Principal principal, Model model){

        Optional<Users> user = usersService.findByUsername(principal.getName());

        if (user.isPresent()){
            Topics topic = new Topics();
            topic.setUsers(user.get());

            model.addAttribute("newTopic", topic);

            return "/forum/topicform";
        }

        return "/error";
    }


    @PostMapping("topicform")
    public String addTopic(@Valid @ModelAttribute("newTopic") Topics topic, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/forum/topicform";
        }
        topicsService.addTopic(topic);
        return "redirect:/forum";
    }

}
