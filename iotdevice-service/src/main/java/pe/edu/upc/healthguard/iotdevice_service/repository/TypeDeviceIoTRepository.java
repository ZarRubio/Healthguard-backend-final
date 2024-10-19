package pe.edu.upc.healthguard.iotdevice_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.healthguard.iotdevice_service.model.entities.TypeDeviceIoT;

@Repository
public interface TypeDeviceIoTRepository extends JpaRepository<TypeDeviceIoT, Long> {
}

