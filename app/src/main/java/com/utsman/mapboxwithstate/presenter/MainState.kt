package com.utsman.mapboxwithstate.presenter

import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.utsman.mapboxwithstate.impl.BaseRenderView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainState(private val mainStateView: MainStateView) {

    private val composite = CompositeDisposable()
    private var mapsJakartaState: BaseRenderView? = null
    private var mapsBekasiState: BaseRenderView? = null
    private var mapsPolygon: BaseRenderView? = null

    fun renderMapsJakarta(map: MapboxMap, style: Style) {
        val observable =  Observable.just(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                removeAll(style)
            }
            .subscribe({
                mapsJakartaState = mainStateView.mapsJakarta(it, style)
            }, {
                it.printStackTrace()
            })

        composite.add(observable)
    }

    fun renderMapsBekasi(map: MapboxMap, style: Style) {
        val observable =  Observable.just(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                removeAll(style)
            }
            .subscribe({
                mapsBekasiState = mainStateView.mapsBekasi(it, style)
            }, {
                it.printStackTrace()
            })

        composite.add(observable)
    }

    fun renderPolygon(map: MapboxMap, style: Style) {
        val observable = Observable.just(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                removeAll(style)
            }
            .subscribe({
                mapsPolygon = mainStateView.mapsPolygon(map, style)
            }, {
                it.printStackTrace()
            })

        composite.add(observable)
    }

    fun dispose() {
        composite.dispose()
    }

    private fun removeAll(style: Style) {
        mapsJakartaState?.remove(style)
        mapsBekasiState?.remove(style)
        mapsPolygon?.remove(style)
    }
}