package gr.demokritos.relational.services;

import gr.demokritos.commons.dtos.CharacteristicDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.relational.persistence.entities.Characteristic;
import gr.demokritos.relational.persistence.repositories.CharacteristicJpaRepository;
import gr.demokritos.commons.services.CharacteristicService;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicJpaService implements CharacteristicService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private CharacteristicJpaRepository repo;

    public CharacteristicDto saveCharacteristic(CharacteristicDto characteristicDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(characteristicDto, Characteristic.class)), CharacteristicDto.class);
    }

    public CharacteristicDto updateCharacteristic(CharacteristicDto characteristicDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(characteristicDto, Characteristic.class)), CharacteristicDto.class);
    }

    public void deleteCharacteristic(CharacteristicDto characteristicDto) {
        repo.delete(mapperService.getEntity(characteristicDto, Characteristic.class));
    }

    public CharacteristicDto getCharacteristicById(Object id) {
        return mapperService.getDto(repo.findById((Long)id), CharacteristicDto.class);
    }

    public List<CharacteristicDto> getAllCharacteristics() {
        return mapperService.getDtos(repo.findAll(), CharacteristicDto.class);
    }

    public CharacteristicDto getCharacteristicByName(String characteristicName) {
        return mapperService.getDto(repo.findByName(characteristicName), CharacteristicDto.class);
    }

}
