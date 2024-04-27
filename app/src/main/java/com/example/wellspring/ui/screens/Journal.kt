package com.example.wellspring

import com.example.wellspring.ui.theme.WellspringUITheme
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
fun JournalView() {
    // Box-178:543-Journal
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .background(Color(0xfffef7ff))
            .size(412.dp, 892.dp)
            .clipToBounds(),
    ) {
        // Image-178:546-photos
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 17.dp, y = 378.dp)
                .size(377.dp, 236.dp)
                .clipToBounds(),
        )
        // Text-178:545-
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 18.dp, y = 196.dp)
                .size(379.dp, 600.dp),
            text = "It\'s a rainy day and I’m feeling pretty bored. There\'s a project I need to work on, but I just can\'t bring myself to start.\n\nI slept really late last night and wake up to feed cats until noon today. He always know when his mealtime. 🤦‍♀️\n\n\n\n\n\n\n\n\n\n\n\nI plan to watch a TV series called Hip-Hop Revolution today.\n",
            color = Color(0xff000000),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Row-178:572-headline
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.Start),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 0.dp, y = 142.dp)
                .width(412.dp)
                .padding(horizontal = 16.dp, vertical = 0.dp),
        ) {
            // Text-178:573-headline
            Text(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .wrapContentHeight()
                    .width(379.dp),
                text = "Monday, April 29",
                color = Color(0xff1d1b20),
                fontSize = 28.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
        }
        // Image-178:547-Top app bar
        Image(
            painter = painterResource(id = R.drawable.backbutton),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 0.dp, y = 46.dp)
                .size(64.dp, 64.dp),
        )
        Image(
            painter = painterResource(id = R.drawable.journal_addmood),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 220.dp, y = 46.dp)
                .size(64.dp, 64.dp),
        )
        Image(
            painter = painterResource(id = R.drawable.journal_addphotos),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 284.dp, y = 46.dp)
                .size(64.dp, 64.dp),
        )
        Image(
            painter = painterResource(id = R.drawable.more),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .offset(x = 348.dp, y = 46.dp)
                .size(64.dp, 64.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JournalPreview() {
    WellspringUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                JournalView()
            }
        }
    }
}
