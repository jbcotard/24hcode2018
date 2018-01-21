var mymap = L.map('mapid').setView([47.98447821, 0.2415538], 13);

var index = 0;
var json = [{
    "lat" : 47.9844782,
    "lon" : 0.2415538,
    "delai" : 0
},
{
    "lat" : 47.9844498,
    "lon" : 0.2418012,
    "delai" : 3401
},
{
    "lat" : 47.9844416,
    "lon" : 0.2418726,
    "delai" : 404
},
{
    "lat" : 47.9844282,
    "lon" : 0.241989,
    "delai" : 659
},
{
    "lat" : 47.9843731,
    "lon" : 0.2426022,
    "delai" : 3453
},
{
    "lat" : 47.9844975,
    "lon" : 0.2425992,
    "delai" : 1037
},
{
    "lat" : 47.9850961,
    "lon" : 0.2426151,
    "delai" : 4992
},
{
    "lat" : 47.9856336,
    "lon" : 0.2425849,
    "delai" : 4485
},
{
    "lat" : 47.9858002,
    "lon" : 0.2425916,
    "delai" : 1389
},
{
    "lat" : 47.9862915,
    "lon" : 0.2426754,
    "delai" : 4123
},
{
    "lat" : 47.9863558,
    "lon" : 0.242688,
    "delai" : 540
},
{
    "lat" : 47.9868836,
    "lon" : 0.2427915,
    "delai" : 4439
},
{
    "lat" : 47.9870592,
    "lon" : 0.2428837,
    "delai" : 1552
},
{
    "lat" : 47.9872806,
    "lon" : 0.2430863,
    "delai" : 2165
},
{
    "lat" : 47.9874065,
    "lon" : 0.2432862,
    "delai" : 1532
},
{
    "lat" : 47.9875207,
    "lon" : 0.2435098,
    "delai" : 1569
},
{
    "lat" : 47.9875897,
    "lon" : 0.2436449,
    "delai" : 948
},
{
    "lat" : 47.9876847,
    "lon" : 0.2437609,
    "delai" : 1023
},
{
    "lat" : 47.9877556,
    "lon" : 0.2438196,
    "delai" : 675
},
{
    "lat" : 47.9878464,
    "lon" : 0.2438766,
    "delai" : 821
},
{
    "lat" : 47.987995,
    "lon" : 0.2439605,
    "delai" : 1324
},
{
    "lat" : 47.9880515,
    "lon" : 0.2439707,
    "delai" : 474
},
{
    "lat" : 47.98805,
    "lon" : 0.2440126,
    "delai" : 234
},
{
    "lat" : 47.9880581,
    "lon" : 0.2440528,
    "delai" : 234
},
{
    "lat" : 47.988075,
    "lon" : 0.2440864,
    "delai" : 234
},
{
    "lat" : 47.9880985,
    "lon" : 0.2441094,
    "delai" : 234
},
{
    "lat" : 47.9881157,
    "lon" : 0.2441171,
    "delai" : 149
},
{
    "lat" : 47.988104,
    "lon" : 0.2443129,
    "delai" : 1097
},
{
    "lat" : 47.98793,
    "lon" : 0.246294,
    "delai" : 7872
},
{
    "lat" : 47.9878235,
    "lon" : 0.247557,
    "delai" : 5015
},
{
    "lat" : 47.9875532,
    "lon" : 0.2507641,
    "delai" : 12735
},
{
    "lat" : 47.9874246,
    "lon" : 0.2522903,
    "delai" : 6060
},
{
    "lat" : 47.9874262,
    "lon" : 0.2523858,
    "delai" : 376
},
{
    "lat" : 47.9874278,
    "lon" : 0.2524841,
    "delai" : 387
},
{
    "lat" : 47.987432,
    "lon" : 0.2527395,
    "delai" : 1006
},
{
    "lat" : 47.987444,
    "lon" : 0.253475,
    "delai" : 4106
}];

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


var seed = L.marker([json[json.length-1].lat,  json[json.length-1].lon], {icon: graineIcon}).addTo(mymap);

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

  // setTimeout(affiche, 1);
  getPositions();
}


function affiche() {

    if (index < json.length) {
        var newLatLng = new L.LatLng(json[index].lat, json[index].lon);
        ant.setLatLng(newLatLng);
        index++;
        setTimeout(affiche, json[index-1].delai);
    } else {
        //ant.icon = antGraineIcon;
        // mapid.removeLayer(seed);
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

