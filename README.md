# Mapbox StateView Pattern
Implementation of maps state view pattern for Mapbox SDK with single maps callback class

```
.
├── MapsActivity.kt             --> maps activity with single OnMapReadyCallBack
├── impl
│   └── BaseRenderView.kt       --> base interface render to view with func render() and remove() layers
├── maps_render
│   ├── MapsBekasiRender.kt     --> render maps layer for bekasi
│   └── MapsJakartaRender.kt    --> render maps layer for jakarta
└── presenter
    ├── MainState.kt            --> state class base on presenter with rx to render
    └── MainStateView.kt        --> interface to bring mapbox to state class


```

---
thanks .