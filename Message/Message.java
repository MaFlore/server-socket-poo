package Message;

import java.io.Serializable;

//must implement Serializable in order to be sent
public class Message implements Serializable{
 private static final long serialVersionUID = 1L;
private final String text;

 public Message(String text) {
     this.text = text;
 }

 public String getText() {
     return text;
 }
}