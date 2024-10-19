package pe.edu.upc.healthguard.iotdevice_service.model.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceIoTRequest {
    private long typeDeviceIoTId;
    private boolean assigned;
    private String serialCode;
}
