package pe.edu.upc.healthguard.patient_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import pe.edu.upc.healthguard.patient_service.model.dtos.PatientRequest;
import pe.edu.upc.healthguard.patient_service.model.dtos.PatientResponse;
import pe.edu.upc.healthguard.patient_service.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Tag(name = "PatientController", description = "API for patient operations")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new patient", description = "Adds a new patient to the system")
    @ApiResponse(responseCode = "201", description = "Patient created")
    public void addPatient(@RequestBody PatientRequest patientRequest) {
        patientService.addPatient(patientRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all patients", description = "Retrieves a list of all patients")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of patients")
    public List<PatientResponse> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a patient", description = "Updates a specific patient by their ID")
    @ApiResponse(responseCode = "200", description = "Patient updated")
    public void updatePatient(@PathVariable("id") long id, @RequestBody PatientRequest patientRequest) {
        patientService.updatePatient(id, patientRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a patient", description = "Deletes a specific patient by their ID")
    @ApiResponse(responseCode = "204", description = "Patient deleted")
    public void deletePatient(@PathVariable("id") long id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a patient by ID", description = "Retrieves a specific patient by their ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of patient")
    public PatientResponse getPatientById(@PathVariable("id") long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/dni/{dni}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a patient by DNI", description = "Retrieves a specific patient by their DNI")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of patient")
    public PatientResponse getPatientByDni(@PathVariable("dni") String dni) {
        return patientService.getPatientByDni(dni);
    }

    @GetMapping("/gender/{gender}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get patients by gender", description = "Retrieves a list of patients by their gender")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of patients")
    public List<PatientResponse> getPatientsByGender(@PathVariable("gender") String gender) {
        return patientService.getPatientsByGender(gender);
    }

    @GetMapping("/age/{age}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get patients by age", description = "Retrieves a list of patients by their age")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of patients")
    public List<PatientResponse> getPatientsByAge(@PathVariable("age") int age) {
        return patientService.getPatientsByAge(age);
    }
}

