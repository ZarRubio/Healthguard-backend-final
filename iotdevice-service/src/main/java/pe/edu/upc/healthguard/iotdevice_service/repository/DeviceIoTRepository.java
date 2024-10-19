package pe.edu.upc.healthguard.iotdevice_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.healthguard.iotdevice_service.model.entities.DeviceIoT;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceIoTRepository extends JpaRepository<DeviceIoT, Long> {
    List<DeviceIoT> findByAssigned(boolean assigned);
    List<DeviceIoT> findByTypeDeviceIoTId(long typeDeviceIoTId);
    Optional<DeviceIoT> findBySerialCode(String serialCode);
}
