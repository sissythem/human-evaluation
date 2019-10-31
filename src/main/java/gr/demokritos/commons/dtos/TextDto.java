package gr.demokritos.commons.dtos;

public class TextDto extends AbstractDto {

    private String content;

    public TextDto() {

    }

    public TextDto(String content) {
        this.content = content;
    }

    public TextDto(Long id, String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextDto{" +
                "content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
