package pe.edu.upc.healthguard.patient_service.model.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "dni", nullable = false, unique = true, length = 8)
    private String dni;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni + ", age=" + age + ", gender=" + gender + "]";
    }
}

