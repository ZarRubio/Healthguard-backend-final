package pe.edu.upc.healthguard.iotdevice_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.DeviceIoTRequest;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.DeviceIoTResponse;
import pe.edu.upc.healthguard.iotdevice_service.model.entities.DeviceIoT;
import pe.edu.upc.healthguard.iotdevice_service.repository.DeviceIoTRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeviceIoTService {
    private final DeviceIoTRepository deviceIoTRepository;

    public void addDeviceIoT(DeviceIoTRequest deviceIoTRequest) {
        var deviceIoT = DeviceIoT.builder()
                .typeDeviceIoTId(deviceIoTRequest.getTypeDeviceIoTId())
                .assigned(deviceIoTRequest.isAssigned())
                .serialCode(deviceIoTRequest.getSerialCode())
                .build();
        deviceIoTRepository.save(deviceIoT);
        log.info("Device IoT added: {}", deviceIoT);
    }

    public List<DeviceIoTResponse> getAllDeviceIoTs() {
        var typeDeviceIoTs = deviceIoTRepository.findAll();
        return typeDeviceIoTs.stream()
                .map(this::mapToDeviceIoTResponse)
                .collect(Collectors.toList());
    }

    public void updateDeviceIoT(long id, DeviceIoTRequest deviceIoTRequest) {
        DeviceIoT existingDeviceIoT = deviceIoTRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device IoT not found with id " + id));
        existingDeviceIoT.setTypeDeviceIoTId(deviceIoTRequest.getTypeDeviceIoTId());
        existingDeviceIoT.setAssigned(deviceIoTRequest.isAssigned());
        existingDeviceIoT.setSerialCode(deviceIoTRequest.getSerialCode());
        deviceIoTRepository.save(existingDeviceIoT);
        log.info("Updated Device IoT Type: {}", existingDeviceIoT);
    }

    public void deleteDeviceIoT(long id) {
        deviceIoTRepository.deleteById(id);
        log.info("Deleted Device IoT with id {}", id);
    }

    public DeviceIoTResponse getDeviceIoTById(long id) {
        DeviceIoT deviceIoT = deviceIoTRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device IoT not found with id " + id));
        return mapToDeviceIoTResponse(deviceIoT);
    }

    public List<DeviceIoTResponse> getDeviceIoTsByAssigned(boolean assigned) {
        return deviceIoTRepository.findByAssigned(assigned).stream()
                .map(this::mapToDeviceIoTResponse)
                .collect(Collectors.toList());
    }

    public List<DeviceIoTResponse> getDeviceIoTsByTypeDeviceIoTId(long typeDeviceIoTId) {
        return deviceIoTRepository.findByTypeDeviceIoTId(typeDeviceIoTId).stream()
                .map(this::mapToDeviceIoTResponse)
                .collect(Collectors.toList());
    }

    public DeviceIoTResponse getDeviceIoTBySerialCode(String serialCode) {
        DeviceIoT deviceIoT = deviceIoTRepository.findBySerialCode(serialCode)
                .orElseThrow(() -> new RuntimeException("Device IoT not found with serial code " + serialCode));
        return mapToDeviceIoTResponse(deviceIoT);
    }

    private DeviceIoTResponse mapToDeviceIoTResponse(DeviceIoT deviceIoT) {
        return DeviceIoTResponse.builder()
                .id(deviceIoT.getId())
                .typeDeviceIoTId(deviceIoT.getTypeDeviceIoTId())
                .assigned(deviceIoT.isAssigned())
                .serialCode(deviceIoT.getSerialCode())
                .build();
    }
}
