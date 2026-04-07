package com.fidel.simba_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        finding ids using view by id from the layout
//        create a variable to store the button

        val recipe=findViewById<Button>(R.id.recipes)

//        set on click listener

        recipe.setOnClickListener {
//            enable our intent or do navigation

            val recipeIntent= Intent(applicationContext, HealthyRecipes::class.java)
            startActivity(recipeIntent)
        }

//        nutrition intent
        val nutrition=findViewById<Button>(R.id.nutrition)

        nutrition.setOnClickListener {

            val nutritionIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(nutritionIntent)

        }

        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {

            val meditationIntent= Intent(applicationContext, Meditation::class.java)

            startActivity(meditationIntent)


        }

        val hydration=findViewById<Button>(R.id.hydration)

        hydration.setOnClickListener {

            val hydrationIntent= Intent(applicationContext, HydrationAlert::class.java)

            startActivity(hydrationIntent)}



        val exercise=findViewById<Button>(R.id.exercise)

        exercise.setOnClickListener {
            val exerciseIntent= Intent(applicationContext, StartExercise::class.java)
            startActivity(exerciseIntent)
        }


        val motivation=findViewById<Button>(R.id.motivation)

        motivation.setOnClickListener {
            val motivationIntent= Intent(applicationContext,DailyMotivation::class.java)
            startActivity(motivationIntent)
        }

        val goals=findViewById<Button>(R.id.goals)

        goals.setOnClickListener {
            val goalsIntent= Intent(applicationContext, WeeklyGoals::class.java)
            startActivity(goalsIntent)
        }

        val progress=findViewById<Button>(R.id.progress)

        progress.setOnClickListener {
            val progressIntent= Intent(applicationContext, CheckProgress::class.java)
            startActivity(progressIntent)
        }




    }
}