
CREATE SCHEMA IF NOT EXISTS `CLINICAL_RECORD` DEFAULT CHARACTER SET UTF8MB4;
USE `CLINICAL_RECORD`;


-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CLINICAL_RECORD`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) CHARACTER SET 'UTF8MB4' NOT NULL,
  `middle_name` VARCHAR(50) CHARACTER SET 'UTF8MB4' NULL,
  `last_name` VARCHAR(50) CHARACTER SET 'UTF8MB4' NOT NULL,
  `second_last_name` VARCHAR(50) CHARACTER SET 'UTF8MB4' NULL,
  `dni_number` VARCHAR(20) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `email` VARCHAR(100) CHARACTER SET 'UTF8MB4' NOT NULL,
  `phone` VARCHAR(20) CHARACTER SET 'UTF8MB4' NOT NULL,
  `is_active` BOOLEAN NOT NULL CHECK (is_active IN (0, 1)),
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `dni_number_UNIQUE` (`dni_number` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table specialties
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CLINICAL_RECORD`.`specialties` (
  `specialty_id` INT NOT NULL AUTO_INCREMENT,
  `specialty_name` VARCHAR(45) CHARACTER SET 'UTF8MB4' NOT NULL,
  PRIMARY KEY (`specialty_id`),
  UNIQUE INDEX `specialty_name_UNIQUE` (`specialty_name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table doctors
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CLINICAL_RECORD`.`doctors` (
  `doctor_id` INT NOT NULL,
  `specialty_id` INT NOT NULL,
  INDEX `specialty_idx` (`specialty_id` ASC) VISIBLE,
  PRIMARY KEY (`doctor_id`),
  CONSTRAINT `doctor_specialty_fk`
    FOREIGN KEY (`specialty_id`)
    REFERENCES `CLINICAL_RECORD`.`specialties` (`specialty_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `doctor_user_fk`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `CLINICAL_RECORD`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `unique_doctor_user`
    UNIQUE (`doctor_id`)
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table patients
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CLINICAL_RECORD`.`patients` (
  `patient_id` INT NOT NULL,
   `diagnosis` TEXT CHARACTER SET 'UTF8MB4' NOT NULL,
  PRIMARY KEY (`patient_id`),
  CONSTRAINT `patient_user_fk`
    FOREIGN KEY (`patient_id`)
    REFERENCES `CLINICAL_RECORD`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `unique_patient_user`
    UNIQUE (`patient_id`)
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table appointments
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CLINICAL_RECORD`.`appointments` (
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `appointment_date` DATE NOT NULL, 
  `appointment_time` TIME NOT NULL,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  `is_attended`  BOOLEAN NOT NULL CHECK (is_attended IN (0, 1)),
  PRIMARY KEY (`appointment_id`),
  CONSTRAINT `appoinment_doctor_fk`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `CLINICAL_RECORD`.`doctors` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `appoinment_patient_fk`
    FOREIGN KEY (`patient_id`)
    REFERENCES `CLINICAL_RECORD`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table medications
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CLINICAL_RECORD`.`medications` (
  `medication_id` INT NOT NULL AUTO_INCREMENT,
  `medication_name` VARCHAR(100),
  `manufacturer` VARCHAR(100),
  `dosage` VARCHAR(50),
  `administration_route` VARCHAR(50),
  `frequency` VARCHAR(50),
  `indications` TEXT,
  `contraindications` TEXT,
  `sideEffects` TEXT,
  `storage_nstructions` TEXT,
  `expiry_date` DATE,
  PRIMARY KEY (`medication_id`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table rel_patients_medications
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CLINICAL_RECORD`.`rel_patients_medications` (
  `patient_id` INT NOT NULL,
  `medication_id` INT NOT NULL,
  CONSTRAINT `rel_patients_medications_pk` PRIMARY KEY (`patient_id`, `medication_id`),
  CONSTRAINT `rel_patients_medications_fk_patient`
    FOREIGN KEY (`patient_id`)
    REFERENCES `CLINICAL_RECORD`.`patients` (`patient_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `rel_patients_medications_fk_medication`
    FOREIGN KEY (`medication_id`)
    REFERENCES `CLINICAL_RECORD`.`medications` (`medication_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;


