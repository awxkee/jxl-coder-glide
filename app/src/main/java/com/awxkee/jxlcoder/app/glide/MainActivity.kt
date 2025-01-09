package com.awxkee.jxlcoder.app.glide

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.awxkee.jxlcoder.app.glide.ui.theme.JxlCoderGlideTheme
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import okio.buffer
import okio.source

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val buffer5 =
//            assets.open("pexels-lastly-808465.jxl").source().buffer().readByteArray()
        setContent {
            JxlCoderGlideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")

                    LazyColumn {
                        item {
                            GlideImage(
//                            model = "https://wh.aimuse.online/preset/jxl_icc_12.bit.jxl",
                                model = Uri.parse("file:///android_asset/pexels-lastly-808465.jxl"),
                                contentDescription = "",
                            ) { requestBuilder ->
                                requestBuilder.diskCacheStrategy(DiskCacheStrategy.NONE)
                                    .skipMemoryCache(true)
                            }
                        }

                        item {
                            FilledTonalButton(modifier = Modifier
                                .padding(start = 8.dp, top = 8.dp)
                                .height(
                                    50.dp
                                ), onClick = {
                                startActivity(Intent(this@MainActivity, ProbeActivity::class.java))
                            }) {
                                Text("View View Activity")
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JxlCoderGlideTheme {
        Greeting("Android")
    }
}