package gallery.unsplash.alex.com.presentation.ui

import android.graphics.Point
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import com.kc.unsplash.models.Photo
import com.miguelcatalan.materialsearchview.MaterialSearchView
import gallery.unsplash.alex.com.App
import gallery.unsplash.alex.com.R
import gallery.unsplash.alex.com.presentation.mvp.presenters.MainPresenter
import gallery.unsplash.alex.com.presentation.mvp.views.MainView
import gallery.unsplash.alex.com.presentation.ui.recyclerView.ImageRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    private var strQuery: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(my_toolbar)
        recyclerImage.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerImage.hasFixedSize()
        strQuery = "animal"
        mvpPresenter.onLoadPhoto(strQuery!!)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_item, menu)
        searchView.setMenuItem(menu?.findItem(R.id.actionSearch))
        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                strQuery = query
                mvpPresenter.onLoadPhoto(strQuery!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSuccessLoad(image: ArrayList<Photo>) {
        var adapter = ImageRecyclerViewAdapter(image, getSizeDisplay()) {
            startActivity(intentFor<ViewPhotoActivity>("photoUrl" to it.urls.regular))
        }
        recyclerImage.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun onFailureLoad() {
        toast("Ошибка при загруке фото!")
    }

    private fun getSizeDisplay(): Int {
        var display = windowManager.defaultDisplay
        var size = Point()
        display.getSize(size)
        return size.x
    }
}
