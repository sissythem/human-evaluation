package gr.demokritos.relational.services;

import gr.demokritos.dtos.CharacteristicDto;
import gr.demokritos.relational.persistence.entities.Characteristic;
import gr.demokritos.relational.persistence.repositories.CharacteristicJpaRepository;
import gr.demokritos.relational.utils.Constants;
import gr.demokritos.serviceInterfaces.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicJpaService implements CharacteristicService {

    @Autowired
    @Qualifier(Constants.RELATIONAL_MAPPER_SERVICE)
    private RelationalMapperService relationalMapperService;

    @Autowired
    private CharacteristicJpaRepository repo;

    public CharacteristicDto saveCharacteristic(CharacteristicDto characteristicDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(characteristicDto, Characteristic.class)), CharacteristicDto.class);
    }

    public CharacteristicDto updateCharacteristic(CharacteristicDto characteristicDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(characteristicDto, Characteristic.class)), CharacteristicDto.class);
    }

    public void deleteCharacteristic(CharacteristicDto characteristicDto) {
        repo.delete(relationalMapperService.getEntity(characteristicDto, Characteristic.class));
    }

    public CharacteristicDto getCharacteristicById(Long id) {
        return relationalMapperService.getDto(repo.findById(id), CharacteristicDto.class);
    }

    public List<CharacteristicDto> getAllCharacteristics() {
        return relationalMapperService.getDtos(repo.findAll(), CharacteristicDto.class);
    }

    public CharacteristicDto getCharacteristicByName(String characteristicName) {
        return relationalMapperService.getDto(repo.findByName(characteristicName), CharacteristicDto.class);
    }

}
