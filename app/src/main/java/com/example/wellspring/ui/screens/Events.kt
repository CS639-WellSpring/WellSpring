package com.example.wellspring

import com.example.wellspring.ui.theme.AppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
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
fun EventsView() {
    // Box-186:510-Events
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xfffef7ff))
            .size(412.dp, 892.dp)
            .clipToBounds(),
    ) {
        // Column-186:511-Event list
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 16.dp, y = 180.2.dp)
                .size(380.43.dp, 614.dp),
        ) {
            // Row-186:512-list row
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp)
                    .background(Color(0xfff3f0fb), RoundedCornerShape(32.dp))
                    .height(108.dp),
            ) {
                // Image-I186:512;111:1180-🖼 Image
                Image(
                    painter = painterResource(id = R.drawable.image01),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(108.dp, 108.dp),
                )
                // Column-I186:512;111:1181-row left
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .height(108.dp)
                        .padding(start = 16.dp, top = 12.dp, end = 24.dp, bottom = 12.dp),
                ) {
                    // Text-I186:512;111:1182-title
                    Text(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentSize(),
                        text = "Slime Making",
                        color = Color(0xff1d1b20),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        overflow = TextOverflow.Ellipsis,
                    )
                    // Column-I186:512;111:1882-body
                    Column(
                        verticalArrangement = Arrangement.spacedBy(space = 2.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentWidth()
                            .height(52.dp)
                            .clipToBounds(),
                    ) {
                        // Text-I186:512;111:1183-time
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "13:00 - 14:00",
                            color = Color(0xff49454f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Text-I186:512;111:1184-date
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "Saturday, April 20",
                            color = Color(0xff49454f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Row-I186:512;111:1185-location
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                        ) {
                            // Image-I186:512;111:1186-Vector
                            Image(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(7.dp, 10.dp),
                            )
                            // Text-I186:512;111:1187-location
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(223.dp, 20.dp),
                                text = "15 Beekman St, 25th floor",
                                color = Color(0xff49454f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
            // Row-186:513-list row
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp)
                    .background(Color(0xfff3f0fb), RoundedCornerShape(32.dp))
                    .height(108.dp),
            ) {
                // Image-I186:513;111:1180-🖼 Image
                Image(
                    painter = painterResource(id = R.drawable.image02),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(108.dp, 108.dp),
                )
                // Column-I186:513;111:1181-row left
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .height(108.dp)
                        .padding(start = 16.dp, top = 12.dp, end = 24.dp, bottom = 12.dp),
                ) {
                    // Text-I186:513;111:1182-title
                    Text(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentSize(),
                        text = "End of Semester Awards",
                        color = Color(0xff1c1b1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        overflow = TextOverflow.Ellipsis,
                    )
                    // Column-I186:513;111:1882-body
                    Column(
                        verticalArrangement = Arrangement.spacedBy(space = 2.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentWidth()
                            .height(52.dp)
                            .clipToBounds(),
                    ) {
                        // Text-I186:513;111:1183-time
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "18:00 - 20:00",
                            color = Color(0xff1c1b1f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Text-I186:513;111:1184-date
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "Saturday, April 20",
                            color = Color(0xff1c1b1f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Row-I186:513;111:1185-location
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                        ) {
                            // Image-I186:513;111:1186-Vector
                            Image(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(7.dp, 10.dp),
                            )
                            // Text-I186:513;111:1187-location
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(223.dp, 20.dp),
                                text = "15 Beekman St, Aniello Bianco Room",
                                color = Color(0xff1c1b1f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
            // Row-186:514-list row
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp)
                    .background(Color(0xfff3f0fb), RoundedCornerShape(32.dp))
                    .height(108.dp),
            ) {
                // Image-I186:514;111:1180-🖼 Image
                Image(
                    painter = painterResource(id = R.drawable.image03),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(108.dp, 108.dp),
                )
                // Column-I186:514;111:1181-row left
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .height(108.dp)
                        .padding(start = 16.dp, top = 12.dp, end = 24.dp, bottom = 12.dp),
                ) {
                    // Text-I186:514;111:1182-title
                    Text(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentSize(),
                        text = "The Collective: Spring Showcase",
                        color = Color(0xff1c1b1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        overflow = TextOverflow.Ellipsis,
                    )
                    // Column-I186:514;111:1882-body
                    Column(
                        verticalArrangement = Arrangement.spacedBy(space = 2.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentWidth()
                            .height(52.dp)
                            .clipToBounds(),
                    ) {
                        // Text-I186:514;111:1183-time
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "20:00 - 22:00",
                            color = Color(0xff1c1b1f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Text-I186:514;111:1184-date
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "Saturday, April 20",
                            color = Color(0xff49454f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Row-I186:514;111:1185-location
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                        ) {
                            // Image-I186:514;111:1186-Vector
                            Image(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(7.dp, 10.dp),
                            )
                            // Text-I186:514;111:1187-location
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(223.dp, 20.dp),
                                text = "KnJ Theatre",
                                color = Color(0xff1c1b1f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
            // Row-186:515-list row
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp)
                    .background(Color(0xfff3f0fb), RoundedCornerShape(32.dp))
                    .height(108.dp),
            ) {
                // Image-I186:515;111:1180-🖼 Image
                Image(
                    painter = painterResource(id = R.drawable.image04),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(108.dp, 108.dp),
                )
                // Column-I186:515;111:1181-row left
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .height(108.dp)
                        .padding(start = 16.dp, top = 12.dp, end = 24.dp, bottom = 12.dp),
                ) {
                    // Text-I186:515;111:1182-title
                    Text(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentSize(),
                        text = "P.A.C.E. Board Food Trucks",
                        color = Color(0xff1c1b1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        overflow = TextOverflow.Ellipsis,
                    )
                    // Column-I186:515;111:1882-body
                    Column(
                        verticalArrangement = Arrangement.spacedBy(space = 2.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentWidth()
                            .height(52.dp)
                            .clipToBounds(),
                    ) {
                        // Text-I186:515;111:1183-time
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "12:00 - 14:00",
                            color = Color(0xff1c1b1f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Text-I186:515;111:1184-date
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "Monday, April 22",
                            color = Color(0xff1c1b1f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Row-I186:515;111:1185-location
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                        ) {
                            // Image-I186:515;111:1186-Vector
                            Image(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(7.dp, 10.dp),
                            )
                            // Text-I186:515;111:1187-location
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(223.dp, 20.dp),
                                text = "1 Pace Plaza Outside",
                                color = Color(0xff1c1b1f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
            // Row-186:516-list row
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp)
                    .background(Color(0xfff3f0fb), RoundedCornerShape(32.dp))
                    .height(108.dp),
            ) {
                // Image-I186:516;111:1180-🖼 Image
                Image(
                    painter = painterResource(id = R.drawable.image05),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(108.dp, 108.dp),
                )
                // Column-I186:516;111:1181-row left
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .height(108.dp)
                        .padding(start = 16.dp, top = 12.dp, end = 24.dp, bottom = 12.dp),
                ) {
                    // Text-I186:516;111:1182-title
                    Text(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentSize(),
                        text = "Interbiew Lab Workshop",
                        color = Color(0xff1c1b1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        overflow = TextOverflow.Ellipsis,
                    )
                    // Column-I186:516;111:1882-body
                    Column(
                        verticalArrangement = Arrangement.spacedBy(space = 2.dp, alignment = Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .wrapContentWidth()
                            .height(52.dp)
                            .clipToBounds(),
                    ) {
                        // Text-I186:516;111:1183-time
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "12:10 - 13:10",
                            color = Color(0xff1c1b1f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Text-I186:516;111:1184-date
                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                            text = "Monday, April 22",
                            color = Color(0xff1c1b1f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            overflow = TextOverflow.Ellipsis,
                        )
                        // Row-I186:516;111:1185-location
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .wrapContentSize(),
                        ) {
                            // Image-I186:516;111:1186-Vector
                            Image(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(7.dp, 10.dp),
                            )
                            // Text-I186:516;111:1187-location
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(223.dp, 20.dp),
                                text = "Online",
                                color = Color(0xff1c1b1f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
        }
        // Row-186:521-headline
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.Start),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 102.dp)
                .size(412.dp, 56.dp)
                .padding(horizontal = 16.dp, vertical = 0.dp),
        ) {
            // Text-186:522-headline
            Text(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .offset(x = 0.dp, y = 0.dp)
                    .size(130.dp, 56.dp),
                text = "Events",
                color = Color(0xff1d1b20),
                fontSize = 36.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
        }
        // Image-186:518-Top app bar
        Image(
            painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 0.dp, y = 46.dp)
                .size(64.dp, 64.dp)
                .padding(start = 4.dp, top = 8.dp, end = 16.dp, bottom = 0.dp),
        )
        // Row-186:605-Navigation bar
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.Start),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 788.dp)
                .background(Color(0xfff3edf7))
                .size(412.dp, 104.dp)
                .padding(horizontal = 8.dp, vertical = 0.dp),
        ) {
            // Column-186:606-Segment 1
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Top)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 142.66599999999997.dp)
                    .padding(start = 0.dp, top = 12.dp, end = 0.dp, bottom = 16.dp),
            ) {
                // Image-186:607-icon-container
                Image(
                    painter = painterResource(id = R.drawable.events_active),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .wrapContentHeight()
                        .offset(x = -0.0005000000000023874.dp, y = 0.dp)
                        .width(64.dp),
                )
                // Text-186:613-label-text
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 0.dp, y = 36.dp)
                        .padding(start = 0.dp, end = 0.dp),
                    text = "Events",
                    color = Color(0xff1d1b20),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            // Column-186:614-Segment 2
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Top)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp)
                    .padding(start = 0.dp, top = 12.dp, end = 0.dp, bottom = 16.dp),
            ) {
                // Image-186:615-icon-container
                Image(
                    painter = painterResource(id = R.drawable.mood_inactive),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .wrapContentSize()
                        .offset(x = -0.0005000000000023874.dp, y = 0.dp)
                        .clip(RoundedCornerShape(16.dp)),
                )
                // Text-186:621-label-text
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 0.dp, y = 36.dp)
                        .padding(start = 0.dp, end = 0.dp),
                    text = "Mood",
                    color = Color(0xff49454f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            // Column-186:622-Segment 3
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Top)
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 15.999999999999972.dp)
                    .padding(start = 0.dp, top = 12.dp, end = 0.dp, bottom = 16.dp),
            ) {
                // Image-186:623-icon-container
                Image(
                    painter = painterResource(id = R.drawable.chart_inactive),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .wrapContentHeight()
                        .offset(x = -0.0005000000000023874.dp, y = 0.dp)
                        .width(64.dp),
                )
                // Text-186:629-label-text
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 0.dp, y = 36.dp)
                        .padding(start = 0.dp, end = 0.dp),
                    text = "Chart",
                    color = Color(0xff49454f),
                    fontSize = 12.sp,
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
fun EventsPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                EventsView()
            }
        }
    }
}
