CREATE TABLE Exercise_secondary_muscles (
    exercise_id VARCHAR(255) NOT NULL,
    muscle TEXT NOT NULL,
    FOREIGN KEY (exercise_id) REFERENCES Exercises(id) ON DELETE CASCADE
);

CREATE TABLE Exercise_instructions (
    exercise_id VARCHAR(255) NOT NULL,
    instruction TEXT NOT NULL,
    FOREIGN KEY (exercise_id) REFERENCES Exercises(id) ON DELETE CASCADE
);