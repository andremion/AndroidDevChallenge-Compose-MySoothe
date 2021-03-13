package com.example.androiddevchallenge.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.currentRoute
import com.example.androiddevchallenge.data.Collection
import com.example.androiddevchallenge.data.bodyCollections
import com.example.androiddevchallenge.data.favorites
import com.example.androiddevchallenge.data.mindCollections
import com.example.androiddevchallenge.ui.component.InputText
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*

private val BottomNavigationHeight = 56.dp

private enum class HomeNavigationPage(
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Home(icon = Icons.Filled.Spa, label = R.string.home_screen_navigation_home),
    Profile(icon = Icons.Filled.AccountCircle, label = R.string.home_screen_navigation_profile)
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp,
            ) {
                var search by rememberSaveable { mutableStateOf("") }
                InputText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    leadingIcon = Icons.Filled.Search,
                    placeholder = stringResource(R.string.home_screen_field_search),
                    value = search,
                    onValueChange = { search = it }
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background
            ) {
                val currentPage = navController.currentRoute()
                HomeNavigationPage.values().forEach { page ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                modifier = Modifier.size(18.dp),
                                imageVector = page.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(page.label).toUpperCase(Locale.getDefault())) },
                        selected = currentPage == page.name,
                        onClick = {
                            navController.navigate(page.name) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo = navController.graph.startDestination
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = stringResource(R.string.home_screen_play_button)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        NavHost(navController, startDestination = HomeNavigationPage.Home.name) {
            composable(HomeNavigationPage.Home.name) {
                HomePage()
            }
            composable(HomeNavigationPage.Profile.name) {
                Text("Profile")
            }
        }
    }
}

@Composable
private fun HomePage() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

        Section(
            modifier = Modifier.paddingFromBaseline(top = 40.dp),
            name = stringResource(R.string.home_screen_section_favorites)
        ) {
            FavoriteTiles(favorites)
        }

        Section(
            modifier = Modifier.paddingFromBaseline(top = 48.dp),
            name = stringResource(R.string.home_screen_section_body)
        ) {
            CollectionTiles(bodyCollections)
        }

        Section(
            modifier = Modifier.paddingFromBaseline(top = 48.dp),
            name = stringResource(R.string.home_screen_section_mind)
        ) {
            CollectionTiles(mindCollections)
        }

        Spacer(modifier = Modifier.height(BottomNavigationHeight + 16.dp))
    }
}

@Composable
private fun FavoriteTiles(favorites: List<Collection>) {
    val columnSize = 2
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favorites.chunked(columnSize)) { column ->

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                column.forEach { content ->

                    Card(
                        modifier = Modifier.size(width = 192.dp, height = 56.dp),
                        shape = MaterialTheme.shapes.small,
                        elevation = 0.dp
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CoilImage(
                                modifier = Modifier.aspectRatio(1f),
                                data = content.imageUrl,
                                fadeIn = true,
                                contentScale = ContentScale.Crop,
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                text = content.title,
                                style = MaterialTheme.typography.h3
                            )
                        }
                    }
                }
            }

        }
    }
}

@Composable
private fun CollectionTiles(collections: List<Collection>) {
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(collections) { content ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CoilImage(
                    modifier = Modifier.height(88.dp),
                    data = content.imageUrl,
                    fadeIn = true,
                    contentDescription = null,
                    requestBuilder = { transformations(CircleCropTransformation()) }
                )
                Text(
                    modifier = Modifier.paddingFromBaseline(top = 24.dp),
                    text = content.title,
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}

@Composable
private fun Section(
    modifier: Modifier = Modifier,
    name: String,
    content: @Composable () -> Unit
) {
    Text(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        text = name.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h2
    )
    content()
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
