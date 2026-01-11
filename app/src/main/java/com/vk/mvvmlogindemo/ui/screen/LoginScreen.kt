package com.vk.mvvmlogindemo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(
    viewModel: LoginVM = viewModel()
){
    val email by viewModel.enterEmail.observeAsState("")
    val password by viewModel.enterPassword.observeAsState("")
    val message by viewModel.message.observeAsState()
    val isSuccess by viewModel.isSuccess.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login Screen"
        )

        Spacer(modifier = Modifier.size(15.dp))

        OutlinedTextField(
            value = email,
            onValueChange = viewModel::onEmailChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            label = { Text("Enter Email") },
            singleLine = true
        )

        Spacer(modifier = Modifier.size(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = viewModel::onPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            label = { Text("Enter Password") },
            singleLine = true
        )

        Spacer(modifier = Modifier.size(10.dp))

        Button(
            onClick = { viewModel.login() },
            content = { Text("Login Now") }
        )

        if(message != null && isSuccess != null){
            Text(
                text = message!!,
                color = if (isSuccess == true)
                Color(0xFF4CAF50)
                else Color(0xFFFF0000),
                modifier =
                    Modifier.padding(horizontal = 15.dp)
            )
        }
    }
}