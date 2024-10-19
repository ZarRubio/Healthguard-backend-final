package pe.edu.upc.healthguard.iotdevice_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.DeviceIoTRequest;
import pe.edu.upc.healthguard.iotdevice_service.model.dtos.DeviceIoTResponse;
import pe.edu.upc.healthguard.iotdevice_service.service.DeviceIoTService;

import java.util.List;

@RestController
@RequestMapping("/api/deviceIoT")
@RequiredArgsConstructor
public class DeviceIoTController {

    private final DeviceIoTService deviceIoTService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new device IoT", description = "Adds a new device IoT to the system")
    @ApiResponse(responseCode = "201", description = "Device IoT created")
    public void addDeviceIoT(@RequestBody DeviceIoTRequest deviceIoTRequest) {
        deviceIoTService.addDeviceIoT(deviceIoTRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all device IoTs", description = "Retrieves a list of all device IoTs")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of device IoTs")
    public List<DeviceIoTResponse> getAllDeviceIoTs() {
        return deviceIoTService.getAllDeviceIoTs();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a device IoT", description = "Updates a specific device IoT by its ID")
    @ApiResponse(responseCode = "200", description = "Device IoT updated")
    public void updateDeviceIoT(@PathVariable("id") long id, @RequestBody DeviceIoTRequest deviceIoTRequest) {
        deviceIoTService.updateDeviceIoT(id, deviceIoTRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a device IoT", description = "Deletes a specific device IoT by its ID")
    @ApiResponse(responseCode = "204", description = "Device IoT deleted")
    public void deleteDeviceIoT(@PathVariable("id") long id) {
        deviceIoTService.deleteDeviceIoT(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a device IoT by ID", description = "Retrieves a specific device IoT by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of device IoT")
    public DeviceIoTResponse getDeviceIoTById(@PathVariable("id") long id) {
        return deviceIoTService.getDeviceIoTById(id);
    }

    @GetMapping("/assigned/{assigned}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get device IoTs by assignment status", description = "Retrieves a list of device IoTs by their assignment status")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of device IoTs")
    public List<DeviceIoTResponse> getDeviceIoTsByAssigned(@PathVariable("assigned") boolean assigned) {
        return deviceIoTService.getDeviceIoTsByAssigned(assigned);
    }

    @GetMapping("/type/{typeDeviceIoTId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get device IoTs by type", description = "Retrieves a list of device IoTs by their type")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of device IoTs")
    public List<DeviceIoTResponse> getDeviceIoTsByTypeDeviceIoTId(@PathVariable("typeDeviceIoTId") long typeDeviceIoTId) {
        return deviceIoTService.getDeviceIoTsByTypeDeviceIoTId(typeDeviceIoTId);
    }

    @GetMapping("/serial/{serialCode}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a device IoT by serial code", description = "Retrieves a specific device IoT by its serial code")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of device IoT")
    public DeviceIoTResponse getDeviceIoTBySerialCode(@PathVariable("serialCode") String serialCode) {
        return deviceIoTService.getDeviceIoTBySerialCode(serialCode);
    }
}

