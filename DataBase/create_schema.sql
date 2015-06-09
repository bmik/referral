CREATE TABLE referral (
	id					serial,
	client_id			varchar(100) not null,
	referral_code		varchar(20) not null,
	create_date			timestamp not null,
	examination_date	timestamp,
	examination_id		int not null,
	status				varchar(20) not null
);

CREATE TABLE examination (
	id					serial,
	code				varchar(10),
	name				varchar(255)
);

CREATE TABLE status (
	status				varchar(20) not null
);

CREATE TABLE examination_result (
	id					serial,
	referral_id			int not null,
	parameter_name		varchar(100),
	parameter_value		varchar(255),
	parameter_unit		varchar(20),
	comment				text
);

ALTER TABLE referral ADD CONSTRAINT pk_ref
PRIMARY KEY (id);

ALTER TABLE examination ADD CONSTRAINT pk_exam
PRIMARY KEY (id);

ALTER TABLE status ADD CONSTRAINT pk_status
PRIMARY KEY (status);

ALTER TABLE examination_result ADD CONSTRAINT pk_exam_res
PRIMARY KEY (id);

ALTER TABLE referral ADD CONSTRAINT fk_ref_status
FOREIGN KEY (status) REFERENCES status(status);

ALTER TABLE referral ADD CONSTRAINT fk_ref_exam
FOREIGN KEY (examination_id) REFERENCES examination(id);

ALTER TABLE examination_result ADD CONSTRAINT fk_exam_ref
FOREIGN KEY (referral_id) REFERENCES referral(id);