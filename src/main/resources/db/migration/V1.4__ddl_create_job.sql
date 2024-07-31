CREATE TABLE jobs
(
    id                   SERIAL PRIMARY KEY,
    title                VARCHAR(255)                        NOT NULL,
    postcode             VARCHAR(255)                        NOT NULL,
    estimated_start_date DATE                                NOT NULL,
    estimated_duration   INT,
    description          VARCHAR(500),
    address              VARCHAR(255),
    zone                 VARCHAR(255),
    type_of_professional VARCHAR(255),
    phone_number         VARCHAR(255),
    status               VARCHAR(45)                         NOT NULL,
    created_date         TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by           VARCHAR(50)                         NOT NULL,
    last_modified_by     VARCHAR(50)                         NOT NULL

);
