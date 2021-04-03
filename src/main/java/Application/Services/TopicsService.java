package Application.Services;

import Application.Model.Topics;
import Application.Repositories.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {

    private final TopicsRepository topicsRepository;

    @Autowired
    public TopicsService(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    public List<Topics> listTopics(){
        return topicsRepository.findAll();
    }

    public void addTopic(Topics topics) {
        topicsRepository.save(topics);
    }

    public String deleteTopic(Long id) {
        topicsRepository.deleteById(id);
        return "Topic deleted successfully";
    }

    public Optional<Topics> findTopicById(Long id){
        return topicsRepository.findById(id);
    }
}
