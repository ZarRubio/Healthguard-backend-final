package pe.edu.upc.healthguard.iotdevice_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.healthguard.iotdevice_service.model.entities.IOTData;

import java.util.List;

@Repository
public interface IOTDataRepository extends JpaRepository<IOTData, Long> {
    List<IOTData> findByPatientId(long patientId);
    List<IOTData> findBySerialNumber(String serialNumber);
}
