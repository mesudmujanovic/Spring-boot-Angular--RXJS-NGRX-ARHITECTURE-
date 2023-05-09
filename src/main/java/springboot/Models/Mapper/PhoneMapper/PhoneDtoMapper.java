package springboot.Models.Mapper.PhoneMapper;

import springboot.Entity.Phone;
import springboot.Intergration.DTOmapper;
import springboot.Models.Dto.PhoneDto;

public enum PhoneDtoMapper implements DTOmapper<PhoneDto, Phone> {
    INSTANCE;

    @Override
    public PhoneDto apply(Phone phone) {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setId(phone.getId());
        phoneDto.setModel(phone.getModel());
        phoneDto.setTitle(phone.getTitle());
        return phoneDto;
    }
}
