package pe.edu.upc.healthguard.iotdevice_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.IOTDataRequest;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.IOTDataResponse;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.IOTDataValuesRequest;
import pe.edu.upc.healthguard.iotdevice_service.service.IOTDataService;

import java.util.List;

@RestController
@RequestMapping("/api/iotdata")
@RequiredArgsConstructor
public class IOTDataController {

    private final IOTDataService iotDataService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addIOTData(@RequestBody IOTDataRequest iotDataRequest) {
        iotDataService.addIOTData(iotDataRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IOTDataResponse> getAllIOTData() {
        return iotDataService.getAllIOTData();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateIOTData(@PathVariable("id") long id, @RequestBody IOTDataRequest iotDataRequest) {
        iotDataService.updateIOTData(id, iotDataRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIOTData(@PathVariable("id") long id) {
        iotDataService.deleteIOTData(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IOTDataResponse getIOTDataById(@PathVariable("id") long id) {
        return iotDataService.getIOTDataById(id);
    }

    @GetMapping("/patient/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public List<IOTDataResponse> getIOTDataByPatientId(@PathVariable("patientId") long patientId) {
        return iotDataService.getIOTDataByPatientId(patientId);
    }

    @GetMapping("/serial/{serialNumber}")
    @ResponseStatus(HttpStatus.OK)
    public List<IOTDataResponse> getIOTDataBySerialNumber(@PathVariable("serialNumber") String serialNumber) {
        return iotDataService.getIOTDataBySerialNumber(serialNumber);
    }

    @PutMapping("/values/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateIOTDataValues(@PathVariable("id") long id, @RequestBody IOTDataValuesRequest iotDataValuesRequest) {
        iotDataService.updateIOTDataValues(id, iotDataValuesRequest);
    }
}
