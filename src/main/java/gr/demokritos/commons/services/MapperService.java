package gr.demokritos.commons.services;

import gr.demokritos.commons.dtos.CharacteristicDto;
import gr.demokritos.mongodb.persistence.entities.Characteristic;
import gr.demokritos.mongodb.persistence.entities.Choice;
import gr.demokritos.utils.RelationalConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(RelationalConstants.MAPPER_SERVICE)
public class MapperService {

    @Autowired
    @Qualifier(RelationalConstants.MODEL_MAPPER)
    private ModelMapper modelMapper;

    public <T,S> List<T> getDtos(List<S> entities, Class<T> dtoClass) {
        return getObjectList(entities, dtoClass);
    }

    public <T,S> List<T> getEntities(List<S> dtos, Class<T> entityClass) {
        return getObjectList(dtos, entityClass);
    }

    public <T, S> T getDto(S entity, Class<T> dtoClass) {
        return getMappedObject(entity, dtoClass);
    }

    public <T, S> T getEntity(S dto, Class<T> entityClass) {
        return getMappedObject(dto, entityClass);
    }

    private <T,S> List<T> getObjectList(List<S> initialList, Class<T> mappingClass) {
        if(CollectionUtils.isEmpty(initialList)) return null;
        List<T> finalList = new ArrayList<>();
        initialList.forEach(initialObject-> {
            T finalObject = getMappedObject(initialObject, mappingClass);
            finalList.add(finalObject);
        });
        return finalList;
    }

    private <T,S> T getMappedObject(S initialObject, Class<T> mappingClass) {
        if(initialObject == null) return null;
        return modelMapper.map(initialObject, mappingClass);
    }

    public List<CharacteristicDto> convertMongoCharacteristics(List<Characteristic> characteristics) {
        if(CollectionUtils.isEmpty(characteristics)) return null;
        List<CharacteristicDto> characteristicDtos = new ArrayList<>();
        characteristics.forEach(characteristic -> characteristicDtos.add(convertMongoCharacteristic(characteristic)));
        return characteristicDtos;
    }

    public List<Characteristic> convertDtosToMongoCharacteristic(List<CharacteristicDto> characteristicDtos) {
        if(CollectionUtils.isEmpty(characteristicDtos)) return null;
        List<Characteristic> characteristics = new ArrayList<>();
        characteristicDtos.forEach(characteristicDto -> characteristics.add(convertDtoToMongoCharacteristic(characteristicDto)));
        return characteristics;
    }

    public CharacteristicDto convertMongoCharacteristic(Characteristic characteristic) {
        if (characteristic == null) return null;
        CharacteristicDto characteristicDto = new CharacteristicDto();
        characteristicDto.setId(characteristic.getId());
        characteristicDto.setName(characteristic.getName());
        characteristicDto.setDescription(characteristic.getDescription());
        if(CollectionUtils.isNotEmpty(characteristic.getChoices())) {
            StringBuilder sb = new StringBuilder();
            characteristic.getChoices().forEach(choice -> {
                if (choice.getChoiceNumber() != null &&
                        StringUtils.isNotBlank(choice.getChoiceDescription())) {
                    sb.append(choice.getChoiceNumber());
                    sb.append(":" );
                    sb.append(choice.getChoiceDescription());
                    if (characteristic.getChoices().indexOf(choice) <
                            characteristic.getChoices().size() - 1){
                        sb.append(",");
                    }
                }
            });
            characteristicDto.setChoices(sb.toString());
        }
        return characteristicDto;
    }

    public Characteristic convertDtoToMongoCharacteristic(CharacteristicDto characteristicDto) {
        if (characteristicDto == null) return null;
        Characteristic characteristic = new Characteristic();
        characteristic.setId((String) characteristicDto.getId());
        characteristic.setName(characteristicDto.getName());
        characteristic.setDescription(characteristicDto.getDescription());
        List<Choice> choices = new ArrayList<>();
        if(StringUtils.isNotBlank(characteristicDto.getChoices())) {
            String[] dtoChoices = characteristicDto.getChoices().split(",");
            for(String dtoChoice : dtoChoices) {
                if(StringUtils.isNotBlank(dtoChoice)) {
                    String[] choiceParts = dtoChoice.split(":");
                    if (choiceParts.length == 2) {
                        Choice choice = new Choice();
                        choice.setChoiceNumber(Integer.parseInt(choiceParts[0]));
                        choice.setChoiceDescription(choiceParts[1]);
                        choices.add(choice);
                    }
                }
            }
        }
        characteristic.setChoices(choices);
        return characteristic;
    }

}
