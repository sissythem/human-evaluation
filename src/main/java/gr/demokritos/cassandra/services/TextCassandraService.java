package gr.demokritos.cassandra.services;

import gr.demokritos.commons.dtos.TextDto;
import gr.demokritos.commons.services.TextService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextCassandraService implements TextService {
    @Override
    public TextDto saveText(TextDto textDto) {
        return null;
    }

    @Override
    public TextDto updateText(TextDto textDto) {
        return null;
    }

    @Override
    public void deleteText(TextDto textDto) {

    }

    @Override
    public TextDto getTextById(Object id) {
        return null;
    }

    @Override
    public List<TextDto> getAllTexts() {
        return null;
    }
}
