package gr.demokritos.relational.services;

import gr.demokritos.dtos.TextDto;
import gr.demokritos.relational.persistence.entities.Text;
import gr.demokritos.relational.persistence.repositories.TextJpaRepository;
import gr.demokritos.relational.utils.Constants;
import gr.demokritos.serviceInterfaces.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class TextJpaService implements TextService {

    @Autowired
    @Qualifier(Constants.RELATIONAL_MAPPER_SERVICE)
    private RelationalMapperService relationalMapperService;

    @Autowired
    private TextJpaRepository repo;

    public TextDto saveText(TextDto textDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(textDto, Text.class)), TextDto.class);
    }

    public TextDto updateText(TextDto textDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(textDto, Text.class)), TextDto.class);
    }

    public void deleteText(TextDto textDto) {
        repo.delete(relationalMapperService.getEntity(textDto, Text.class));
    }

    public TextDto getTextById(Long id) {
        return relationalMapperService.getDto(repo.findById(id), TextDto.class);
    }

    public List<TextDto> getAllTexts() {
        return relationalMapperService.getDtos(repo.findAll(), TextDto.class);
    }
}
