package pe.edu.upc.healthguard.measurement_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upc.healthguard.measurement_service.model.dtos.MeasurementRequest;
import pe.edu.upc.healthguard.measurement_service.model.dtos.MeasurementResponse;
import pe.edu.upc.healthguard.measurement_service.model.entities.Measurement;
import pe.edu.upc.healthguard.measurement_service.repository.MeasurementRepository;
import pe.edu.upc.healthguard.measurement_service.shared.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    public void addMeasurement(MeasurementRequest request) {
        Measurement measurement = Measurement.builder()
                .iotId(request.getIotId())
                .patientId(request.getPatientId())
                .userId(request.getUserId())
                .measurementData(request.getMeasurementData())
                .measurementTime(request.getMeasurementTime())
                .build();
        measurementRepository.save(measurement);
        log.info("Measurement added: {}", measurement);
    }

    public List<MeasurementResponse> getAllMeasurements() {
        return measurementRepository.findAll().stream()
                .map(this::mapToMeasurementResponse)
                .collect(Collectors.toList());
    }

    public void updateMeasurement(long id, MeasurementRequest measurementRequest) {
        Measurement existingMeasurement = measurementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Measurement not found with id: " + id));

        existingMeasurement.setIotId(measurementRequest.getIotId());
        existingMeasurement.setPatientId(measurementRequest.getPatientId());
        existingMeasurement.setUserId(measurementRequest.getUserId());
        existingMeasurement.setMeasurementData(measurementRequest.getMeasurementData());
        existingMeasurement.setMeasurementTime(measurementRequest.getMeasurementTime());

        measurementRepository.save(existingMeasurement);
        log.info("Updated Measurement: {}", existingMeasurement);
    }

    public void deleteMeasurement(long id) {
        if (!measurementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Measurement not found with id: " + id);
        }
        measurementRepository.deleteById(id);
        log.info("Deleted Measurement with id {}", id);
    }

    private MeasurementResponse mapToMeasurementResponse(Measurement measurement) {
        return MeasurementResponse.builder()
                .id(measurement.getId())
                .iotId(measurement.getIotId())
                .patientId(measurement.getPatientId())
                .userId(measurement.getUserId())
                .measurementData(measurement.getMeasurementData())
                .measurementTime(measurement.getMeasurementTime())
                .build();
    }

    public MeasurementResponse getMeasurementById(long id) {
        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Measurement not found with id: " + id));
        return mapToMeasurementResponse(measurement);
    }

    public List<MeasurementResponse> getMeasurementsByPatientId(Long patientId) {
        return measurementRepository.findByPatientId(patientId).stream()
                .map(this::mapToMeasurementResponse)
                .collect(Collectors.toList());
    }
}
