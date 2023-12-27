package com.taserelec.myinventoryandroid
//import android.widget.Button
//import androidx.compose.material.Text
//import androidx.constraintlayout.widget.ConstraintLayout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, textField, imagen) = createRefs()

        var greetingText by remember { mutableStateOf("Hola: toca aquí para saludar") }
        var etName by remember { mutableStateOf("") }
        // var etName = ""
        var showImage by remember { mutableStateOf(true) }
        Box(modifier = Modifier
            .padding(top = 10.dp)
            .constrainAs(textField) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                //bottom.linkTo(parent.top)
            }) {
            //Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            // Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(

                value = etName,
                onValueChange = { etName = it },
                label={ Text(text = "Escriba su nombre aquí")}
            )
        }
        //Spacer(modifier = Modifier.height(25.dp))
        Box(modifier = Modifier
            .padding(top = 10.dp)
            .constrainAs(button) {
                top.linkTo(textField.bottom)
                start.linkTo(textField.start)
                end.linkTo(textField.end)
            }) {
            Button(onClick = {
                greetingText = "Hola"
                showImage = !showImage
            }) {
                if(etName.contains("juambe")or etName.contains("Juambe") ){
                Text("$etName la Herencia es para el mes que viene")}
            else{
            Text("$greetingText: $etName ")}
        }
        }
        Box(modifier = Modifier
            .constrainAs(imagen) {
                bottom.linkTo(parent.bottom)
                start.linkTo(button.start)
                end.linkTo(button.end)
            }) {
            AnimatedVisibility(showImage) {
                Image(
                    painterResource(id = R.drawable.compose_multiplatform),
                    null
                )
            }
        }
    }
}