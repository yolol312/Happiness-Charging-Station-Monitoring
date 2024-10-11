package com.example.happyDream.Controller;

import com.example.happyDream.DTO.ChargerDTO;
import com.example.happyDream.DTO.ChargerLogDTO;
import com.example.happyDream.Service.ChargerLogService;
import com.example.happyDream.Service.ChargerServiceFacade;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ChargerLogRestController {
    private final ChargerServiceFacade chargerServiceFacade;

    @Autowired
    public ChargerLogRestController(ChargerServiceFacade chargerServiceFacade, ChargerLogService chargerLogService) {
        this.chargerServiceFacade = chargerServiceFacade;
    }

    // TODO - JSON 응답 추가 예정

    // 전체 충전 로그 조회
    @GetMapping("/chargers/logs")
    public String getAllChargerLog() {
        List<ChargerLogDTO> chargerLogDtoList = this.chargerServiceFacade.getAllChargerLog();
        return "";
    }

    // 전체 충전 로그 삭제
    // TODO - 권한 검증 추가
    @DeleteMapping("/chargers/logs")
    public String deleteAllChargerLog() {
        this.chargerServiceFacade.deleteAllChargerLog();
        return "";
    }

    // 특정 충전기의 전체 충전 로그 조회
    @GetMapping("/chargers/logs/{id}")
    public String getChargerLog(@PathVariable("id") Integer chargerId) {
        ChargerDTO chargerDto = chargerServiceFacade.chargerSelect(chargerId);
        List<ChargerLogDTO> chargerLogDtoList = chargerServiceFacade.getAllTargetChargerLog(chargerDto);
        return "";
    }

    // 특정 충전기 충전 로그 추가
    @PostMapping("/chargers/logs/{id}")
    public String createChargerLog(@PathVariable("id") Integer chargerId, Float ampere) {
        try {
            ChargerDTO chargerDto = chargerServiceFacade.chargerSelect(chargerId);

            ChargerLogDTO chargerLogDto = ChargerLogDTO.builder()
                    .chargerId(chargerDto.toEntity())
                    .ampere(ampere)
                    .build();

            chargerServiceFacade.createTargetChargerLog(chargerLogDto);

        } catch (EntityNotFoundException ignored) {
            log.warn("존재하지 않는 충전기 id: {}", chargerId);
        }

        return "";
    }

    // 충전기 하드웨어 설정값 조회
    @GetMapping("/chargers/logs/upgrade")
    public String getChargerLogSetting() {
        return "";
    }

    // 충전기 하드웨어 설정값 변경
    @PostMapping("/chargers/logs/upgrade")
    public String createChargerLogSetting() {
        return "";
    }
}
