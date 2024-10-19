package pe.edu.upc.healthguard.iotdevice_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.TypeDeviceIoTRequest;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.TypeDeviceIoTResponse;
import pe.edu.upc.healthguard.iotdevice_service.model.entities.TypeDeviceIoT;
import pe.edu.upc.healthguard.iotdevice_service.repository.TypeDeviceIoTRepository;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class TypeDeviceIoTService {
    private final TypeDeviceIoTRepository typeDeviceIoTRepository;

    public void addTypeDeviceIoT(TypeDeviceIoTRequest typeDeviceIoTRequest) {
        var typeDeviceIoT = TypeDeviceIoT.builder()
                .name(typeDeviceIoTRequest.getName())
                .description(typeDeviceIoTRequest.getDescription())
                .build();
        typeDeviceIoTRepository.save(typeDeviceIoT);
        log.info("Type of Device IoT added: {}", typeDeviceIoT);
    }

    public List<TypeDeviceIoTResponse> getAllTypeDeviceIoTs() {
        var typeDeviceIoTs = typeDeviceIoTRepository.findAll();
        return typeDeviceIoTs.stream()
                .map(this::mapToTypeDeviceIoTResponse)
                .collect(Collectors.toList());
    }

    public void updateTypeDeviceIoT(long id, TypeDeviceIoTRequest typeDeviceIoTRequest) {
        TypeDeviceIoT existingTypeDeviceIoT = typeDeviceIoTRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device IoT type not found with id " + id));
        existingTypeDeviceIoT.setName(typeDeviceIoTRequest.getName());
        existingTypeDeviceIoT.setDescription(typeDeviceIoTRequest.getDescription());
        typeDeviceIoTRepository.save(existingTypeDeviceIoT);
        log.info("Updated Device IoT Type: {}", existingTypeDeviceIoT);
    }

    public void deleteTypeDeviceIoT(long id) {
        typeDeviceIoTRepository.deleteById(id);
        log.info("Deleted Device IoT Type with id {}", id);
    }

    public TypeDeviceIoTResponse getTypeDeviceIoTById(long id) {
        TypeDeviceIoT typeDeviceIoT = typeDeviceIoTRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device IoT type not found with id " + id));
        return mapToTypeDeviceIoTResponse(typeDeviceIoT);
    }

    private TypeDeviceIoTResponse mapToTypeDeviceIoTResponse(TypeDeviceIoT typeDeviceIoT) {
        return TypeDeviceIoTResponse.builder()
                .id(typeDeviceIoT.getId())
                .name(typeDeviceIoT.getName())
                .description(typeDeviceIoT.getDescription())
                .build();
    }
}