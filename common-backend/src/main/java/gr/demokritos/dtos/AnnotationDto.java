package gr.demokritos.dtos;

public class AnnotationDto extends AbstractDto {

    private UserDto user;
    private TextDto text;

    public AnnotationDto() {

    }

    public AnnotationDto(UserDto user, TextDto text) {
        this.user = user;
        this.text = text;
    }

    public AnnotationDto(Long id, UserDto user, TextDto text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public TextDto getText() {
        return text;
    }

    public void setText(TextDto text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AnnotationDto{" +
                "user=" + user +
                ", text=" + text +
                ", id=" + id +
                '}';
    }
}
