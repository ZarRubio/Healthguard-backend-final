package pe.edu.upc.healthguard.measurement_service.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.healthguard.measurement_service.model.dtos.MeasurementRequest;
import pe.edu.upc.healthguard.measurement_service.model.dtos.MeasurementResponse;
import pe.edu.upc.healthguard.measurement_service.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
@RequiredArgsConstructor
@Tag(name = "MeasurementController", description = "API for measurement operations")
public class MeasurementController {
    private final MeasurementService measurementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new Measurement", description = "Adds a new Measurement to the system")
    @ApiResponse(responseCode = "201", description = "Measurement created")
    public void addMeasurement(@RequestBody MeasurementRequest measurementRequest) {
        measurementService.addMeasurement(measurementRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Measurements", description = "Retrieves a list of all Measurements")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of Measurements")
    public List<MeasurementResponse> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a Measurement", description = "Updates a specific Measurement by their ID")
    @ApiResponse(responseCode = "200", description = "Measurement updated")
    public void updateMeasurement(@PathVariable("id") long id, @RequestBody MeasurementRequest measurementRequest) {
        measurementService.updateMeasurement(id, measurementRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Measurement", description = "Deletes a specific Measurement by their ID")
    @ApiResponse(responseCode = "204", description = "Measurement deleted")
    public void deleteMeasurement(@PathVariable("id") long id) {
        measurementService.deleteMeasurement(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Measurement by ID", description = "Retrieves a specific Measurement by their ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of Measurement")
    public MeasurementResponse getMeasurementById(@PathVariable("id") long id) {
        return measurementService.getMeasurementById(id);
    }

    @GetMapping("/patient/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Measurements by Patient ID", description = "Retrieves all Measurements for a specific Patient ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of Measurements")
    public List<MeasurementResponse> getMeasurementsByPatientId(@PathVariable("patientId") Long patientId) {
        return measurementService.getMeasurementsByPatientId(patientId);
    }
}
