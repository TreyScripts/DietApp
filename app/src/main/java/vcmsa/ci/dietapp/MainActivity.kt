package vcmsa.ci.dietapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val logo = findViewById<ImageView>(R.id.logo)
        val time = findViewById<TextView>(R.id.time)
        val rGroup = findViewById<RadioGroup>(R.id.rGroup)
        val btnMeals = findViewById<Button>(R.id.btnMeals)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnMeals.setOnClickListener {
            val selectedId = rGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val selectedTime = selectedRadioButton.text.toString()

                // Start MealSuggestion.kt and pass the selected meal
                val intent = Intent(this, MealSuggestion::class.java)
                intent.putExtra("SELECTED_MEAL", selectedTime)
                startActivity(intent)

            } else {
                time.text = "Please select a meal time!"
            }
        }

        // Reset button clears selection
        btnReset.setOnClickListener {
            rGroup.clearCheck()
            time.text = ""
        }
    }
}
