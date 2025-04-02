package vcmsa.ci.dietapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MealSuggestion : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_suggestion)

        val heading = findViewById<TextView>(R.id.heading)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestions)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val selectedMeal = intent.getStringExtra("SELECTED_MEAL") ?: "Unknown"

        // Meal suggestions
        val suggestions = mapOf(
            "Morning: Breakfast" to "Pancakes, Omelette, Coffee",
            "Mid-Morning: Snack" to "Fruit Salad, Muesli with Yogurt, Apple",
            "Afternoon: Lunch" to "Lasagna, Fanta Pine",
            "Afternoon Snack: QuickBites" to "Slushy, Nuts, Enchiladas",
            "Dinner: Main course" to "Wings, Chips, Milkshake",
            "After Dinner Snack" to "Nachos, Cranberry Juice, Waffles and Ice Cream"
        )

        // Display the suggestion
        mealSuggestion.text = "Suggested meals for $selectedMeal: ${suggestions[selectedMeal] ?: "No suggestion available"}"

        // Back button returns to MainActivity
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Prevents going back to MealSuggestion
        }
    }
}
