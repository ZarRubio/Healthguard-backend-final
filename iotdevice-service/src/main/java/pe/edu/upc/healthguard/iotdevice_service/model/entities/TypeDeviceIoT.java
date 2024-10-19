package pe.edu.upc.healthguard.iotdevice_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type_device_iot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeDeviceIoT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Override
    public String toString() {
        return "TypeDeviceIoT [id=" + id + ", name=" + name + ", description=" + description + "]";
    }
}
