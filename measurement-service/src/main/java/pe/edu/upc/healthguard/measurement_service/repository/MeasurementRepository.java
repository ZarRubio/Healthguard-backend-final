package pe.edu.upc.healthguard.measurement_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.healthguard.measurement_service.model.entities.Measurement;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByPatientId(Long patientId);
}
