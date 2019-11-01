package gr.demokritos.cassandra.services;

import gr.demokritos.commons.dtos.CharacteristicDto;
import gr.demokritos.commons.services.CharacteristicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicCassandraService implements CharacteristicService {
    @Override
    public CharacteristicDto saveCharacteristic(CharacteristicDto characteristicDto) {
        return null;
    }

    @Override
    public CharacteristicDto updateCharacteristic(CharacteristicDto characteristicDto) {
        return null;
    }

    @Override
    public void deleteCharacteristic(CharacteristicDto characteristicDto) {

    }

    @Override
    public CharacteristicDto getCharacteristicById(Object id) {
        return null;
    }

    @Override
    public List<CharacteristicDto> getAllCharacteristics() {
        return null;
    }

    @Override
    public CharacteristicDto getCharacteristicByName(String characteristicName) {
        return null;
    }
}
