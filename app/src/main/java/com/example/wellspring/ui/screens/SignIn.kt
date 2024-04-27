package com.example.wellspring

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
fun SignInView() {
    // Box-31:18014-Sign in
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xfffef7ff))
            .size(412.dp, 892.dp)
            .clipToBounds(),
    ) {
        // Column-90:581-Google
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 44.dp, y = 632.dp)
                .background(Color(0xfffef7ff), RoundedCornerShape(100.dp))
                .size(329.dp, 40.dp)
                .border(1.dp, Color(0xff79747e), RoundedCornerShape(100.dp))
                .clip(RoundedCornerShape(100.dp)),
        ) {
            // Row-35:20566-state-layer
            Row(
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxSize()
                    .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                    .padding(horizontal = 24.dp, vertical = 10.dp),
            ) {
                // Image-35:20564-Google
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(25.6.dp, 20.dp),
                )
                // Text-35:20567-label-text
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .wrapContentSize()
                        .offset(x = 0.dp, y = 0.dp),
                    text = "Sign in with Google",
                    color = Color(0xff65558f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        // Row-90:589-Dividing
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 44.dp, y = 548.dp)
                .width(328.dp)
                .clipToBounds()
                .padding(horizontal = 4.dp, vertical = 10.dp),
        ) {
            // Box-95:670-Dividing line
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(307.84.dp, 24.dp),
            ) {
                // Image-90:570-Line 1
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
                // Text-90:572-or
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
                // Image-90:571-Line 2
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
        // Column-90:568-Sign in button
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 44.dp, y = 412.dp),
        ) {
            // Column-90:573-sign in button
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Start)
                    .background(Color(0xff65558f), RoundedCornerShape(100.dp))
                    .size(328.dp, 40.dp)
                    .clip(RoundedCornerShape(100.dp)),
            ) {
                // Row-90:538-state-layer
                Row(
                    horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxSize()
                        .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                        .padding(horizontal = 24.dp, vertical = 10.dp),
                ) {
                    // Text-90:539-label-text
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .wrapContentSize(),
                        text = "Sign In",
                        color = Color(0xffffffff),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            // Column-90:540-sign up button
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Start)
                    .background(Color(0xffe8def8), RoundedCornerShape(100.dp))
                    .size(329.dp, 40.dp)
                    .clip(RoundedCornerShape(100.dp)),
            ) {
                // Row-90:541-state-layer
                Row(
                    horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxSize()
                        .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                        .padding(horizontal = 24.dp, vertical = 10.dp),
                ) {
                    // Text-90:542-label-text
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .wrapContentSize()
                            .offset(x = 0.dp, y = 0.dp),
                        text = "Sign Up",
                        color = Color(0xff65558f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
        // Column-90:524-Inputs
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 44.dp, y = 244.dp),
        ) {
            // Column-90:525-text field
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(328.dp, 56.dp),
            ) {
                // Column-90:526-text field
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .border(1.dp, Color(0xff79747e), RoundedCornerShape(4.dp)),
                ) {
                    // Row-90:527-state-layer
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 0.dp)
                            .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp),
                    ) {
                        // Column-90:528-content
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .fillMaxWidth()
                                .padding(start = 0.dp, end = 16.dp)
                                .height(40.dp),
                        ) {
                            // Row-90:529-input-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .wrapContentSize(),
                            ) {
                                // Text-90:530-input-text
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .wrapContentSize(),
                                    text = "Email address",
                                    color = Color(0xff1d1b20),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Left,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            // Row-90:531-label-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .offset(x = -4.dp, y = -16.dp)
                                    .background(Color(0xfffef7ff))
                                    .padding(horizontal = 4.dp, vertical = 0.dp),
                            ) {

                            }
                        }
                    }
                }
            }
            // Column-139:642-Text field
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(328.dp, 56.dp),
            ) {
                // Column-139:643-text field
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .border(1.dp, Color(0xff79747e), RoundedCornerShape(4.dp)),
                ) {
                    // Row-139:644-state-layer
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 0.dp, end = 0.dp)
                            .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp),
                    ) {
                        // Column-139:645-content
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .fillMaxWidth()
                                .padding(start = 0.dp, end = 16.dp)
                                .height(40.dp),
                        ) {
                            // Row-139:646-input-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .wrapContentSize(),
                            ) {
                                // Text-139:647-input-text
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .wrapContentSize(),
                                    text = "Enter your password",
                                    color = Color(0xff1d1b20),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Left,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            // Row-139:648-label-text
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .offset(x = -4.dp, y = -16.dp)
                                    .background(Color(0xfffef7ff))
                                    .padding(horizontal = 4.dp, vertical = 0.dp),
                            ) {

                            }
                        }
                    }
                }
            }
        }
        // Box-90:522-Supporting text
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 45.dp, y = 190.dp)
                .size(326.dp, 20.dp)
                .clipToBounds(),
        ) {
            // Text-90:523-text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(326.dp, 20.dp),
                text = "with your Wellspring Account",
                color = Color(0xff49454f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
        }
        // Box-90:520-Headline
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 44.dp, y = 148.dp)
                .size(328.dp, 36.dp),
        ) {
            // Text-90:521-text
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 0.dp, y = 2.dp)
                    .width(328.dp),
                text = "Sign in",
                color = Color(0xff1d1b20),
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
        }
        // Row-90:586-Logo
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.Start),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .wrapContentSize()
                .offset(x = 0.dp, y = 96.dp)
                .clipToBounds()
                .padding(horizontal = 4.dp, vertical = 2.dp),
        ) {
            // Image-57:653-logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.Top)
                    .size(24.dp, 24.dp),
            )
            //
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .align(Alignment.Top)
                    .size(118.dp, 32.dp),
            ) {
                // Text-90:553-W
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize(),
                    text = "W",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:554-e
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 20.dp, y = 0.dp),
                    text = "e",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:555-l
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 33.dp, y = 0.dp),
                    text = "l",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:556-l
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 39.dp, y = 0.dp),
                    text = "l",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:557-s
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 45.dp, y = 0.dp),
                    text = "s",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:558-p
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 58.dp, y = 0.dp),
                    text = "p",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:559-r
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 73.dp, y = 0.dp),
                    text = "r",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:560-i
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 83.dp, y = 0.dp),
                    text = "i",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:562-n
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 89.dp, y = 0.dp),
                    text = "n",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
                // Text-90:561-g
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .wrapContentSize()
                        .offset(x = 103.dp, y = 0.dp),
                    text = "g",
                    color = Color(0xff000000),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    WellspringUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                SignInView()
            }
        }
    }
}
