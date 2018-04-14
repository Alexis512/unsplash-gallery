package gallery.unsplash.alex.com.presentation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import gallery.unsplash.alex.com.R
import kotlinx.android.synthetic.main.activity_view_photo.*
import kotlinx.android.synthetic.main.my_toolbar.*

class ViewPhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_photo)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        Picasso.with(this)
                .load(intent.getStringExtra("photoUrl"))
                .into(imgReviewPhoto)
    }
}
