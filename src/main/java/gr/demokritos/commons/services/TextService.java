package gr.demokritos.commons.services;

import gr.demokritos.commons.dtos.TextDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TextService {

    TextDto saveText(TextDto textDto);
    TextDto updateText(TextDto textDto);
    void deleteText(TextDto textDto);
    TextDto getTextById(Long id);
    List<TextDto> getAllTexts();
}
