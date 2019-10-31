package gr.demokritos.commons.services;

import gr.demokritos.commons.dtos.CharacteristicDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacteristicService {

    CharacteristicDto saveCharacteristic(CharacteristicDto characteristicDto);
    CharacteristicDto updateCharacteristic(CharacteristicDto characteristicDto);
    void deleteCharacteristic(CharacteristicDto characteristicDto);
    CharacteristicDto getCharacteristicById(Long id);
    List<CharacteristicDto> getAllCharacteristics();
    CharacteristicDto getCharacteristicByName(String characteristicName);
}
