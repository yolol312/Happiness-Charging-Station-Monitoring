package com.example.happyDream.RestController;

import com.example.happyDream.DTO.ChargerDTO;
import com.example.happyDream.DTO.ChargerDetailDTO;
import com.example.happyDream.DTO.ResponseDTO;
import com.example.happyDream.Interface.ChargerSwagger;
import com.example.happyDream.Service.ChargerServiceFacade;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController //ResponseBody + Controller 어노테이션
@RequestMapping(path = "/api/v1", produces = "application/json")
public class ChargerRestController implements ChargerSwagger {
    private final ChargerServiceFacade chargerServiceFacade;

    @Autowired
    public ChargerRestController(ChargerServiceFacade chargerServiceFacade) {
        this.chargerServiceFacade = chargerServiceFacade;
    }

    @GetMapping("/chargers")
    public ResponseDTO getAllChargers() {
        List<ChargerDTO> chargerDtoList = this.chargerServiceFacade.chargerSelectAll();

        ResponseDTO responseDto;
        if (chargerDtoList.isEmpty()) {
            responseDto = ResponseDTO.success("v1", HttpServletResponse.SC_NO_CONTENT, Collections.unmodifiableList(chargerDtoList));
        }
        else {
            responseDto = ResponseDTO.success("v1", HttpServletResponse.SC_OK, Collections.unmodifiableList(chargerDtoList));
        }
        return responseDto;
    }

    @GetMapping("/chargers/detail")
    public ResponseDTO getAllChargersDetail() {
        List<ChargerDetailDTO> chargerDetailDtoList = this.chargerServiceFacade.chargerSelectAllDetail();

        ResponseDTO responseDto;
        if (chargerDetailDtoList.isEmpty()) {
            responseDto = ResponseDTO.success("v1", HttpServletResponse.SC_NO_CONTENT, Collections.unmodifiableList(chargerDetailDtoList));
        }
        else {
            responseDto = ResponseDTO.success("v1", HttpServletResponse.SC_OK, Collections.unmodifiableList(chargerDetailDtoList));
        }
        return responseDto;
    }

    // 비동기 처리 고려해봐야 함
    @PostMapping("/chargers")
    public ResponseDTO createChargerSyncGovernment(@RequestBody String requestJson) {
        return this.chargerServiceFacade.createChargerSyncGovernment(requestJson);
    }
}