package gr.demokritos.dtos;

public class CharacteristicDto extends AbstractDto {
    private String name;
    private String description;
    private String choices;

    public CharacteristicDto() {

    }

    public CharacteristicDto(String name, String description, String choices) {
        this.name = name;
        this.description = description;
        this.choices = choices;
    }

    public CharacteristicDto(Long id, String name, String description,
                             String choices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.choices = choices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "CharacteristicDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", choices='" + choices + '\'' +
                ", id=" + id +
                '}';
    }
}
