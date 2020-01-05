package eliseeassohoun.miage.psi.api.repository;


import eliseeassohoun.miage.psi.api.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    public List<Message> findAll();
    public Iterable<Message>  findByProfileId(int profileId);
    public Message findByMessageId(int id);
    public Message deleteById(int messageId);
}
