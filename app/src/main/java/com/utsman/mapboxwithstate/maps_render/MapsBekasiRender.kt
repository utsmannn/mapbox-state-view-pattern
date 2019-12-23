package com.utsman.mapboxwithstate.maps_render

import android.content.Context
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.utsman.mapboxwithstate.R
import com.utsman.mapboxwithstate.impl.BaseRenderView
import com.utsman.mapboxwithstate.logi
import com.utsman.smartmarker.mapbox.Marker
import com.utsman.smartmarker.mapbox.MarkerOptions
import com.utsman.smartmarker.mapbox.addMarker

class MapsBekasiRender(private val context: Context):
    BaseRenderView {

    private var marker: Marker? = null

    override fun render(mapboxMap: MapboxMap) {

        // bekasi
        val lat = -6.241586
        val lon = 106.992416

        mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(lat,lon), 12.0))

        val markerOption = MarkerOptions.Builder()
            .setId("marker-id-2", true)
            .setIcon(R.drawable.mapbox_marker_icon_default)
            .setPosition(LatLng(lat,lon))
            .build(context)

        marker = mapboxMap.addMarker(markerOption)
    }

    override fun remove(style: Style) {
        logi("removing -> ${marker?.getId()}")
        marker?.let { mark ->
            style.removeLayer(mark.getId())
        }
    }
}