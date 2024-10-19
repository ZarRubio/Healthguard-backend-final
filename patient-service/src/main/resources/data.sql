-- Insert initial data into patients table
INSERT IGNORE INTO patients (patient_id, first_name, last_name, dni, age, gender) VALUES
                                                                              (1, 'John', 'Doe', '12345678', 30, 'Male'),
                                                                              (2, 'Jane', 'Smith', '87654321', 28, 'Female'),
                                                                              (3, 'Alice', 'Johnson', '23456789', 45, 'Female'),
                                                                              (4, 'Bob', 'Brown', '98765432', 50, 'Male');
