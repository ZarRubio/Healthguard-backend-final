package pe.edu.upc.healthguard.iotdevice_service.model.dtos;

import lombok.Data;

@Data
public class IOTDataValuesRequest {
    private float temperature;
    private float oximeter;
    private int heartRate;
    private int respiratoryRate;
}

