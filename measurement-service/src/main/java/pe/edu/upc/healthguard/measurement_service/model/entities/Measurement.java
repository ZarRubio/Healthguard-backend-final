package pe.edu.upc.healthguard.measurement_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iot_id", nullable = false)
    private Long iotId;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "measurement_data", nullable = false)
    private String measurementData;

    @Column(name = "measurement_time", nullable = false)
    private LocalDateTime measurementTime;

    @Override
    public String toString() {
        return "Measurement[id=" + id + ", iotId=" + iotId + ", patientId=" + patientId + ", userId=" + userId +
                ", measurementData=" + measurementData + ", measurementTime=" + measurementTime + "]";
    }
}

