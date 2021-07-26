package com.example.a7minutesworkoutapp

class Constants {
    companion object{
        fun defaultExerciseList():ArrayList<ExerciseModel>{
            val exerciseList = ArrayList<ExerciseModel>()

            val jumpingJacks = ExerciseModel(
                1,
                "Jumping Jacks",
                "file:///android_asset/ic_jumping_jacks.gif",
                false,
                false,
                "https://www.insider.com/jumping-jacks-benefits"
                )
            exerciseList.add(jumpingJacks)

            val wallSit = ExerciseModel(
                2,
                "Wall Sit",
                "file:///android_asset/ic_wall_sit.gif",
                false,
                false,
                "https://www.anytimefitness.com/ccc/how-to/how-to-do-a-perfect-wall-sit-boost-it/"
                )
            exerciseList.add(wallSit)

            val pushUp = ExerciseModel(
                3, "Push Up",
                "file:///android_asset/ic_push_up.gif",
                false,
                false,
                "https://www.verywellfit.com/the-push-up-exercise-3120574"
            )
            exerciseList.add(pushUp)

            val abdominalCrunch = ExerciseModel(
                4,
                "Abdominal Crunch",
                "file:///android_asset/ic_abdominal_crunch.gif",
                false,
                false,
                "https://www.verywellfit.com/how-to-do-a-perfect-abdominal-crunch-1229513"
            )
            exerciseList.add(abdominalCrunch)

            val stepUpOnChair = ExerciseModel(
                    5,
                    "Step-Up onto Chair",
                "file:///android_asset/ic_step_up_onto_chair.gif",
                    false,
                    false,
                "https://www.hip.fit/e/step-up-onto-chair")
            exerciseList.add(stepUpOnChair)

            val squat = ExerciseModel(
                6,
                "Squat",
                "file:///android_asset/ic_squat.gif",
                false,
                false,
                "https://www.verywellfit.com/squats-for-the-buns-hips-and-thighs-1231102")
            exerciseList.add(squat)

            val tricepsDipOnChair = ExerciseModel(
                    7,
                    "Triceps Dip On Chair",
                "file:///android_asset/ic_triceps_dip_on_chair.gif",
                    false,
                    false,
                "https://www.healthline.com/health/chair-dips"
                )
            exerciseList.add(tricepsDipOnChair)

            val plank = ExerciseModel(
                8,
                "Plank",
                "file:///android_asset/ic_plank.gif",
                false,
                false,
            "https://www.verywellfit.com/the-plank-exercise-3120068")
            exerciseList.add(plank)

            val highKneesRunningInPlace = ExerciseModel(
                9,
                "High Knees Running In Place",
                "file:///android_asset/ic_high_knees_running_in_place.gif",
                false,
                false,
            "https://www.healthline.com/health/fitness-exercise/running-in-place")
            exerciseList.add(highKneesRunningInPlace)

            val lunges = ExerciseModel(
                10, "Lunges",
                "file:///android_asset/ic_lunge.gif",
                false,
                false,
            "https://www.healthline.com/health/fitness-exercise/lunges-muscles-worked")
            exerciseList.add(lunges)

            val pushupAndRotation =
                ExerciseModel(
                    11,
                    "Push up and Rotation",
                    "file:///android_asset/ic_push_up_and_rotation.gif",
                    false,
                    false,
                "https://evofitness.at/en/tutorial-push-up-with-rotation/")
            exerciseList.add(pushupAndRotation)

            val sidePlank = ExerciseModel(
                12,
                "Side Plank",
                "file:///android_asset/ic_side_plank.gif",
                false,
                false,
                "https://www.coachmag.co.uk/abs-workouts-and-exercises/6340/side-plank-the-best-abs-move-you-re-probably-not-doing"
            )
            exerciseList.add(sidePlank)
            return exerciseList
        }

    }

}