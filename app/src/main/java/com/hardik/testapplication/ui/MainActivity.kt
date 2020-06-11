package com.hardik.testapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.hardik.testapplication.R
import java.util.Arrays

class MainActivity : AppCompatActivity() {

  private val txtArraySize by bindView<AppCompatTextView>(R.id.txt_array_size)
  private val txtArray by bindView<AppCompatTextView>(R.id.txt_array)
  private val txtNumber by bindView<AppCompatTextView>(R.id.txt_number)
  private val btnFindNumber by bindView<AppCompatButton>(R.id.btn_find_number)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val integers = intArrayOf(1, 3, 6, 4, 1, 2)

    txtArraySize.text =
      String.format("%s : %d", getString(R.string.str_size_of_array), integers.size)

    txtArray.text = String.format("Array Elements : %s",Arrays.toString(integers))

    btnFindNumber.setOnClickListener {

      val number = findSmallestNumber(integers)
      txtNumber.text = String.format("The Smallest Positive Integer : %s", number.toString())
    }
  }

  private fun findSmallestNumber(arrayElement: IntArray): Int {
    Arrays.sort(arrayElement)
    var i = 1
    var j = 0
    while (j < arrayElement.size) {
      if (arrayElement[j] == i) {
        i++
      }
      j++
    }
    return i
  }
}
