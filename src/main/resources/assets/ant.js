var mymap = L.map('mapid').setView([47.98447821, 0.2415538], 15);

var index = 0;
var idxParcour = 0;
var aller = true;

var json = [

           {
                          "aller": [
                {"timestamp": 1, "lat": 47.9844782, "lon": 0.2415538},
           	{"timestamp": 1, "lat": 47.9844922, "lon": 0.241432},
           	{"timestamp": 1, "lat": 47.9845824, "lon": 0.2407886},
             {"timestamp": 1, "lat": 47.9846104, "lon": 0.2406362},
             {"timestamp": 1, "lat": 47.9847012, "lon": 0.2401415},
             {"timestamp": 1, "lat": 47.9847741, "lon": 0.2397382},
             {"timestamp": 1, "lat": 47.9849035, "lon": 0.2390012},
             {"timestamp": 1, "lat": 47.9849424, "lon": 0.2384647},
             {"timestamp": 1, "lat": 47.9849623, "lon": 0.2379394},
            {"timestamp": 1,"lat": 47.9849552, "lon": 0.2376945},
           {"timestamp": 1, "lat": 47.9849408, "lon": 0.2374676},
            {"timestamp": 1,"lat": 47.9849162, "lon": 0.2372807},
            {"timestamp": 1, "lat": 47.9848716, "lon": 0.2371191},
             {"timestamp": 1,"lat": 47.984827, "lon": 0.2369644},
             {"timestamp": 1,"lat": 47.984757, "lon": 0.2367817},
             {"timestamp": 1, "lat": 47.984653, "lon": 0.2365735},
             {"timestamp": 1, "lat": 47.9840556, "lon": 0.2353772},
             {"timestamp": 1, "lat": 47.9839932, "lon": 0.2352522},
             {"timestamp": 1, "lat": 47.9839747, "lon": 0.2352175},
             {"timestamp": 1, "lat": 47.9838077, "lon": 0.2349042},
             {"timestamp": 1, "lat": 47.983227, "lon": 0.2337684},
             {"timestamp": 1, "lat": 47.9831582, "lon": 0.2336339},
             {"timestamp": 1, "lat": 47.983123, "lon": 0.2335649},
             {"timestamp": 1, "lat": 47.9829081, "lon": 0.2331228},
             {"timestamp": 1, "lat": 47.9828162, "lon": 0.232924},
             {"timestamp": 1, "lat": 47.9827951, "lon": 0.2328702},
             {"timestamp": 1, "lat": 47.9827771, "lon": 0.2328292},
             {"timestamp": 1, "lat": 47.9827566, "lon": 0.2327841},
             {"timestamp": 1, "lat": 47.9826957, "lon": 0.2326908},
             {"timestamp": 1, "lat": 47.9827176, "lon": 0.2326639},
             {"timestamp": 1, "lat": 47.9827292, "lon": 0.2326437},
             {"timestamp": 1, "lat": 47.9827393, "lon": 0.2326201},
             {"timestamp": 1, "lat": 47.9827486, "lon": 0.2325872},
             {"timestamp": 1, "lat": 47.982753, "lon": 0.2325599},
             {"timestamp": 1, "lat": 47.9827548, "lon": 0.2325321},
             {"timestamp": 1, "lat": 47.9827535, "lon": 0.2325008},
             {"timestamp": 1, "lat": 47.9827489, "lon": 0.2324703},
             {"timestamp": 1, "lat": 47.9827404, "lon": 0.2324392},
             {"timestamp": 1, "lat": 47.982726, "lon": 0.2324063},
             {"timestamp": 1, "lat": 47.9827085, "lon": 0.2323795},
             {"timestamp": 1, "lat": 47.982689, "lon": 0.2323592},
             {"timestamp": 1, "lat": 47.9826744, "lon": 0.2323486},
             {"timestamp": 1, "lat": 47.982649, "lon": 0.2323373},
             {"timestamp": 1, "lat": 47.9826743, "lon": 0.2322525},
             {"timestamp": 1, "lat": 47.9826853, "lon": 0.2321924},
             {"timestamp": 1, "lat": 47.9827084, "lon": 0.2319977},
             {"timestamp": 1, "lat": 47.982712, "lon": 0.2319012},
             {"timestamp": 1, "lat": 47.9827006, "lon": 0.2317384},
             {"timestamp": 1, "lat": 47.9826764, "lon": 0.2314646},
             {"timestamp": 1, "lat": 47.9826511, "lon": 0.2311791},
             {"timestamp": 1, "lat": 47.9826358, "lon": 0.2309946},
             {"timestamp": 1, "lat": 47.9826132, "lon": 0.2307228},
             {"timestamp": 1, "lat": 47.9825739, "lon": 0.2302486},
             {"timestamp": 1, "lat": 47.9825388, "lon": 0.2297619},
             {"timestamp": 1, "lat": 47.9825213, "lon": 0.2295189},
             {"timestamp": 1, "lat": 47.9825037, "lon": 0.2292747},
             {"timestamp": 1, "lat": 47.982477, "lon": 0.2289047},
             {"timestamp": 1, "lat": 47.9824731, "lon": 0.2288503},
             {"timestamp": 1, "lat": 47.9824126, "lon": 0.2280791},
             {"timestamp": 1, "lat": 47.9823949, "lon": 0.227854},
             {"timestamp": 1, "lat": 47.9823838, "lon": 0.2277118},
             {"timestamp": 1, "lat": 47.9823668, "lon": 0.2274949},
             {"timestamp": 1, "lat": 47.9823406, "lon": 0.2271597},
             {"timestamp": 1, "lat": 47.9822551, "lon": 0.2260676},
             {"timestamp": 1, "lat": 47.9822512, "lon": 0.2260169},
             {"timestamp": 1, "lat": 47.9822464, "lon": 0.2259566},
             {"timestamp": 1, "lat": 47.9822373, "lon": 0.2258397},
             {"timestamp": 1, "lat": 47.9822239, "lon": 0.2256767},
             {"timestamp": 2, "lat": 47.9822209, "lon": 0.2256401},
             {"timestamp": 1, "lat": 47.9821092, "lon": 0.2242709},
             {"timestamp": 1, "lat": 47.9820981, "lon": 0.224134},
             {"timestamp": 1, "lat": 47.9820577, "lon": 0.2236065},
             {"timestamp": 1, "lat": 47.9819905, "lon": 0.222735},
             {"timestamp": 1, "lat": 47.9819049, "lon": 0.2216259},
             {"timestamp": 1, "lat": 47.9817575, "lon": 0.2220346},
             {"timestamp": 1, "lat": 47.9815544, "lon": 0.2226253},
             {"timestamp": 1, "lat": 47.9809281, "lon": 0.2222387}

                          ]
                        ,

                          "retour": [
             {"timestamp": 1, "lat": 47.9809281, "lon": 0.2222387},
            {"timestamp": 1, "lat": 47.9815544, "lon": 0.2226253},
              {"timestamp": 1, "lat": 47.9817575, "lon": 0.2220346},
               {"timestamp": 1, "lat": 47.9819049, "lon": 0.2216259},
               {"timestamp": 1, "lat": 47.9819905, "lon": 0.222735},
           	{"timestamp":1, "lat": 47.9820577, "lon": 0.2236065},
             {"timestamp": 1, "lat": 47.9820981, "lon": 0.224134}
                          ]
           }

                      ];

