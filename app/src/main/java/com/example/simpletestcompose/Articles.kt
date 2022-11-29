import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import com.example.simpletestcompose.Article


/**
 * TODO: Please do reverse the list when presented in UI
 * */




@Composable
fun ArticleCard(article: Article) {
    Row(modifier = Modifier.padding(all = 8.dp)) {

        Image(
            painter = rememberAsyncImagePainter(article.imageURL),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            article.title?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {

                Spacer(modifier = Modifier.height(45.dp))
                Column() {
                    article.content?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(start = 4.dp, top = 40.dp, end = 4.dp, bottom = 4.dp),
                            // If the message is expanded, we display all its content
                            // otherwise we only display the first line
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}


  fun fetchData(): MutableList<Article> {
    val lstRes = mutableListOf(
        Article(
            title = "Name 1",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 2",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 3",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 4",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 5",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 6",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 7",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 8",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 9",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
        Article(
            title = "Name 10",
            content = "The PNG format is widely supported and works best with presentations and web design. ",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
    )
      return (lstRes)
}


