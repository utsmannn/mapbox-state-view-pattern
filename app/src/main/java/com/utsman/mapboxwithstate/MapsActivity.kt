package com.utsman.mapboxwithstate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.utsman.mapboxwithstate.impl.BaseRenderView
import com.utsman.mapboxwithstate.maps_render.MapsJakartaRender
import com.utsman.mapboxwithstate.maps_render.MapsBekasiRender
import com.utsman.mapboxwithstate.presenter.MainState
import com.utsman.mapboxwithstate.presenter.MainStateView
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), MainStateView {

    private val mainState by lazy {
        MainState(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(
            this,
            "sk.eyJ1Ijoia3VjaW5nYXBlcyIsImEiOiJjazMxaTMwdnUwNmZhM2RxZnN3MXB3NXVxIn0.SbImlZrtwRkxSpk-1h0h3A"
        )
        setContentView(R.layout.activity_maps)

        mapview.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->

                mainState.renderMapsJakarta(mapboxMap, style)

                btn_state_1.setOnClickListener {
                    mainState.renderMapsJakarta(mapboxMap, style)
                }

                btn_state_2.setOnClickListener {
                    mainState.renderMapsBekasi(mapboxMap, style)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainState.dispose()
    }

    override fun mapsJakarta(mapboxMap: MapboxMap): BaseRenderView {
        toast("rendering")
        val maps = MapsJakartaRender(this)
        maps.render(mapboxMap)
        return maps
    }

    override fun mapsBekasi(mapboxMap: MapboxMap): BaseRenderView {
        toast("rendering 2")
        val maps = MapsBekasiRender(this)
        maps.render(mapboxMap)
        return maps
    }
}