var antIcon = L.icon({
    iconUrl: 'images/fourmi.png',
    iconSize:     [40, 53], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 50], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
});

var antGraineIcon = L.icon({
    iconUrl: 'images/fourmi_graine.png',
    iconSize:     [40, 53], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 50], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
});
var graineIcon = L.icon({
    iconUrl: 'images/graine.png',
    iconSize:     [40, 53], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 50], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
});


//var seed = L.marker([json[json.length-1].lat,  json[json.length-1].lon], {icon: graineIcon}).addTo(mymap);

var ant =  L.marker([47.98447821,  0.2415538], {icon: antIcon}).addTo(mymap);


var position = { lat: 47.98447821, long: 0.2415538};

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
    maxZoom: 18,
    attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
	'<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
	'Imagery © <a href="http://mapbox.com">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(mymap);

	var popup = L.popup();

	function onMapClick(e) {
		popup
			.setLatLng(e.latlng)
			.setContent("You clicked the map at " + e.latlng.toString())
			.openOn(mymap);
	}

	mymap.on('click', onMapClick);




function deplacement() {

    position.lat = position.lat + .001;
    position.long = position.long + .001;

    var newLatLng = new L.LatLng(position.lat, position.long);
    ant.setLatLng(newLatLng);

}


function getPositions() {
   var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // Typical action to be performed when the document is ready:
            try {
                var jsText = xhttp.responseText;
                var result = JSON.parse(jsText);
                console.log(result);
                setTimeout(affiche, 1);
            } catch (e) {
                alert(e);
            }
        }
    };

    xhttp.open('GET', "http://localhost:8080/api/ant1", true);
    xhttp.send(null);
}


