package com.utsman.mapboxwithstate.impl

import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style

interface BaseRenderView {
    fun render(mapboxMap: MapboxMap)
    fun remove(style: Style)
}