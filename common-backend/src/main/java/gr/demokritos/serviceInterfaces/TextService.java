package gr.demokritos.serviceInterfaces;

import gr.demokritos.dtos.TextDto;

import java.util.List;

public interface TextService {

    TextDto saveText(TextDto textDto);
    TextDto updateText(TextDto textDto);
    void deleteText(TextDto textDto);
    TextDto getTextById(Long id);
    List<TextDto> getAllTexts();
}
