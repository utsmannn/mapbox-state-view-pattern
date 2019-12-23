package com.utsman.mapboxwithstate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.utsman.mapboxwithstate.impl.BaseRenderView
import com.utsman.mapboxwithstate.maps_render.MapsJakartaRender
import com.utsman.mapboxwithstate.maps_render.MapsBekasiRender
import com.utsman.mapboxwithstate.maps_render.MapsCirclePolygonRender
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

                mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-6.21462,106.84513), 9.0))

                btn_state_1.setOnClickListener {
                    mainState.renderMapsJakarta(mapboxMap, style)
                }

                btn_state_2.setOnClickListener {
                    mainState.renderMapsBekasi(mapboxMap, style)
                }

                btn_state_polygon.setOnClickListener {
                    mainState.renderPolygon(mapboxMap, style)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainState.dispose()
    }

    override fun mapsJakarta(mapboxMap: MapboxMap, style: Style): BaseRenderView {
        toast("rendering jakarta")
        val maps = MapsJakartaRender(this)
        maps.render(mapboxMap, style)
        return maps
    }

    override fun mapsBekasi(mapboxMap: MapboxMap, style: Style): BaseRenderView {
        toast("rendering bekasi")
        val maps = MapsBekasiRender(this)
        maps.render(mapboxMap, style)
        return maps
    }

    override fun mapsPolygon(mapboxMap: MapboxMap, style: Style): BaseRenderView {
        toast("rendering polygon")
        val maps = MapsCirclePolygonRender()
        maps.render(mapboxMap, style)
        return maps
    }
}
