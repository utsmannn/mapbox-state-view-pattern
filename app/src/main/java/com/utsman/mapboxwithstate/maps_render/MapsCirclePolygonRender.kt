package com.utsman.mapboxwithstate.maps_render

import android.content.Context
import android.graphics.Color
import com.mapbox.geojson.Point
import com.mapbox.geojson.Polygon
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.FillLayer
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import com.utsman.mapboxwithstate.impl.BaseRenderView

class MapsCirclePolygonRender : BaseRenderView {


    private val points: MutableList<List<Point>> = mutableListOf()
    private val outerPoint: MutableList<Point> = mutableListOf()

    init {
        val jakarta = Point.fromLngLat(106.84513, -6.21462)
        val bekasi = Point.fromLngLat(106.992416, -6.241586)
        val jonggol = Point.fromLngLat(107.0640943, -6.460519)
        val depok = Point.fromLngLat(106.7964833, -6.417089)

        outerPoint.apply {
            add(jakarta)
            add(bekasi)
            add(jonggol)
            add(depok)
        }.apply {
            points.add(this)
        }
    }

    override fun render(mapboxMap: MapboxMap, style: Style) {
        val geoJsonSource = GeoJsonSource("source-polygon-id", Polygon.fromLngLats(points))
        style.addSource(geoJsonSource)

        val layer = FillLayer("layer-id", "source-polygon-id")
            .withProperties(PropertyFactory.fillColor(Color.parseColor("#51D81B60")))

        style.addLayer(layer)

    }

    override fun remove(style: Style) {
        style.removeSource("source-polygon-id")
        style.removeLayer("layer-id")
    }
}