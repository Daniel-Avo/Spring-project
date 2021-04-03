package Application.Services;

import Application.Model.Comments;
import Application.Model.Users;
import Application.Repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<Comments> listComments(){
        return commentsRepository.findAll();
    }

    public void addComment(Comments comment) {
        commentsRepository.save(comment);
    }
}
