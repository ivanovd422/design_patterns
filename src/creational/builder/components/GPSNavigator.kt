package creational.builder.components

class GPSNavigator {

    var route: String
        private set

    constructor() {
        route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London"
    }

    constructor(manualRoute: String) {
        route = manualRoute
    }
}