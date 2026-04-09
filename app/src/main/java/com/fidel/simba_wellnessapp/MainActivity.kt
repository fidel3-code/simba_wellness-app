package com.fidel.simba_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

//    A variable to store our interstitial ad

    private var mInterstitialAd: InterstitialAd?= null






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


//starts the Google AdMob SDK
//prepares your app to load ads
// Must be called before showing ads
        MobileAds.initialize(this)

//Get the Adview from layout   Connects your Kotlin code to the ad view in XML   R.id.adView=the banner ad you placed in your layout
        val adView = findViewById<AdView>(R.id.adView)

//Creates a request asking AdMob for an ad  You can customize it
        val adRequest = AdRequest.Builder().build()

//Load the ad  Sends request to admob
        adView.loadAd(adRequest)

//        call the function to load the ad from the server

        loadInterstitialAd()





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

//            show your interstitial ad here
            showInterstitialAd()
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

    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }
}