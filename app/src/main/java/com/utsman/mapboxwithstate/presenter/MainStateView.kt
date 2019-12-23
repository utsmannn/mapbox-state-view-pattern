package com.utsman.mapboxwithstate.presenter

import com.mapbox.mapboxsdk.maps.MapboxMap
import com.utsman.mapboxwithstate.impl.BaseRenderView

interface MainStateView {
    fun mapsJakarta(mapboxMap: MapboxMap): BaseRenderView
    fun mapsBekasi(mapboxMap: MapboxMap): BaseRenderView
}