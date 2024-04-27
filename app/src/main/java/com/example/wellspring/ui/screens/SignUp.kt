package com.example.wellspring

import com.example.wellspring.R
import com.example.wellspring.ui.theme.WellspringUITheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpView() {
    // Sign up container
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xfffef7ff))
            .size(412.dp, 892.dp)
            .clipToBounds(),
    ) {
        // Column-90:582-Google
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = 612.dp)
                .background(Color(0xfffef7ff), RoundedCornerShape(100.dp))
                .size(329.dp, 40.dp)
                .border(1.dp, Color(0xff79747e), RoundedCornerShape(100.dp))
                .clip(RoundedCornerShape(100.dp)),
        ) {
            // Row-I90:582;35:20566-state-layer
            Row(
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                    .padding(horizontal = 24.dp, vertical = 10.dp),
            ) {
                // Image-I90:582;35:20564-Google
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(25.6.dp, 20.dp),
                )
                // Text-I90:582;35:20567-label-text
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .wrapContentSize()
                        .offset(x = 0.dp, y = 0.dp),
                    text = "Sign up with Google",
                    color = Color(0xff65558f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        // Row-90:598-Dividing
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 42.dp, y = 528.dp)
                .width(328.dp)
                .clipToBounds()
                .padding(horizontal = 4.dp, vertical = 10.dp),
        ) {
            // Box-I90:598;95:670-Dividing line
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(307.84.dp, 24.dp),
            ) {
                // Image-I90:598;90:570-Line 1
                Image(
                    painter = painterResource(id = R.drawable.dividing),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 0.dp, y = 11.496.dp)
                        .size(130.dp, 1.008.dp)
                        .border(1.dp, Color(0xff79747e)),
                )
                // Text-I90:598;90:572-or
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 140.dp, y = 0.dp)
                        .size(27.84.dp, 24.dp),
                    text = "or",
                    color = Color(0xff79747e),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Image-I90:598;90:571-Line 2
                Image(
                    painter = painterResource(id = R.drawable.dividing),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 177.84.dp, y = 11.496.dp)
                        .size(130.dp, 1.008.dp)
                        .border(1.dp, Color(0xff79747e)),
                )
            }
        }
        // Column-90:574-sign in button
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = 448.dp)
                .background(Color(0xff65558f), RoundedCornerShape(100.dp))
                .size(328.dp, 40.dp)
                .clip(RoundedCornerShape(100.dp)),
        ) {
            // Row-I90:574;90:538-state-layer
            Row(
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                    .padding(horizontal = 24.dp, vertical = 10.dp),
            ) {
                // Text-I90:574;90:539-label-text
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .wrapContentSize(),
                    text = "Sign up",
                    color = Color(0xffffffff),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        // Column-32:20466-Inputs
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .wrapContentSize()
                .offset(x = 0.dp, y = 208.dp),
        ) {
            // Column-32:20516-Text field
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .wrapContentHeight()
                    .width(328.dp),
            ) {
                // Column-32:20517-text field
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .border(1.dp, Color(0xff7c757e), RoundedCornerShape(4.dp)),
                ) {
                    // Row-32:20518-state-layer
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 0.dp)
                            .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp),
                    ) {
                        // Column-32:20519-content
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .fillMaxWidth()
                                .padding(start = 0.dp, end = 16.dp)
                                .height(40.dp),
                        ) {
                            // Row-32:20520-input-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .wrapContentSize(),
                            ) {
                                // Text-32:20537-input-text
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .wrapContentSize(),
                                    text = "Email address",
                                    color = Color(0xff1d1b1e),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Left,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            // Row-32:20522-label-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .offset(x = -4.dp, y = -16.dp)
                                    .background(Color(0xfffef7fc))
                                    .padding(horizontal = 4.dp, vertical = 0.dp),
                            ) {

                            }
                        }
                    }
                }
            }
            // Column-32:20527-Text field
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(328.dp, 56.dp),
            ) {
                // Column-32:20528-text field
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .border(1.dp, Color(0xff7c757e), RoundedCornerShape(4.dp)),
                ) {
                    // Row-32:20529-state-layer
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 0.dp)
                            .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp),
                    ) {
                        // Column-32:20530-content
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .fillMaxWidth()
                                .padding(start = 0.dp, end = 16.dp)
                                .height(40.dp),
                        ) {
                            // Row-32:20531-input-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .wrapContentSize(),
                            ) {
                                // Text-32:20532-input-text
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .wrapContentSize(),
                                    text = "Enter your password",
                                    color = Color(0xff1d1b1e),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Left,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            // Row-32:20533-label-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .offset(x = -4.dp, y = -16.dp)
                                    .background(Color(0xfffef7fc))
                                    .padding(horizontal = 4.dp, vertical = 0.dp),
                            ) {

                            }
                        }
                    }
                }
            }
            // Column-32:20539-Text field
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(328.dp, 56.dp),
            ) {
                // Column-32:20540-text field
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .border(1.dp, Color(0xff7c757e), RoundedCornerShape(4.dp)),
                ) {
                    // Row-32:20541-state-layer
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 0.dp)
                            .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp),
                    ) {
                        // Column-32:20542-content
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .fillMaxWidth()
                                .padding(start = 0.dp, end = 16.dp)
                                .height(40.dp),
                        ) {
                            // Row-32:20543-input-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .wrapContentSize(),
                            ) {
                                // Text-32:20544-input-text
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .wrapContentSize(),
                                    text = "Confirm Password",
                                    color = Color(0xff1d1b1e),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Left,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            // Row-32:20545-label-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .offset(x = -4.dp, y = -16.dp)
                                    .background(Color(0xfffef7fc))
                                    .padding(horizontal = 4.dp, vertical = 0.dp),
                            ) {

                            }
                        }
                    }
                }
            }
        }
        // Column-86:485-Headline
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .wrapContentWidth()
                .offset(x = 0.dp, y = 104.dp)
                .height(64.dp),
        ) {
            // Box-86:486-Headline
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(328.dp, 36.dp),
            ) {
                // Text-86:487-text
                Text(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .wrapContentHeight()
                        .offset(x = 0.dp, y = 0.dp)
                        .width(328.dp),
                    text = "Create a Wellspring Account",
                    color = Color(0xff1d1b20),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        // Image-49:453-Top app bar
        Image(
            painter = painterResource(id = R.drawable.backbutton),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 46.dp)
                .size(64.dp, 64.dp)
                .padding(horizontal = 4.dp, vertical = 8.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpViewPreview() {
    WellspringUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                SignUpView()
            }
        }
    }
}
