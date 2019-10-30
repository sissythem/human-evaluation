package gr.demokritos.serviceInterfaces;

import gr.demokritos.dtos.CharacteristicDto;

import java.util.List;

public interface CharacteristicService {

    CharacteristicDto saveCharacteristic(CharacteristicDto characteristicDto);
    CharacteristicDto updateCharacteristic(CharacteristicDto characteristicDto);
    void deleteCharacteristic(CharacteristicDto characteristicDto);
    CharacteristicDto getCharacteristicById(Long id);
    List<CharacteristicDto> getAllCharacteristics();
    CharacteristicDto getCharacteristicByName(String characteristicName);
}
