package com.example.chat.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chat.domain.model.Message

@Composable
fun MessageItem(item: Message, backgroundColor: Color, textColor: Color) {

    Card(
        modifier = Modifier
            .height(75.dp)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        backgroundColor = backgroundColor,
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small.copy(CornerSize(100))
    ) {
        Row {
            Text(
                text = checkNotNull(item.data), color = textColor,
                modifier = Modifier.padding(start = 12.dp, top = 18.dp, bottom = 5.dp),
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = checkNotNull(item.message), color = textColor,
                modifier = Modifier.padding(start = 8.dp, top = 18.dp, bottom = 5.dp),
                maxLines = 1
            )

            Text(
                text = checkNotNull("(" + item.nickname + ")      "), color = textColor,
                modifier = Modifier.padding(start = 8.dp, top = 18.dp, bottom = 5.dp),
                maxLines = 1
            )
        }
    }
}