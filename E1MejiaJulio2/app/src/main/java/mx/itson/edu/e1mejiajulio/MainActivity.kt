package mx.itson.edu.e1mejiajulio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var etOriginalPrice: EditText
    private lateinit var tvPercentageValue: TextView
    private lateinit var tvTotalValue: TextView
    private var selectedPercentage: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etOriginalPrice = findViewById(R.id.etOriginalPrice)
        tvPercentageValue = findViewById(R.id.tvPercentageValue)
        tvTotalValue = findViewById(R.id.tvTotalValue)


        findViewById<Button>(R.id.btn10).setOnClickListener { setPercentage(10.0) }
        findViewById<Button>(R.id.btn15).setOnClickListener { setPercentage(15.0) }
        findViewById<Button>(R.id.btn20).setOnClickListener { setPercentage(20.0) }
        findViewById<Button>(R.id.btn25).setOnClickListener { setPercentage(25.0) }
        findViewById<Button>(R.id.btn30).setOnClickListener { setPercentage(30.0) }
        findViewById<Button>(R.id.btn40).setOnClickListener { setPercentage(40.0) }


        findViewById<Button>(R.id.btnTip).setOnClickListener { calculateTotal(isTip = true) }
        findViewById<Button>(R.id.btnDiscount).setOnClickListener { calculateTotal(isTip = false) }
    }

    // Función para establecer el porcentaje seleccionado
    private fun setPercentage(percentage: Double) {
        selectedPercentage = percentage
        tvPercentageValue.text = String.format("%.2f", percentage)
    }

    // Función para calcular el total basado en si es propina o descuento
    private fun calculateTotal(isTip: Boolean) {
        val originalPrice = etOriginalPrice.text.toString().toDoubleOrNull()
        if (originalPrice != null) {
            // Calcula el monto del porcentaje
            val percentageAmount = originalPrice * (selectedPercentage / 100)
            // Calcula el total dependiendo si es tip (suma) o discount (resta)
            val total = if (isTip) {
                originalPrice + percentageAmount
            } else {
                originalPrice - percentageAmount
            }
            // Muestra el total calculado
            tvTotalValue.text = String.format("%.2f", total)
        }
    }
}
