package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article.ui.theme.ComposeArticleTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val headingText = stringResource(R.string.jetpack_compose_tutorial)
                    val smallParagraph=
                        stringResource(R.string.jetpack_compose_is_a_modern_toolkit_for_building_native_android_ui_compose_simplifies_and_accelerates_ui_development_on_android_with_less_code_powerful_tools_and_intuitive_kotlin_apis)
                    val largeParagraph = stringResource(R.string.dummy_text)
                    MainContent(
                        heading=headingText,
                        smallParagraph = smallParagraph,
                        largeParagraph = largeParagraph
                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
@Composable
fun MainContent(heading:String,smallParagraph:String,largeParagraph:String,modifier:Modifier=Modifier){
    Column(modifier){
        val image = painterResource(R.drawable.bg_compose_background);
        Image(
            painter=image,
            contentDescription = "Heading image"
        )
        Text(
            text=heading,
            fontSize=24.sp,
            modifier=Modifier.padding(16.dp)
        )
        Text(
            text=smallParagraph,
            modifier= Modifier.padding(start = 16.dp,end=16.dp),
            textAlign= TextAlign.Justify
        )
        Text(
            text=largeParagraph,
            modifier= Modifier.padding(16.dp),
            textAlign= TextAlign.Justify
        )


    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val headingText = "Jetpack Compose tutorial"
    val smallParagraph= "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
    val largeParagraph = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
    ComposeArticleTheme {
//        Greeting("Android")
        MainContent(
            heading=headingText,
            smallParagraph = smallParagraph,
            largeParagraph = largeParagraph
        )
    }
}