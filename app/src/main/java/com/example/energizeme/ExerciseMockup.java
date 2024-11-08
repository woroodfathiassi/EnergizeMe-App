package com.example.energizeme;

import java.util.ArrayList;
import java.util.List;

public class ExerciseMockup {
    List<Exercise> exercisesList;

    public ExerciseMockup() {
        exercisesList = new ArrayList<>();

//        exercisesList.add(new Exercise("Burpees", "Aerobic (Cardiovascular)", "", R.drawable.burpees));
//        exercisesList.add(new Exercise("Jumping Jacks", "Aerobic (Cardiovascular)", "", R.drawable.jumpingjacks));
//        exercisesList.add(new Exercise("Mountain Climbers", "Aerobic (Cardiovascular)", "", R.drawable.mountainclimbers));
//        exercisesList.add(new Exercise("High Knees", "Aerobic (Cardiovascular)", "", R.drawable.highknees));
//
//        exercisesList.add(new Exercise("Abdominal muscles", "Core", "", R.drawable.abdominalmuscles));
//        exercisesList.add(new Exercise("Leg Raises", "Core", "", R.drawable.legraises));
//        exercisesList.add(new Exercise("Russian Twists", "Core", "", R.drawable.russiantwists));
//        exercisesList.add(new Exercise("Stability ball", "Core", "", R.drawable.stabilityball));
//        exercisesList.add(new Exercise("Bicycle Crunches", "Core", "", R.drawable.bicyclecrunches));
//
//        exercisesList.add(new Exercise("Foam Rolling", "Flexibility and Balance", "", R.drawable.foamrolling));
//        exercisesList.add(new Exercise("Revolved Chair Pose", "Flexibility and Balance", "", R.drawable.revolvedchairpose));
//        exercisesList.add(new Exercise("Static Stretching", "Flexibility and Balance", "", R.drawable.staticstretching));
//        exercisesList.add(new Exercise("Warrior III Pose", "Flexibility and Balance", "", R.drawable.warrioriiipose));
//
//        exercisesList.add(new Exercise("Lunges", "Strength Training", "", R.drawable.lunges));
//        exercisesList.add(new Exercise("Plank to Push-Up", "Strength Training", "", R.drawable.planktopushup));
//        exercisesList.add(new Exercise("Pressure on the wall", "Strength Training", "", R.drawable.pressureonthewall));
//        exercisesList.add(new Exercise("Push-Ups", "Strength Training", "", R.drawable.pushups));
//        exercisesList.add(new Exercise("Resistance band ", "Strength Training", "", R.drawable.resistanceband));
//        exercisesList.add(new Exercise("Squat tuck jump", "Strength Training", "", R.drawable.squattuckjump));
//        exercisesList.add(new Exercise("Tricep Dips", "Strength Training", "", R.drawable.tricepdip));


        exercisesList.add(new Exercise("Burpees", "Aerobic (Cardiovascular)",
                "Purpose: Full-body cardio exercise that builds strength and endurance.\n\n" +
                        "How to do it: Start standing, squat down, place your hands on the floor, jump back to a plank, do a push-up, jump feet forward, and jump up.",
                R.drawable.burpees, R.drawable.burpees2));

        exercisesList.add(new Exercise("Jumping Jacks", "Aerobic (Cardiovascular)",
                "Purpose: Boosts heart rate and burns calories.\n\n" +
                        "How to do it: Start standing, jump while spreading your legs and raising your arms overhead, then return to the starting position.",
                R.drawable.jumpingjacks, R.drawable.jumpingjacks2));

        exercisesList.add(new Exercise("Mountain Climbers", "Aerobic (Cardiovascular)",
                "Purpose: Engages core and provides cardio benefits.\n\n" +
                        "How to do it: Start in a plank position, drive your knees towards your chest alternately in a running motion without lifting your hips.",
                R.drawable.mountainclimbers, R.drawable.mountainclimbers2));

        exercisesList.add(new Exercise("High Knees", "Aerobic (Cardiovascular)",
                "Purpose: Increases heart rate and strengthens leg muscles.\n\n" +
                        "How to do it: Stand tall, then run in place while lifting your knees as high as possible with each step.",
                R.drawable.highknees, R.drawable.highknees2));

        exercisesList.add(new Exercise("Abdominal Muscles", "Core",
                "Purpose: Strengthens and stabilizes the core muscles.\n\n" +
                        "How to do it: Can include exercises like crunches, planks, and leg raises focused on engaging the abdominal muscles.",
                R.drawable.abdominalmuscles,R.drawable.abdominalmuscles2));

        exercisesList.add(new Exercise("Leg Raises", "Core",
                "Purpose: Targets the lower abdominal muscles.\n\n" +
                        "How to do it: Lie on your back with your legs straight, then lift your legs up to 90 degrees and slowly lower them without touching the ground.",
                R.drawable.legraises, R.drawable.legraises2));

        exercisesList.add(new Exercise("Russian Twists", "Core",
                "Purpose: Builds oblique strength and rotational stability.\n\n" +
                        "How to do it: Sit with knees bent, lean back slightly, hold your hands together or a weight, and twist side to side while engaging your core.",
                R.drawable.russiantwists, R.drawable.russiantwists));

        exercisesList.add(new Exercise("Stability Ball", "Core",
                "Purpose: Enhances core stability and balance.\n\n" +
                        "How to do it: Can include exercises like stability ball crunches or planks, using a ball to engage core muscles deeply.",
                R.drawable.stabilityball, R.drawable.stabilityball2));

        exercisesList.add(new Exercise("Bicycle Crunches", "Core",
                "Purpose: Targets obliques and core muscles.\n\n" +
                        "How to do it: Lie on your back, bring one knee toward your chest while lifting the opposite elbow to meet it, alternating sides like pedaling.",
                R.drawable.bicyclecrunches, R.drawable.bicyclecrunches2));

        exercisesList.add(new Exercise("Foam Rolling", "Flexibility and Balance",
                "Purpose: Relieves muscle tension and enhances flexibility.\n\n" +
                        "How to do it: Place a foam roller under the muscle you want to massage, roll back and forth slowly, applying pressure to release tension.",
                R.drawable.foamrolling, R.drawable.foamrolling2));

        exercisesList.add(new Exercise("Revolved Chair Pose", "Flexibility and Balance",
                "Purpose: Strengthens legs, improves flexibility, and challenges balance.\n\n" +
                        "How to do it: Start in a squat with hands at heart center, twist your torso and hook one elbow outside the opposite knee, hold the pose.",
                R.drawable.revolvedchairpose, R.drawable.revolvedchairpose2));

        exercisesList.add(new Exercise("Static Stretching", "Flexibility and Balance",
                "Purpose: Lengthens muscles and increases flexibility.\n\n" +
                        "How to do it: Hold a stretch position for 15-30 seconds without movement, focusing on areas like hamstrings, calves, and shoulders.",
                R.drawable.staticstretching, R.drawable.staticstretching2));

        exercisesList.add(new Exercise("Warrior III Pose", "Flexibility and Balance",
                "Purpose: Improves balance, strengthens legs, and stretches hamstrings.\n\n" +
                        "How to do it: Stand on one leg, lean forward, lift the other leg straight back, and extend your arms forward to form a straight line.",
                R.drawable.warrioriiipose, R.drawable.warrioriiipose2));

        exercisesList.add(new Exercise("Lunges", "Strength Training",
                "Purpose: Strengthens legs and glutes.\n\n" +
                        "How to do it: Step forward with one leg, lower your hips until both knees are bent at 90 degrees, push back up to the starting position.",
                R.drawable.lunges, R.drawable.lunges2));

        exercisesList.add(new Exercise("Plank to Push-Up", "Strength Training",
                "Purpose: Strengthens core, chest, and arms.\n\n" +
                        "How to do it: Start in a plank, lower one arm at a time to an elbow plank, then push back up to a full plank one arm at a time.",
                R.drawable.planktopushup, R.drawable.planktopushup2));

        exercisesList.add(new Exercise("Wall Press", "Strength Training",
                "Purpose: Strengthens chest and shoulders.\n\n" +
                        "How to do it: Stand facing a wall, place your hands on it at shoulder height, then push yourself back and forth, simulating a push-up motion.",
                R.drawable.pressureonthewall, R.drawable.pressureonthewall2));

        exercisesList.add(new Exercise("Push-Ups", "Strength Training",
                "Purpose: Builds chest, shoulders, and triceps.\n\n" +
                        "How to do it: Start in a plank, lower your body until your chest nearly touches the floor, then push back up to the starting position.",
                R.drawable.pushups, R.drawable.pushups2));

        exercisesList.add(new Exercise("Resistance Band", "Strength Training",
                "Purpose: Strengthens various muscle groups.\n\n" +
                        "How to do it: Use a resistance band for exercises like bicep curls, rows, or lateral raises by holding it and stretching against its resistance.",
                R.drawable.resistanceband, R.drawable.resistanceband2));

        exercisesList.add(new Exercise("Squat Tuck Jump", "Strength Training",
                "Purpose: Builds leg strength and explosive power.\n\n" +
                        "How to do it: Perform a squat, then jump up explosively while tucking your knees towards your chest, land softly, and repeat.",
                R.drawable.squattuckjump, R.drawable.squattuckjump2));

        exercisesList.add(new Exercise("Tricep Dips", "Strength Training",
                "Purpose: Targets triceps for arm strength.\n\n" +
                        "How to do it: Sit on the edge of a bench, place hands beside you, slide forward, and lower your body by bending elbows, then push back up.",
                R.drawable.tricepdip, R.drawable.tricepdip2));
    }

    public List<String> getExerciseTypes(){
        List<String> types = new ArrayList<>();
        for (Exercise exercise : exercisesList) {
            if (!types.contains(exercise.getType())){
                types.add(exercise.getType());
            }
        }
        return  types;
    }

    public List<Exercise> getItemsObj(String type){
        List<Exercise> exercises = new ArrayList<>();
        for (Exercise exercise : exercisesList) {
            if (exercise.getType().equals(type)) {
                exercises.add(exercise);
            }
        }
        return exercises;
    }

    public Exercise getExercise(String type, int index){
        List<Exercise> exercises = getItemsObj(type);
        return exercises.get(index);
    }

    public List<String> getItemsStr(String type){
        List<String> exercises = new ArrayList<>();
        for (Exercise exercise : exercisesList) {
            if (exercise.getType().equals(type)) {
                exercises.add(exercise.toString());
            }
        }
        return exercises;
    }
}
