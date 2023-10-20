package com.example.simplecsvimportexport

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.os.Environment
import androidx.core.app.ActivityCompat.startActivityForResult
import com.opencsv.CSVReader
import com.opencsv.CSVWriter
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.Date


object SimpleCsvImportExport {

    const val OPEN_CSV_FILE_REQUEST_CODE = 101

    fun exportCsv(
        context: Context,
        jsonArray: JSONArray,
        fileName: String
    ) {
        val f = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "${fileName.trim()}${Date().time}.csv"
        )
        val writer: CSVWriter = if (f.exists() && !f.isDirectory) {
            CSVWriter(FileWriter(f.absolutePath, true))
        } else {
            CSVWriter(FileWriter(f.absolutePath))
        }
        val arrayList = ArrayList<Array<String>>()
        for (i in 0 until jsonArray.length()) {
            val header = arrayListOf<String>()
            val values = arrayListOf<String>()
            val obj = JSONObject(jsonArray[i].toString())
            for (key in obj.keys()) {
                if (i == 0)
                    header.add(key)
                values.add(obj.optString(key))
            }
            if (i == 0)
                arrayList.add(header.toTypedArray())
            arrayList.add(values.toTypedArray())
        }
        writer.writeAll(arrayList)
        writer.close()
        context.startActivity(Intent(DownloadManager.ACTION_VIEW_DOWNLOADS))
    }

    fun selectCsvFile(
        activity: Activity,
        requestCode: Int = OPEN_CSV_FILE_REQUEST_CODE
    ) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
//        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        startActivityForResult(
            activity,
            Intent.createChooser(intent, "Open CSV"),
            requestCode,
            null
        )
    }

    fun readCsv(
        file: File
    ): MutableList<Array<String>>? {
        return try {
            val reader = CSVReader(FileReader(file))
            reader.readAll()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
