<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
	<link rel="stylesheet" type="text/css" href="adote.css">
	<link rel="icon" type="imagem/png" href="assets/logo.png" />
	<title>HostPet</title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
            height: 37em;
		    width: 26em;
		    margin: 0;
		    margin-right: 6em;
		    margin-top: 9em;
		    position: inherit;
		    padding: 0;
		    float: right;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -12.97618906, lng: -38.47576906},
          zoom: 8
        });
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCYLLinb7c0xgQg0jC9sPDAoBQ73J4kvo0&callback=initMap"
    async defer></script>
  </body>
</html>