function run() {
    // setInterval(deplacement, 1000);
    // var latitude1 = document.getElementById("latitude1").value;
    // var latitude2 = document.getElementById("latitude2").value;

    // var longitude1 = document.getElementById("longitude1").value;
    // var longitude2 = document.getElementById("longitude2").value;

    // var debut = { lat: latitude1, long: longitude1};
    // var fin = { lat: latitude2, long: longitude2};

    // donnePositions(debut, fin);

   setTimeout(affiche, 1);
  //getPositions();
}


function affiche() {

//    if (index < json.length) {
//        var newLatLng = new L.LatLng(json[index].lat, json[index].lon);
//        ant.setLatLng(newLatLng);
//        index++;
//        setTimeout(affiche, json[index-1].delai /10);
//    } else {
//        ant.setIcon(antGraineIcon);
//        // mapid.removeLayer(seed);
//    }


    if (aller) {
        if (index < json[idxParcour].aller.length) {
            var newLatLng = new L.LatLng(json[idxParcour].aller[index].lat, json[idxParcour].aller[index].lon);
            ant.setLatLng(newLatLng);
            index++;
            setTimeout(affiche, json[idxParcour].aller[index-1].timestamp *200);
        } else {
            ant.setIcon(antGraineIcon);
             // Fin

            if (idxParcour < json.length) {
                aller = false;
                index = 0;
                setTimeout(affiche, 1000);
            }
        }
    } else {
        if (index < json[idxParcour].retour.length) {
            var newLatLng = new L.LatLng(json[idxParcour].retour[index].lat, json[idxParcour].retour[index].lon);
            ant.setLatLng(newLatLng);
            index++;
            setTimeout(affiche, json[idxParcour].retour[index-1].timestamp*200 );
        } else {
            ant.setIcon(antGraineIcon);
             // Fin

            if (idxParcour < json.length) {
                idxParcour++;
                aller = true;
                index = 0;
                ant.setIcon(antIcon);
                setTimeout(affiche, 1000);
            }
        }
    }

}

function donnePositions(debut, fin) {
   var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // Typical action to be performed when the document is ready:
            try {
                var jsText = xhttp.responseText;
                var result = JSON.parse(jsText);
                console.log(result);
                afficherDeplacement(result);
            } catch (e) {
                alert(e);
            }
        }
    };

    xhttp.open('POST', "http://localhost:8080/positions/" + latitude1 + "/" + longitude1 + "/" + latitude2 + "/" + longitude2, true);
    xhttp.send(null);
}

