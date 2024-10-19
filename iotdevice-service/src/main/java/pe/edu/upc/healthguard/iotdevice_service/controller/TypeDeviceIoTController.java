package pe.edu.upc.healthguard.iotdevice_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.TypeDeviceIoTRequest;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.TypeDeviceIoTResponse;
import pe.edu.upc.healthguard.iotdevice_service.service.TypeDeviceIoTService;

import java.util.List;

@RestController
@RequestMapping("/api/typeDeviceIoT")
@RequiredArgsConstructor
public class TypeDeviceIoTController {

    private final TypeDeviceIoTService typeDeviceIoTService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTypeDeviceIoT(@RequestBody TypeDeviceIoTRequest typeDeviceIoTRequest) {
        typeDeviceIoTService.addTypeDeviceIoT(typeDeviceIoTRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TypeDeviceIoTResponse> getAllTypeDeviceIoTs() {
        return typeDeviceIoTService.getAllTypeDeviceIoTs();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTypeDeviceIoT(@PathVariable("id") long id, @RequestBody TypeDeviceIoTRequest typeDeviceIoTRequest) {
        typeDeviceIoTService.updateTypeDeviceIoT(id, typeDeviceIoTRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTypeDeviceIoT(@PathVariable("id") long id) {
        typeDeviceIoTService.deleteTypeDeviceIoT(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypeDeviceIoTResponse getTypeDeviceIoTById(@PathVariable("id") long id) {
        return typeDeviceIoTService.getTypeDeviceIoTById(id);
    }
}

