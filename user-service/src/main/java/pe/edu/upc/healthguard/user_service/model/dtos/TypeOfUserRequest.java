package pe.edu.upc.healthguard.user_service.model.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeOfUserRequest {
    private String description;
}