//var json = [ {
//    "lat" : 47.9844782,
//    "lon" : 0.2415538,
//    "delai" : 0
//},
//{
//    "lat" : 47.9844498,
//    "lon" : 0.2418012,
//    "delai" : 3401
//},
//{
//    "lat" : 47.9844416,
//    "lon" : 0.2418726,
//    "delai" : 404
//},
//{
//    "lat" : 47.9844282,
//    "lon" : 0.241989,
//    "delai" : 659
//},
//{
//    "lat" : 47.9843731,
//    "lon" : 0.2426022,
//    "delai" : 3453
//},
//{
//    "lat" : 47.9844975,
//    "lon" : 0.2425992,
//    "delai" : 1037
//},
//{
//    "lat" : 47.9850961,
//    "lon" : 0.2426151,
//    "delai" : 4992
//},
//{
//    "lat" : 47.9856336,
//    "lon" : 0.2425849,
//    "delai" : 4485
//},
//{
//    "lat" : 47.9858002,
//    "lon" : 0.2425916,
//    "delai" : 1389
//},
//{
//    "lat" : 47.9862915,
//    "lon" : 0.2426754,
//    "delai" : 4123
//},
//{
//    "lat" : 47.9863558,
//    "lon" : 0.242688,
//    "delai" : 540
//},
//{
//    "lat" : 47.9868836,
//    "lon" : 0.2427915,
//    "delai" : 4439
//},
//{
//    "lat" : 47.9870592,
//    "lon" : 0.2428837,
//    "delai" : 1552
//},
//{
//    "lat" : 47.9872806,
//    "lon" : 0.2430863,
//    "delai" : 2165
//},
//{
//    "lat" : 47.9874065,
//    "lon" : 0.2432862,
//    "delai" : 1532
//},
//{
//    "lat" : 47.9875207,
//    "lon" : 0.2435098,
//    "delai" : 1569
//},
//{
//    "lat" : 47.9875897,
//    "lon" : 0.2436449,
//    "delai" : 948
//},
//{
//    "lat" : 47.9876847,
//    "lon" : 0.2437609,
//    "delai" : 1023
//},
//{
//    "lat" : 47.9877556,
//    "lon" : 0.2438196,
//    "delai" : 675
//},
//{
//    "lat" : 47.9878464,
//    "lon" : 0.2438766,
//    "delai" : 821
//},
//{
//    "lat" : 47.987995,
//    "lon" : 0.2439605,
//    "delai" : 1324
//},
//{
//    "lat" : 47.9880515,
//    "lon" : 0.2439707,
//    "delai" : 474
//},
//{
//    "lat" : 47.98805,
//    "lon" : 0.2440126,
//    "delai" : 234
//},
//{
//    "lat" : 47.9880581,
//    "lon" : 0.2440528,
//    "delai" : 234
//},
//{
//    "lat" : 47.988075,
//    "lon" : 0.2440864,
//    "delai" : 234
//},
//{
//    "lat" : 47.9880985,
//    "lon" : 0.2441094,
//    "delai" : 234
//},
//{
//    "lat" : 47.9881157,
//    "lon" : 0.2441171,
//    "delai" : 149
//},
//{
//    "lat" : 47.988104,
//    "lon" : 0.2443129,
//    "delai" : 1097
//},
//{
//    "lat" : 47.98793,
//    "lon" : 0.246294,
//    "delai" : 7872
//},
//{
//    "lat" : 47.9878235,
//    "lon" : 0.247557,
//    "delai" : 5015
//},
//{
//    "lat" : 47.9875532,
//    "lon" : 0.2507641,
//    "delai" : 12735
//},
//{
//    "lat" : 47.9874246,
//    "lon" : 0.2522903,
//    "delai" : 6060
//},
//{
//    "lat" : 47.9874262,
//    "lon" : 0.2523858,
//    "delai" : 376
//},
//{
//    "lat" : 47.9874278,
//    "lon" : 0.2524841,
//    "delai" : 387
//},
//{
//    "lat" : 47.987432,
//    "lon" : 0.2527395,
//    "delai" : 1006
//},
//{
//    "lat" : 47.987444,
//    "lon" : 0.253475,
//    "delai" : 4106
//}];