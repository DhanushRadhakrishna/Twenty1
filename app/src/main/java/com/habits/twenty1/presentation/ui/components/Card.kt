import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habits.twenty1.R


@Composable
fun CardFace(modifier: Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = modifier.wrapContentSize(),
        shape = RoundedCornerShape(3.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.aceofdiamonds),
            contentDescription = null,
            contentScale = ContentScale.None
        )
    }
}

@Preview
@Composable
fun CardFacePreview()
{
    CardFace(modifier = Modifier)
}