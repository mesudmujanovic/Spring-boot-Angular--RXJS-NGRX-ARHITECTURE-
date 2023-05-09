package springboot.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.Entity.Phone;
import springboot.Models.Dto.PhoneDto;
import springboot.Models.Mapper.PhoneMapper.PhoneDtoMapper;
import springboot.Models.Mapper.PhoneMapper.PhoneMapper;
import springboot.Models.Request.PhoneRequest;
import springboot.Models.Response.PhoneResponse;
import springboot.Service.PhoneService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/phone")
@CrossOrigin("*")
public class PhoneController {

    private PhoneService phoneService;
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/save")
    public ResponseEntity<PhoneResponse> savePhone (@RequestBody PhoneRequest phoneRequest){
        PhoneDto phoneDto = PhoneDto.fromRequestToDto(phoneRequest);
        PhoneDto savePhoneDto = phoneService.savePhone(phoneDto);
        return ResponseEntity.ok(savePhoneDto.fromDtoToResponse());
    }

    @GetMapping("allphone")
    public  ResponseEntity<List<PhoneResponse>> getAllPhone(){
        List<PhoneDto> phoneDtoList = phoneService.getAllPhones();
        return ResponseEntity.ok(phoneDtoList.stream().map(PhoneDto::fromDtoToResponse).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PhoneResponse> deletePhone (@PathVariable Long id){
        return ResponseEntity.ok(phoneService.deletePhone(id).fromDtoToResponse());
    }

}
