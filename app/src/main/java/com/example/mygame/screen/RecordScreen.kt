package com.example.mygame.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mygame.model.Records
import com.example.mygame.sharedpreferences.MySharedPreferences
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

@SuppressLint("CheckResult", "CommitPrefEdits")
@Composable
fun RecordScreen(record: Records) {
    val type = object : TypeToken<MutableList<Records>>() {}.type
    val gson = Gson()
    val sh = MySharedPreferences.getInstance(LocalContext.current)
    val edit = sh.edit()
    val records = sh.getString("recordList", "")

    Log.d("TAG", "RecordScreen: ${record.score}")

    val recordList: MutableList<Records>
    if (records == "") {
        recordList = mutableListOf()
        recordList.add(record)
        edit.putString("recordList", gson.toJson(recordList)).apply()
    } else {
        recordList = gson.fromJson(records, type)
        val level1List: MutableList<Records> = recordList.filter { it.level == 1 }.toMutableList()
        val level2List: MutableList<Records> = recordList.filter { it.level == 2 }.toMutableList()
        val level3List: MutableList<Records> = recordList.filter { it.level == 3 }.toMutableList()


        if (record.level == 1) {
            recordList.forEach {
                if (level1List.size <= 3) {

                    recordList.add(record)
                    edit.putString("recordList", gson.toJson(recordList)).apply()
                }
                if (it.score < record.score && it.level == 1) {
                    recordList.remove(it)
                    recordList.add(record)
                    edit.putString("recordList", gson.toJson(recordList)).apply()
                }
            }
        }
        if (record.level == 2) {
            recordList.forEach {
                if (level2List.size <= 3) {
                    recordList.add(record)
                    edit.putString("recordList", gson.toJson(recordList)).apply()
                }
                if (it.score < record.score &&  it.level == 2) {
                    recordList.remove(it)
                    recordList.add(record)
                    edit.putString("recordList", gson.toJson(recordList)).apply()
                }
            }
        }
        if (record.level == 3) {
            if (level3List.size <= 3) {
                recordList.add(record)
                edit.putString("recordList", gson.toJson(recordList)).apply()
            }
            recordList.forEach {
                if (it.score < record.score && it.level == 3) {
                    recordList.remove(it)
                    recordList.add(record)
                    edit.putString("recordList", gson.toJson(recordList)).apply()
                }
            }
        }

    }
    val level1List: MutableList<Records> = recordList.filter { it.level == 1 }.toMutableList()
    val level2List: MutableList<Records> = recordList.filter { it.level == 2 }.toMutableList()
    val level3List: MutableList<Records> = recordList.filter { it.level == 3 }.toMutableList()








    Column(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp, start = 16.dp, end = 16.dp),
    ) {
        ItemRecord("Level - 1",level1List, Color(0xFFFF9800))
        ItemRecord("Level - 2",level2List, Color(0xFFFF5722))
        ItemRecord("Level - 3",level3List, Color(0xFFE91E63))
    }


}

@Composable
fun ItemRecord(levelText:String, list:MutableList<Records>, color: Color){

    if (list.isNotEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = color)
                .padding(12.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = levelText,
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 33.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        for (record in list.sortedByDescending { it.score }.take(3)) {
            Row {
                Text(
                    text = "Score: ${record.score}",
                    modifier = Modifier
                        .padding(8.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                )

            }
        }
    }
}