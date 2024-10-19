-- Insert initial data into type_device_iot table
INSERT IGNORE INTO type_device_iot (id, name, description) VALUES
                                                        (1, 'Temperature Sensor', 'Device that measures temperature'),
                                                        (2, 'Oximeter', 'Device that measures oxygen saturation in the blood'),
                                                        (3, 'Heart Rate Monitor', 'Device that measures heart rate'),
                                                        (4, 'Respiratory Rate Monitor', 'Device that measures respiratory rate');

-- Insert initial data into device_iot table
INSERT IGNORE INTO device_iot (id, type_device_iot_id, assigned, serial_code) VALUES
                                                                           (1, 1, true, 'TEMP123456'),
                                                                           (2, 2, true, 'OXI1234567'),
                                                                           (3, 3, true, 'HRM1234567'),
                                                                           (4, 4, true, 'RRM1234567');
