package DesignPattern.ChainOfResponsibility;

public class Message {

    private Integer messageId;

    private String title;

    private String content;

    public Message() {
    }

    public Message(Integer messageId, String title, String content) {
        this.messageId = messageId;
        this.title = title;
        this.content = content;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
