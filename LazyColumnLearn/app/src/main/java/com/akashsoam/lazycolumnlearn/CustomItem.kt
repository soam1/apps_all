package com.akashsoam.lazycolumnlearn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akashsoam.lazycolumnlearn.model.Person

@Composable
fun CustomItem(person: Person) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
        )

    }
}