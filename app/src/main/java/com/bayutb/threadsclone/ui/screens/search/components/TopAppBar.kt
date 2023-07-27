package com.bayutb.threadsclone.ui.screens.search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    modifier: Modifier, onValueChange: (String) -> Unit, onFocusChange: (Boolean) -> Unit
) {
    var isVisible by remember { mutableStateOf(true) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    var searchValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        AnimatedVisibility(visible = isVisible) {
            Text(text = "Search", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(50.dp)
                .padding(top = 8.dp)
        ) {
            AnimatedVisibility(visible = !isVisible) {
                IconButton(modifier = modifier.padding(end = 8.dp), onClick = {
                    focusManager.clearFocus()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
            BasicTextField(
                value = searchValue, onValueChange = {
                    onValueChange(it)
                    searchValue = it
                },
                singleLine = true,
                maxLines = 1,
                textStyle = TextStyle.Default, modifier = modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        isVisible = !it.hasFocus
                        onFocusChange(it.hasFocus)
                    }
                    .focusRequester(focusRequester),
                decorationBox = {
                    Row(
                        modifier = modifier
                            .background(
                                MaterialTheme.colorScheme.surfaceVariant,
                                RoundedCornerShape(percent = 30)
                            )
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Search, contentDescription = null)
                        Spacer(Modifier.width(16.dp))
                        Row(modifier = modifier.weight(1f)) {
                            if (searchValue == "") {
                                AnimatedVisibility(visible = isVisible) {
                                    Text(text = "Search")
                                }
                            }
                            it.invoke()
                        }
                        Spacer(Modifier.width(16.dp))
                        if (searchValue != "") {
                            IconButton(onClick = {
                                onValueChange("")
                                searchValue = ""
                            }, modifier.size(24.dp)) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear"
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}