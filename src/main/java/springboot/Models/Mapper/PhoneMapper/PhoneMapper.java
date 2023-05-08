package springboot.Models.Mapper.PhoneMapper;

import springboot.Entity.Phone;
import springboot.Intergration.DTOmapper;
import springboot.Models.Dto.PhoneDto;

public enum PhoneMapper implements DTOmapper<Phone, PhoneDto> {
    INSTANCE;

    @Override
    public Phone apply(PhoneDto phoneDto) {
        Phone phone = new Phone();
        phone.setId(phoneDto.getId());
        phone.setModel(phoneDto.getModel());
        phone.setTitle(phone.getTitle());
        return phone;
    }
}
