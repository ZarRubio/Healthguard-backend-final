package pe.edu.upc.healthguard.iotdevice_service.model.entities;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Entity
@Table(name = "iot_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IOTData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "patient_id", nullable = false)
    private long patientId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "fecha_de_entrada", nullable = false)
    private LocalDate fechaDeEntrada;

    @Column(name = "temperature", nullable = false)
    private float temperature;

    @Column(name = "oximeter", nullable = false)
    private float oximeter;

    @Column(name = "heart_rate", nullable = false)
    private int heartRate;

    @Column(name = "respiratory_rate", nullable = false)
    private int respiratoryRate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "ultima_fecha", nullable = false)
    private LocalDate ultimaFecha;

    @Override
    public String toString() {
        return "IOTData{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", patientId=" + patientId +
                ", fechaDeEntrada=" + fechaDeEntrada +
                ", temperature=" + temperature +
                ", oximeter=" + oximeter +
                ", heartRate=" + heartRate +
                ", respiratoryRate=" + respiratoryRate +
                ", ultimaFecha=" + ultimaFecha +
                '}';
    }
}
