package com.habits.twenty1.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habits.twenty1.presentation.ui.theme.Dimen

@Composable
fun ActionCenter(modifier: Modifier = Modifier,
                 hitButtonState : Boolean,
                 standButtonState : Boolean,
                 doubleDownButtonState : Boolean,
                 splitButtonState : Boolean,
                 onHit: () -> Unit,
                 onStand:() -> Unit,
                 onDoubleDown:()->Unit,
                 onSplit: () ->Unit
                 )
{
    Column(modifier = modifier.padding(2.dp)) {
        Column(modifier = modifier.padding(4.dp)) {
            Row(horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp))
            {
                Box(modifier = Modifier
                    .background(
                      color = if(hitButtonState) Color.Gray else Color.Blue,
                      shape = RoundedCornerShape(Dimen.Action.radius)
                    )
                    .border(
                        Dimen.Action.border,
                        MaterialTheme.colorScheme.tertiary,
                        RoundedCornerShape(Dimen.Action.radius)
                    )
                    .fillMaxWidth(0.5f)
                    .height(50.dp)
                )
                {
                    Button(
                        modifier = Modifier.fillMaxSize(),
                        enabled = hitButtonState,
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = Color.Black,
                            disabledContentColor = Color.Gray,
                            disabledContainerColor = Color.Black
                            ),
                        shape = RoundedCornerShape(Dimen.ActionButton.radius),
                        onClick = onHit)
                    {
                        Text(
                            text = "Hit",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
                Box(modifier = Modifier
                    .background(
                      color = if(standButtonState) Color.Gray else Color.Blue,
                      shape = RoundedCornerShape(Dimen.Action.radius)
                    )
                    .border(
                        Dimen.Action.border,
                        MaterialTheme.colorScheme.tertiary,
                        RoundedCornerShape(Dimen.Action.radius)
                    )
                    .fillMaxWidth()
                    .height(50.dp)
                ){
                    Button(
                        enabled = standButtonState,
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(Dimen.ActionButton.radius),
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = Color.Black,
                            disabledContentColor = Color.Gray,
                            disabledContainerColor = Color.Black
                        ),
                        onClick = onStand)
                    {
                        Text(
                            text = "Stand",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
        Column(modifier = modifier.padding(4.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp))
            {
                Box(modifier = Modifier
                    .background(
                      color = if(doubleDownButtonState) Color.Gray else Color.Blue,
                      shape = RoundedCornerShape(Dimen.Action.radius)
                    )
                    .border(
                        Dimen.Action.border,
                        MaterialTheme.colorScheme.tertiary,
                        RoundedCornerShape(Dimen.Action.radius)
                    )
                    .fillMaxWidth(0.5f)
                    .height(50.dp)
                )
                {
                    Button(
                        enabled = doubleDownButtonState,
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(Dimen.ActionButton.radius),
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = Color.Black,
                            disabledContentColor = Color.Gray,
                            disabledContainerColor = Color.Black
                        ),
                        onClick = onDoubleDown)
                    {
                        Text(
                            text = "Double Down",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
                Box(modifier = Modifier
                    .border(
                        Dimen.Action.border,
                        MaterialTheme.colorScheme.tertiary,
                        RoundedCornerShape(Dimen.Action.radius)
                    )
                    .fillMaxWidth()
                    .height(50.dp)
                ){
                    Button(
                        enabled = splitButtonState,
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(Dimen.ActionButton.radius),
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = Color.Black,
                            disabledContentColor = Color.Gray,
                            disabledContainerColor = Color.Black
                        ),
                        onClick = onSplit)
                    {
                        Text(
                            text = "Split",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun ActionCenterPreview()
{
//    ActionCenter()
}