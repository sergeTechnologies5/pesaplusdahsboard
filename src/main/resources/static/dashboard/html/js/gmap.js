//$ = jQuery.noConflict();

var stompClient = null;
function connect() {
   initMap();
    var socket = new SockJS('/websocket-example');
    stompClient = Stomp.over(socket);
    stompClient.debug = function (){};
    stompClient.connect({}, function (frame) {

        stompClient.subscribe('/topic/user', function (greeting) {
             clearMarkers();
             var locations = JSON.parse(greeting.body);
             for (var i = 0; i < locations.length; i++) {
                 var lat = locations[i]['coords']['lat'];
                 var lng = locations[i]['coords']['lng'];
                 var title = locations[i]['title'];
                 var coords = {lat: lat, lng: lng};
                 addMarker(coords,title);
             }

        });
    });
}


function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
}

 var map;
      var markers = [];

      function initMap() {

        var haightAshbury = {lat: -3.0311379446797706, lng:38.43083608795048};

        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 6,
          center: haightAshbury,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        // This event listener will call addMarker() when the map is clicked.
        map.addListener('click', function(event) {
          addMarker(event.latLng,"Kenya");
        });

        // Adds a marker at the center of the map.
        addMarker(haightAshbury,"Kenya");
      }

      // Adds a marker to the map and push to the array.
      function addMarker(location, title) {
        var marker = new google.maps.Marker({
          position: location,
          map: map,
          title:title
        });
        markers.push(marker);
      }

      // Sets the map on all markers in the array.
      function setMapOnAll(map) {
        for (var i = 0; i < markers.length; i++) {
          markers[i].setMap(map);
        }
      }

      // Removes the markers from the map, but keeps them in the array.
      function clearMarkers() {
        setMapOnAll(null);
      }

      // Shows any markers currently in the array.
      function showMarkers() {
        setMapOnAll(map);
      }

      // Deletes all markers in the array by removing references to them.
      function deleteMarkers() {
        clearMarkers();
        markers = [];
      }

