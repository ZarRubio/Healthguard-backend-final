package pe.edu.upc.healthguard.measurement_service.model.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MeasurementRequest {
    private Long iotId;
    private Long patientId;
    private Long userId;
    private String measurementData;
    private LocalDateTime measurementTime;
}

