package Application.Controllers;

import Application.Model.Topics;
import Application.Services.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/forum")
public class TopicsController {

    private final TopicsService topicsService;

    @Autowired
    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }

    @GetMapping
    public String listTopic(Model model){
        model.addAttribute("topics", topicsService.listTopics());
        model.addAttribute("newTopic", new Topics());
        return "forum/forum";
    }

    @PostMapping
    public String addTopic(@Valid @ModelAttribute("newTopic") Topics topic, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "forum/forum";
        }
        topicsService.addTopic(topic);
        System.out.println(topic);
        return "redirect:/forum";
    }
}
