package pe.edu.upc.healthguard.patient_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PatientResponse {
    private long patientId;
    private String firstName;
    private String lastName;
    private String dni;
    private int age;
    private String gender;
}

