# Mapbox StateView Pattern
Implementation of maps state view pattern for Mapbox SDK with single maps callback class

```
.
├── MapsActivity.kt             --> maps activity with single OnMapReadyCallBack
├── impl
│   └── BaseRenderView.kt       --> base interface render to view
├── maps_render
│   ├── MapsBekasiRender.kt     --> render maps here with function add and clear layer
│   └── MapsJakartaRender.kt    --> render maps here with function add and clear layer
└── presenter
    ├── MainState.kt            --> state class base on presenter with rx to render
    └── MainStateView.kt        --> interface to bring mapbox to state class


```

---
thanks