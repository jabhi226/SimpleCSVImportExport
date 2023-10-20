package com.example.simplecsvimportexport

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.File

class MainActivity : AppCompatActivity() {
    private val adapter = ReaderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_export).setOnClickListener {
            SimpleCsvImportExport.exportCsv(
                this,
                JSONArray(JsonFile.getDummyJsonFileString()),
                "test"
            )
        }
        findViewById<Button>(R.id.btn_read).setOnClickListener {
            SimpleCsvImportExport.selectCsvFile(this)
        }
    }

    @SuppressLint("Recycle")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SimpleCsvImportExport.OPEN_CSV_FILE_REQUEST_CODE) {
            data?.data?.path?.let {
                val filePath = it.split(":")[1]
                val file = File(filePath)
                val csv = SimpleCsvImportExport.readCsv(file)
                findViewById<RecyclerView>(R.id.tv_csv_content).apply {
                    layoutManager = GridLayoutManager(this.context, csv?.get(0)?.size ?: 1, GridLayoutManager.VERTICAL, false)
                    adapter = this@MainActivity.adapter
                }
                adapter.submitList(csv?.toTypedArray()?.flatten()?.toList())

            }
        }
    }
}