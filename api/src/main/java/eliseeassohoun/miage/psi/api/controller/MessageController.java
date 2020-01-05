package eliseeassohoun.miage.psi.api.controller;


import eliseeassohoun.miage.psi.api.model.Message;
import eliseeassohoun.miage.psi.api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping(path="/messages")
public class MessageController{

    @Autowired
    private MessageRepository DaoMessage;

    //Récupérer la liste des messages
    @GetMapping(value = "")
    public List<Message> listeMessages() {
        return  DaoMessage.findAll();
    }

    // Récupérer la liste des messages par profil
    @GetMapping(value="/{profileId}")
    public Iterable<Message> getMessagesById(@PathVariable int profileId){
        return DaoMessage.findByProfileId(profileId);
    }

    //Ajouter un message
    @GetMapping(value="/addMessage")
    public @ResponseBody Message addMessage (/*@RequestParam int id_user ,@RequestParam String contenu,*/ @Valid @RequestBody Message message ) {
        GregorianCalendar c = new GregorianCalendar();
        Message m = new Message();

        m.setProfileId(message.getProfileId());
        m.setContenu(message.getContenu());
        m.setUserId(message.getUserId());
        m.setDate(c.getTime().toString());
        final Message addedMessage =  DaoMessage.save(m);
        return addedMessage;
    }

    //supprimer un message
    @GetMapping(value="/deleteMessage/{messageId}")
    public Message deleteMessageById(@PathVariable int messageId)
    {
        return DaoMessage.deleteById(messageId);
    }

    //modifier un message
    @PutMapping("/updateMessage/{id}")
    public ResponseEntity<Message> updateMessage(@RequestParam int messageId, @PathVariable int id,   @Valid @RequestBody Message message){
        Message m = DaoMessage.findByMessageId(messageId);
        m.setDate(message.getDate());
        m.setContenu(message.getContenu());
        final Message updatedMessage = DaoMessage.save(m);
        return ResponseEntity.ok(updatedMessage);
    }
}

