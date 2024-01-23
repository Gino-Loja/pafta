package com.example.pafta.ui.prediccion

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

import com.example.pafta.R
import com.example.pafta.ui.historial.Historial
import com.example.pafta.ui.home.Inicio
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class Predicciones : AppCompatActivity() {

   private lateinit var lineChart:LineChart
    lateinit var xValues:List<String>
    private lateinit var datasets: List<LineDataSet>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_predicciones)

        findViewById<ImageView>(R.id.ivImagen).setOnClickListener {
            val intent = Intent(this, Historial::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.bInicioPrediccion).setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
            finish()
        }

        lineChart = findViewById(R.id.chart)
        var descripcion: Description = Description()
        descripcion.text =  "Clasificación: Alto, Medio, Bajo"

        descripcion.setPosition(0f, 0f)
        lineChart.description = descripcion
        lineChart.axisRight.setDrawLabels(false)

        xValues = listOf("Semana1", "Semana2", "Seman3","Semana4")

        var xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.valueFormatter = IndexAxisValueFormatter(xValues)
        xAxis.labelCount = 4
        xAxis.granularity = 1f




        var yAxis = lineChart.axisLeft
        yAxis.mAxisMaximum = 0f
        yAxis.mAxisMinimum = 3f
        yAxis.axisLineWidth = 1f
        yAxis.axisLineColor = Color.BLACK
        yAxis.labelCount = 1
        val entries = mutableListOf<Entry>()
        val entries2 = mutableListOf<Entry>()
        val entries3 = mutableListOf<Entry>()

        // Datos de ejemplo (x, y)
        entries.add(Entry(0f, 1f))
        entries.add(Entry(1f, 2f))
        entries.add(Entry(2f, 3f))
        entries.add(Entry(3f, 1f))

        entries2.add(Entry(0f, 3f))
        entries2.add(Entry(1f, 1f))
        entries2.add(Entry(2f, 2f))
        entries2.add(Entry(3f, 3f))

        entries3.add(Entry(0f, 2f))
        entries3.add(Entry(1f, 2f))
        entries3.add(Entry(2f, 2f))
        entries3.add(Entry(3f, 3f))

        var dataset = LineDataSet(entries, "Estacion1")
        var dataset2 = LineDataSet(entries2, "Estacion2")
        var dataset3= LineDataSet(entries3, "Estacion3")

        dataset3.color = Color.BLACK
        dataset.color = Color.BLUE

        datasets = listOf(dataset, dataset2, dataset3)

        var lineData = LineData(dataset, dataset2, dataset3)
        lineChart.data = lineData



        lineChart.invalidate()
        yAxis.valueFormatter = CustomYAxisValueFormatter()

        lineChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                // Aquí puedes obtener información sobre el valor seleccionado
                val dataSetIndex = h?.dataSetIndex ?: 0
                val dataSetLabel = lineChart.data.getDataSetByIndex(dataSetIndex).label

                Log.d("SMS","Valor seleccionado en el conjunto de datos: $dataSetLabel" )
                println("Valor seleccionado en el conjunto de datos: $dataSetLabel")

                // Ocultar las demás estaciones y mostrar solo la seleccionada
                for (i in datasets.indices) {
                    datasets[i].isVisible = (i == dataSetIndex)
                }

                // Actualizar la vista del gráfico
                lineChart.invalidate()
            }

            override fun onNothingSelected() {
                // Se llama cuando no hay nada seleccionado
            }
        })


    }

    inner class CustomYAxisValueFormatter : ValueFormatter() {
        override fun getFormattedValue(value: Float): String {
            return when {
                value == 3f -> "Alto"
                value == 2f -> "Medio"
                else -> "Bajo"
            }
        }
    }


}