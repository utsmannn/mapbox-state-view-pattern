package com.utsman.mapboxwithstate.presenter

import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.utsman.mapboxwithstate.impl.BaseRenderView

interface MainStateView {
    fun mapsJakarta(mapboxMap: MapboxMap, style: Style): BaseRenderView
    fun mapsBekasi(mapboxMap: MapboxMap, style: Style): BaseRenderView
    fun mapsPolygon(mapboxMap: MapboxMap, style: Style): BaseRenderView
}