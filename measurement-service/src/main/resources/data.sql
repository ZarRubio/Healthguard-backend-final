-- Insert initial data into measurements table
INSERT IGNORE INTO measurements (id, iot_id, patient_id, user_id, measurement_data, measurement_time) VALUES
(1, 1, 1, 1, '36.5°C', '2023-05-26T10:15:30'),
(2, 1, 1, 1, '98%', '2023-05-26T11:00:00'),
(3, 1, 1, 1, '75 bpm', '2023-05-26T11:30:45'),
(4, 1, 1, 1, '18 breaths/min', '2023-05-26T12:00:00');