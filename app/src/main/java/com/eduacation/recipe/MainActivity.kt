package com.eduacation.recipe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduacation.recipe.ui.theme.RecipeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Yemek Tarifi") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.main_color),
                    titleContentColor = colorResource(R.color.black)
                )
            )
        },
        content = {

            val context = LocalContext.current

            val foodList = FoodRepository.foodList

            var index by remember { mutableStateOf(0) }

            Column(
                modifier = Modifier.padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ChevronLeft,
                        contentDescription = "Önceki",
                        modifier = Modifier
                            .weight(0.05f)
                            .clickable {
                                if (index > 0) index--
                            },
                    )
                    Image(
                        painter = painterResource(foodList[index].image),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(0.9f)
                            .height(250.dp),
                        contentScale = ContentScale.Crop
                    )
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Önceki",
                        modifier = Modifier
                            .weight(0.05f)
                            .clickable {
                                if (index < foodList.size - 1) index++
                                else index = 0
                            }
                    )
                }



                Row(modifier = Modifier.fillMaxWidth()) {

                    Button(
                        onClick = {
                            Toast.makeText(context, "LÜTFEN ÜYE OLUNUZ", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.main_color),
                            contentColor = colorResource(R.color.black)
                        )
                    ) {
                        Text("Beğen")
                    }
                    Button(
                        onClick = {
                            Toast.makeText(context, "LÜTFEN ÜYE OLUNUZ", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.alternative_color),
                            contentColor = colorResource(R.color.black)
                        )
                    ) {
                        Text("Yorum Yap")
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {

                    Text(
                        text = foodList[index].name,
                        color = colorResource(R.color.alternative_color),
                        fontSize = 18.sp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = foodList[index].category,

                            )
                        Text(
                            text = foodList[index].date
                        )

                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = foodList[index].recipe,
                        modifier = Modifier.padding(10.dp),
                        textAlign = TextAlign.Center
                    )

                }

            }
        }
    )
}