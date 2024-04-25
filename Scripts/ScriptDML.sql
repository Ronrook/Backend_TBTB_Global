INSERT INTO `CLINICAL_RECORD`.`users` (`first_name`, `middle_name`, `last_name`, `second_last_name`, `dni_number`, `date_of_birth`, `email`, `phone`, `is_active`) 
VALUES 
('John', 'Doe', 'Smith', NULL, '12345678A', '1990-05-15', 'john.doe@example.com', '+123456789', 1),
('Maria', 'Isabella', 'Garcia', 'Lopez', '98765432B', '1992-08-20', 'maria.garcia@example.com', '+123456780', 1),
('David', 'Michael', 'Brown', NULL, '23456789C', '1985-03-10', 'david.brown@example.com', '+123456781', 1),
('Emma', 'Sophia', 'Martinez', 'Rodriguez', '34567890D', '1998-11-05', 'emma.martinez@example.com', '+123456782', 1),
('Pepe', 'Solis', 'Martinez', 'Rodriguez', '578624', '1998-11-05', 'pepe.martinez@example.com', '+123456782', 1),
('Carlos', 'Prez', 'Moreno', 'Andrade', '2431789', '1998-11-05', 'carlosMoreA@example.com', '+123456782', 1);

INSERT INTO `CLINICAL_RECORD`.`specialties` (`specialty_name`) 
VALUES 
('Cardiology'), 
('Dermatology'), ('Orthopedics');

INSERT INTO `CLINICAL_RECORD`.`doctors` (`doctor_id`, `specialty_id`) 
VALUES 
(1, 1), 
(2, 2), 
(6, 2);

INSERT INTO `CLINICAL_RECORD`.`patients` (`patient_id`, `diagnosis`) 
VALUES 
(3, 'Hypertension'), 
(4, 'Diabetes'), 
(5, 'Dengue');

INSERT INTO `CLINICAL_RECORD`.`appointments` (`appointment_date`, `appointment_time`, `patient_id`, `doctor_id`, `is_attended`) 
VALUES 
('2024-04-25', '10:00:00', 4, 1, 1), 
('2024-04-28', '14:30:00', 3, 1, 0);

INSERT INTO `CLINICAL_RECORD`.`medications` (`medication_name`, `manufacturer`, `dosage`, `administration_route`, `frequency`, `indications`, `contraindications`, `sideEffects`, `storage_nstructions`, `expiry_date`) 
VALUES 
('Aspirin', 'Bayer', '100mg', 'Oral', 'Once daily', 'Pain relief', 'Allergy to aspirin', 'Nausea, stomach pain', 'Store at room temperature', '2025-12-31'),
('Lisinopril', 'Novartis', '20mg', 'Oral', 'Once daily', 'Hypertension', 'Pregnancy', 'Cough, dizziness', 'Store in a dry place', '2024-10-31');


INSERT INTO `CLINICAL_RECORD`.`rel_patients_medications` (`patient_id`, `medication_id`) 
VALUES 
(3, 1),
(4, 1), 
(5, 2);


/* Consultar el nombre de los pacientes y las fechas de sus citas*/
SELECT u.first_name, u.last_name, a.appointment_date
FROM patients AS p
INNER JOIN users AS u ON p.patient_id = u.user_id 
INNER JOIN appointments AS a ON p.patient_id = a.patient_id; 

/*cantidad de pacientes que consumen el medicamentos Aspirin */
SELECT m.medication_name, COUNT(p_m.patient_id) AS patients_count
FROM rel_patients_medications AS p_m 
INNER JOIN medications AS m ON m.medication_id = p_m.medication_id
WHERE m.medication_name = 'Aspirin';

/*Nobres de todos los doctores y pacientes que estan en la tabla citas*/
SELECT CONCAT(u.first_name, ' ', u.last_name) AS full_name FROM doctors AS d
INNER JOIN appointments AS a ON d.doctor_id = a.doctor_id
INNER JOIN users AS u ON u.user_id = d.doctor_id
UNION
SELECT CONCAT(u.first_name, ' ', u.last_name) AS full_name FROM patients AS p
INNER JOIN appointments AS a ON p.patient_id = a.patient_id 
INNER JOIN users AS u ON u.user_id = p.patient_id;


/*Consultar pacientes segun estado de atención de cita*/
SELECT
    CONCAT(u.first_name, ' ', u.last_name) AS patient,
    CASE
        WHEN is_attended = 1 THEN 'Atendido'
        WHEN is_attended = 0 THEN 'No Atendido'
    END AS 'State' 
FROM appointments AS a
INNER JOIN patients AS p ON p.patient_id = a.patient_id
INNER JOIN users AS u ON p.patient_id = u.user_id;

