CREATE TABLE course
(
    id         VARCHAR NOT NULL,
    NAME       VARCHAR(255),
    rate       INT2 NOT NULL,
    workload   INT4 NOT NULL,
    teacher_id VARCHAR,

    PRIMARY KEY (id)
);

CREATE TABLE teacher
(
    id         VARCHAR NOT NULL,
    email      VARCHAR(255),
    NAME       VARCHAR(255),
    pictureurl VARCHAR(255),
    detail  jsonb,
    PRIMARY KEY (id)
);

