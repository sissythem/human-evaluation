package gr.demokritos.relational.services;

import gr.demokritos.commons.dtos.TextDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.relational.persistence.entities.Text;
import gr.demokritos.relational.persistence.repositories.TextJpaRepository;
import gr.demokritos.commons.services.TextService;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class TextJpaService implements TextService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private TextJpaRepository repo;

    public TextDto saveText(TextDto textDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(textDto, Text.class)), TextDto.class);
    }

    public TextDto updateText(TextDto textDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(textDto, Text.class)), TextDto.class);
    }

    public void deleteText(TextDto textDto) {
        repo.delete(mapperService.getEntity(textDto, Text.class));
    }

    public TextDto getTextById(Long id) {
        return mapperService.getDto(repo.findById(id), TextDto.class);
    }

    public List<TextDto> getAllTexts() {
        return mapperService.getDtos(repo.findAll(), TextDto.class);
    }
}
