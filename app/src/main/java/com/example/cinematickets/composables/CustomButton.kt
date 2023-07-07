package com.example.cinematickets.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.LightGray
import com.example.cinematickets.ui.theme.TextWhite
import com.example.cinematickets.viewmodel.BaseInteractionListener
import com.example.cinematickets.viewmodel.home.HomeInteractionListener

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    painter: Int,
    pagerState: String = "0",
    backgroundColor: Color = LightGray,
    text: String = "",
    iconTint: Color = TextWhite,
    textColor: Color = Color.White,
    iconPadding: Dp = 8.dp,
    listener: BaseInteractionListener
){
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(color = backgroundColor)
            .clickable {
                listener.onClick(pagerState)
            }
            .padding(iconPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(painter),
            contentDescription = "$text button",
            tint = iconTint
        )
        if(text.isNotEmpty()){
            SpacerHorizontal4()
            Text(
                text = text,
                fontSize = 20.sp,
                color = textColor,
            )
        }
    }
}