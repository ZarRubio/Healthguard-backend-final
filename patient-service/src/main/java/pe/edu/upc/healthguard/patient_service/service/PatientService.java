package pe.edu.upc.healthguard.patient_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upc.healthguard.patient_service.model.dtos.PatientRequest;
import pe.edu.upc.healthguard.patient_service.model.dtos.PatientResponse;
import pe.edu.upc.healthguard.patient_service.model.entites.Patient;
import pe.edu.upc.healthguard.patient_service.repository.PatientRepository;
import pe.edu.upc.healthguard.patient_service.shared.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {
    private final PatientRepository patientRepository;

    public void addPatient(PatientRequest request) {
        Patient patient = Patient.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dni(request.getDni())
                .age(request.getAge())
                .gender(request.getGender())
                .build();
        patientRepository.save(patient);
        log.info("Patient added: {}", patient);
    }

    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(this::mapToPatientResponse)
                .collect(Collectors.toList());
    }

    public void updatePatient(long id, PatientRequest patientRequest) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        existingPatient.setFirstName(patientRequest.getFirstName());
        existingPatient.setLastName(patientRequest.getLastName());
        existingPatient.setDni(patientRequest.getDni());
        existingPatient.setAge(patientRequest.getAge());
        existingPatient.setGender(patientRequest.getGender());

        patientRepository.save(existingPatient);
        log.info("Updated Patient: {}", existingPatient);
    }

    public void deletePatient(long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
        log.info("Deleted Patient with id {}", id);
    }

    private PatientResponse mapToPatientResponse(Patient patient) {
        return PatientResponse.builder()
                .patientId(patient.getPatientId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .dni(patient.getDni())
                .age(patient.getAge())
                .gender(patient.getGender())
                .build();
    }

    public PatientResponse getPatientById(long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        return mapToPatientResponse(patient);
    }

    public PatientResponse getPatientByDni(String dni) {
        Patient patient = patientRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with DNI: " + dni));
        return mapToPatientResponse(patient);
    }

    public List<PatientResponse> getPatientsByGender(String gender) {
        return patientRepository.findByGender(gender).stream()
                .map(this::mapToPatientResponse)
                .collect(Collectors.toList());
    }

    public List<PatientResponse> getPatientsByAge(int age) {
        return patientRepository.findByAge(age).stream()
                .map(this::mapToPatientResponse)
                .collect(Collectors.toList());
    }
}

