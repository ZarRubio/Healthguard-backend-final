package pe.edu.upc.healthguard.iotdevice_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "device_iot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceIoT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_device_iot_id", nullable = false)
    private long typeDeviceIoTId;

    @Column(name = "assigned", nullable = false)
    private boolean assigned;

    @Column(name = "serial_code", nullable = false, length = 11, unique = true)
    private String serialCode;

    @Override
    public String toString() {
        return "DeviceIoT [id=" + id + ", typeDeviceIoTId=" + typeDeviceIoTId + ", assigned=" + assigned + ", serialCode=" + serialCode + "]";
    }
}
