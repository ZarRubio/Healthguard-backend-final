package pe.edu.upc.healthguard.iotdevice_service.model.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDeviceIoTResponse {
    private long id;
    private String name;
    private String description;
}
