package com.ricardo.youtubeapp.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.AdapterView
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.ricardo.youtubeapp.API.YoutubeService
import com.ricardo.youtubeapp.R
import com.ricardo.youtubeapp.adapter.AdapterVideo
import com.ricardo.youtubeapp.helper.RetrofitConfig
import com.ricardo.youtubeapp.helper.YouTubeConfig
import com.ricardo.youtubeapp.listener.RecyclerItemClickListener
import com.ricardo.youtubeapp.model.Item
import com.ricardo.youtubeapp.model.Resultados
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    private var videos = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recuperarVideos("")

        val toolbar: Toolbar? = this.toolbar
        toolbar?.title = "Youtube"
        setSupportActionBar(toolbar)

        val searchView: MaterialSearchView = searchView


        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {

                recuperarVideos(query)

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }

        })

        searchView.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
            override fun onSearchViewShown() {

            }

            override fun onSearchViewClosed() {
                recuperarVideos("")
            }
        })

    }

    private fun recuperarVideos(pesquisa: String) {

        val q: String = pesquisa.replace(" ", "+")
        val retrofit: Retrofit = RetrofitConfig().getRetrofit()

        var youtubeService: YoutubeService = retrofit.create(YoutubeService::class.java)

        youtubeService.recuperarVideos(
            "snippet", "date", "20", YouTubeConfig().CHAVE_YOUTUBE_API, YouTubeConfig().CANAL_ID, q
        ).enqueue(object : Callback<Resultados> {

            override fun onFailure(call: Call<Resultados>, t: Throwable) {


            }

            override fun onResponse(call: Call<Resultados>, response: Response<Resultados>) {

                if (response.isSuccessful) {
                    val resultados: Resultados? = response.body()
                    videos = resultados?.items as ArrayList<Item>

                    configurarRecyclerView()
                }
            }

        })
    }

    private fun configurarRecyclerView() {
        val recyclerVideos: RecyclerView = recyclerViewVideos
        recyclerVideos.setHasFixedSize(true)
        recyclerVideos.layoutManager = LinearLayoutManager(this)
        recyclerVideos.adapter = AdapterVideo(this, videos)

        recyclerVideos.addOnItemTouchListener(
            RecyclerItemClickListener(
                this,
                recyclerVideos,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {

                        var video: Item = videos.get(position)
                        var idVideo: String? = video.id?.videoId

                        val intent = Intent(this@MainActivity, PlayerActivity::class.java)
                        intent.putExtra("idVideo", idVideo)
                        startActivity(intent)

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }

                    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                    }
                })
        )
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflat: MenuInflater = menuInflater
        inflat.inflate(R.menu.menu_main, menu)

        val item = menu?.findItem(R.id.menu_search)
        searchView.setMenuItem(item)

        return true
    }

}
