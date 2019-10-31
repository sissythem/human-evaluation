package gr.demokritos.mongodb.services;

import gr.demokritos.commons.dtos.CharacteristicDto;
import gr.demokritos.commons.services.CharacteristicService;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.mongodb.persistence.entities.Characteristic;
import gr.demokritos.mongodb.persistence.repositories.CharacteristicMongoRepository;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacteristicMongoService implements CharacteristicService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private CharacteristicMongoRepository repo;

    @Override
    public CharacteristicDto saveCharacteristic(CharacteristicDto characteristicDto) {
        return mapperService.convertMongoCharacteristic(repo.save(mapperService.convertDtoToMongoCharacteristic(characteristicDto)));
    }

    @Override
    public CharacteristicDto updateCharacteristic(CharacteristicDto characteristicDto) {
        return mapperService.convertMongoCharacteristic(repo.save(mapperService.convertDtoToMongoCharacteristic(characteristicDto)));
    }

    @Override
    public void deleteCharacteristic(CharacteristicDto characteristicDto) {
        repo.delete(mapperService.convertDtoToMongoCharacteristic(characteristicDto));
    }

    @Override
    public CharacteristicDto getCharacteristicById(Object id) {
        Optional<Characteristic> optionalCharacteristic = repo.findById((String) id);
        if (optionalCharacteristic.isPresent()) {
            Characteristic characteristic = optionalCharacteristic.get();
            return mapperService.convertMongoCharacteristic(characteristic);
        }
        return null;
    }

    @Override
    public List<CharacteristicDto> getAllCharacteristics() {
        return mapperService.convertMongoCharacteristics(repo.findAll());
    }

    @Override
    public CharacteristicDto getCharacteristicByName(String characteristicName) {
        return mapperService.convertMongoCharacteristic(repo.findByName(characteristicName));
    }
}
