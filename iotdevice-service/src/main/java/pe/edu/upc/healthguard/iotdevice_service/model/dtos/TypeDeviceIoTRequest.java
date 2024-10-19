package pe.edu.upc.healthguard.iotdevice_service.model.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDeviceIoTRequest {
    private String name;
    private String description;
}

