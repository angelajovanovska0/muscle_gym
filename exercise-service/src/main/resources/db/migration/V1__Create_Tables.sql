CREATE TABLE WorkoutPlans (
    id SERIAL PRIMARY KEY,
    isPublic BOOLEAN NOT NULL DEFAULT FALSE,
    user_id VARCHAR(255) NOT NULL
);

CREATE TABLE Exercises (
    id VARCHAR(255) PRIMARY KEY,
    targetMuscle VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    gifUrl TEXT,
    equipment VARCHAR(255),
    bodyPart VARCHAR(255),
    secondaryMuscles VARCHAR(255),
    instructions TEXT
);

CREATE TABLE UserLikedExercises (
    userId VARCHAR(255) NOT NULL,
    exerciseId VARCHAR(255) NOT NULL,
    PRIMARY KEY (userId, exerciseId),
    FOREIGN KEY (exerciseId) REFERENCES Exercises(id)
);

CREATE TABLE WorkoutPlanExercises (
    workoutPlanId INT NOT NULL,
    exerciseId VARCHAR(255) NOT NULL,
    PRIMARY KEY (workoutPlanId, exerciseId),
    FOREIGN KEY (workoutPlanId) REFERENCES WorkoutPlans(id),
    FOREIGN KEY (exerciseId) REFERENCES Exercises(id)
);