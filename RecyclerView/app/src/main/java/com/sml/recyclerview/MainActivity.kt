package com.sml.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        var newsImageArray = arrayOf(
            R.drawable.aiml, R.drawable.android, R.drawable.blockchain, R.drawable.dev, R.drawable.ios, R.drawable.web, R.drawable.aiml, R.drawable.android, R.drawable.blockchain, R.drawable.dev, R.drawable.ios, R.drawable.web, R.drawable.aiml, R.drawable.android, R.drawable.blockchain, R.drawable.dev, R.drawable.ios, R.drawable.web
        )

        var newsHeadingArray = arrayOf(
            "Focuses on making systems intelligent by enabling them to learn and make decisions based on data.",
            "Primarily used for developing mobile applications for Android devices using Java/Kotlin.",
            "A decentralized and secure technology used for transparent and immutable transactions.",
            "An umbrella term that covers all aspects of software development, from coding to deployment.",
            "Focuses on developing mobile applications specifically for Apple devices using Swift/Objective-C.",
            "Deals with building applications that run in web browsers using technologies like HTML, CSS, JavaScript, and frameworks like React or Angular.",
            "Focuses on making systems intelligent by enabling them to learn and make decisions based on data.",
            "Primarily used for developing mobile applications for Android devices using Java/Kotlin.",
            "A decentralized and secure technology used for transparent and immutable transactions.",
            "An umbrella term that covers all aspects of software development, from coding to deployment.",
            "Focuses on developing mobile applications specifically for Apple devices using Swift/Objective-C.",
            "Deals with building applications that run in web browsers using technologies like HTML, CSS, JavaScript, and frameworks like React or Angular.",
            "Focuses on making systems intelligent by enabling them to learn and make decisions based on data.",
            "Primarily used for developing mobile applications for Android devices using Java/Kotlin.",
            "A decentralized and secure technology used for transparent and immutable transactions.",
            "An umbrella term that covers all aspects of software development, from coding to deployment.",
            "Focuses on developing mobile applications specifically for Apple devices using Swift/Objective-C.",
            "Deals with building applications that run in web browsers using technologies like HTML, CSS, JavaScript, and frameworks like React or Angular."
        )

        val newsContent = arrayOf(
            getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content),
        )

        // to set hav bhav of items inside recyclerview, like vertically scroll, horizontally scroll, uniform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for (index in newsImageArray.indices) {
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                // on clicking each item, what action do you want to perform

                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newscontent", newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })




    }
}