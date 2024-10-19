package pe.edu.upc.healthguard.patient_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.healthguard.patient_service.model.entites.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByDni(String dni);
    List<Patient> findByGender(String gender);
    List<Patient> findByAge(int age);
}

