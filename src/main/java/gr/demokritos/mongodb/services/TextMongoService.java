package gr.demokritos.mongodb.services;

import gr.demokritos.commons.dtos.TextDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.commons.services.TextService;
import gr.demokritos.mongodb.persistence.entities.Text;
import gr.demokritos.mongodb.persistence.repositories.TextMongoRepository;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextMongoService implements TextService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private TextMongoRepository repo;

    @Override
    public TextDto saveText(TextDto textDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(textDto, Text.class)), TextDto.class);
    }

    @Override
    public TextDto updateText(TextDto textDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(textDto, Text.class)), TextDto.class);
    }

    @Override
    public void deleteText(TextDto textDto) {
        repo.delete(mapperService.getEntity(textDto, Text.class));
    }

    @Override
    public TextDto getTextById(Object id) {
        return mapperService.getDto(repo.findById((String)id), TextDto.class);
    }

    @Override
    public List<TextDto> getAllTexts() {
        return mapperService.getDtos(repo.findAll(), TextDto.class);
    }
}
