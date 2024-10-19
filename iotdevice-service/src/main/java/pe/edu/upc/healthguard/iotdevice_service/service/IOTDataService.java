package pe.edu.upc.healthguard.iotdevice_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.IOTDataRequest;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.IOTDataResponse;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.IOTDataValuesRequest;
import pe.edu.upc.healthguard.iotdevice_service.model.entities.IOTData;
import pe.edu.upc.healthguard.iotdevice_service.repository.IOTDataRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class IOTDataService {
    private final IOTDataRepository iotDataRepository;

    public void addIOTData(IOTDataRequest iotDataRequest) {
        IOTData iotData = IOTData.builder()
                .serialNumber(iotDataRequest.getSerialNumber())
                .patientId(iotDataRequest.getPatientId())
                .fechaDeEntrada(iotDataRequest.getFechaDeEntrada())
                .temperature(iotDataRequest.getTemperature())
                .oximeter(iotDataRequest.getOximeter())
                .heartRate(iotDataRequest.getHeartRate())
                .respiratoryRate(iotDataRequest.getRespiratoryRate())
                .ultimaFecha(iotDataRequest.getUltimaFecha())
                .build();
        iotDataRepository.save(iotData);
        log.info("IOT Data added: {}", iotData);
    }

    public List<IOTDataResponse> getAllIOTData() {
        var iotDataList = iotDataRepository.findAll();
        return iotDataList.stream()
                .map(this::mapToIOTDataResponse)
                .collect(Collectors.toList());
    }

    public void updateIOTData(long id, IOTDataRequest iotDataRequest) {
        IOTData existingIOTData = iotDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IOT Data not found with id " + id));
        existingIOTData.setSerialNumber(iotDataRequest.getSerialNumber());
        existingIOTData.setPatientId(iotDataRequest.getPatientId());
        existingIOTData.setFechaDeEntrada(iotDataRequest.getFechaDeEntrada());
        existingIOTData.setTemperature(iotDataRequest.getTemperature());
        existingIOTData.setOximeter(iotDataRequest.getOximeter());
        existingIOTData.setHeartRate(iotDataRequest.getHeartRate());
        existingIOTData.setRespiratoryRate(iotDataRequest.getRespiratoryRate());
        existingIOTData.setUltimaFecha(iotDataRequest.getUltimaFecha());
        iotDataRepository.save(existingIOTData);
        log.info("Updated IOT Data: {}", existingIOTData);
    }

    public void deleteIOTData(long id) {
        iotDataRepository.deleteById(id);
        log.info("Deleted IOT Data with id {}", id);
    }

    public IOTDataResponse getIOTDataById(long id) {
        IOTData iotData = iotDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IOT Data not found with id " + id));
        return mapToIOTDataResponse(iotData);
    }

    public List<IOTDataResponse> getIOTDataByPatientId(long patientId) {
        return iotDataRepository.findByPatientId(patientId).stream()
                .map(this::mapToIOTDataResponse)
                .collect(Collectors.toList());
    }

    public List<IOTDataResponse> getIOTDataBySerialNumber(String serialNumber) {
        return iotDataRepository.findBySerialNumber(serialNumber).stream()
                .map(this::mapToIOTDataResponse)
                .collect(Collectors.toList());
    }

    private IOTDataResponse mapToIOTDataResponse(IOTData iotData) {
        return IOTDataResponse.builder()
                .id(iotData.getId())
                .serialNumber(iotData.getSerialNumber())
                .patientId(iotData.getPatientId())
                .fechaDeEntrada(iotData.getFechaDeEntrada())
                .temperature(iotData.getTemperature())
                .oximeter(iotData.getOximeter())
                .heartRate(iotData.getHeartRate())
                .respiratoryRate(iotData.getRespiratoryRate())
                .ultimaFecha(iotData.getUltimaFecha())
                .build();
    }

    public void updateIOTDataValues(long id, IOTDataValuesRequest iotDataValuesRequest) {
        IOTData existingIOTData = iotDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IOT Data not found with id " + id));
        existingIOTData.setTemperature(iotDataValuesRequest.getTemperature());
        existingIOTData.setOximeter(iotDataValuesRequest.getOximeter());
        existingIOTData.setHeartRate(iotDataValuesRequest.getHeartRate());
        existingIOTData.setRespiratoryRate(iotDataValuesRequest.getRespiratoryRate());
        iotDataRepository.save(existingIOTData);
        log.info("Updated IOT Data values: {}", existingIOTData);
    }
}
