package gr.demokritos.dtos;

public class GradeDto extends AbstractDto {

    private CharacteristicDto characteristic;
    private Integer rating;
    private AnnotationDto annotation;

    public GradeDto() {

    }

    public GradeDto(CharacteristicDto characteristic, Integer rating,
                    AnnotationDto annotation) {
        this.characteristic = characteristic;
        this.rating = rating;
        this.annotation = annotation;
    }

    public GradeDto(Long id, CharacteristicDto characteristic, Integer rating,
                    AnnotationDto annotation) {
        this.id = id;
        this.characteristic = characteristic;
        this.rating = rating;
        this.annotation = annotation;
    }

    public CharacteristicDto getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(CharacteristicDto characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public AnnotationDto getAnnotation() {
        return annotation;
    }

    public void setAnnotation(AnnotationDto annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return "GradeDto{" +
                "characteristic=" + characteristic +
                ", rating=" + rating +
                ", annotation=" + annotation +
                ", id=" + id +
                '}';
    }
}
