package com.example.androiddevchallenge.data

data class Collection(
    val title: String,
    val imageUrl: String
)

val favorites = listOf(
    Collection(
        title = "Short mantras",
        imageUrl = imageUrl(1825206)
    ),
    Collection(
        title = "Nature meditations",
        imageUrl = imageUrl(3571551)
    ),
    Collection(
        title = "Stress and anxiety",
        imageUrl = imageUrl(1557238)
    ),
    Collection(
        title = "Self-massage",
        imageUrl = imageUrl(1029604)
    ),
    Collection(
        title = "Overwhelmed",
        imageUrl = imageUrl(3560044)
    ),
    Collection(
        title = "Nightly wind down",
        imageUrl = imageUrl(924824)
    )
)
val bodyCollections = listOf(
    Collection(
        title = "Inversions",
        imageUrl = imageUrl(317157)
    ),
    Collection(
        title = "Quick yoga",
        imageUrl = imageUrl(1812964)
    ),
    Collection(
        title = "Stretching",
        imageUrl = imageUrl(4056723)
    ),
    Collection(
        title = "Tabata",
        imageUrl = imageUrl(4662438)
    ),
    Collection(
        title = "HIIT",
        imageUrl = imageUrl(999309)
    ),
    Collection(
        title = "Pre-natal yoga",
        imageUrl = imageUrl(396133)
    ),
    Collection(
        title = "Tabata",
        imageUrl = imageUrl(4662438)
    )
)
val mindCollections = listOf(
    Collection(
        title = "Meditate",
        imageUrl = imageUrl(3822622)
    ),
    Collection(
        title = "With kids",
        imageUrl = imageUrl(3094230)
    ),
    Collection(
        title = "Aromatherapy",
        imageUrl = imageUrl(4498318)
    ),
    Collection(
        title = "On the go",
        imageUrl = imageUrl(1241348)
    ),
    Collection(
        title = "With pets",
        imageUrl = imageUrl(4056535)
    ),
    Collection(
        title = "High stress",
        imageUrl = imageUrl(897817)
    )
)

private fun imageUrl(id: Int) =
    "https://images.pexels.com/photos/$id/pexels-photo-$id.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
