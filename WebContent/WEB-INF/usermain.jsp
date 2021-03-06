<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="regresionTest">
<head>
    <meta charset="utf-8" />
    <title>Regresion Test</title>
    
    <!-- StyleSheets -->

   	<link rel="stylesheet" href="frameWorks/Bootstrap/bootstrap.min.css"/>
   	<link rel="stylesheet" href= "css/style.css"/>

   
     <!-- Angular -->

    <script src="frameWorks/angular/angular.min.js" type="text/javascript" xml:space="preserve"></script>
    <script src="frameWorks/angular/ng-currency.js" type="text/javascript" xml:space="preserve"></script>
    
    
    <script src="frameWorks/date_format/date_format.js" type="text/javascript" xml:space="preserve"></script>
   
   <!-- query -->
		<script src="frameWorks/jQuery/jQuery.js" type="text/javascript" xml:space="preserve"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type = "text/javascript"></script>
    	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type = "text/javascript"></script>
    	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel = "Stylesheet" type="text/css" />
        
   <!-- Control -->
   <script src="js/control/usermain.js" type="text/javascript" xml:space="preserve"></script>
   <!-- Model -->
   	<script src="js/model/peticionObj.js" type="text/javascript" xml:space="preserve"></script>
       
	</head>
	<body class="container" ng-controller = "regresionController as regresion">

    
    
    
     <nav class="navbar navbar-default" role="navigation">
        	<ul class="nav nav-tabs">
				<li ng-class="{active:showMenuOption==1}"><a id="execution" ng-click="showMenuOption=1">Execution</a></li>
				<li ng-class="{active:showMenuOption==2}"><a id="configuration" ng-click="showMenuOption=2">Configuration</a></li>
				<li ng-class="{active:showMenuOption==3}"><a id="result" ng-click="showMenuOption=3">Result</a></li>
            	<li><a href="logout.do" target="_self">Logout</a></li>
        	</ul>
	</nav>
	 
	 <div id="executionDiv" ng-show="showMenuOption==1">
                <cabecera></cabecera>
                <filtrado ng-show="showMenufiltrado==1"></filtrado>
                <listadocasosprueba></listadocasosprueba>
     </div>
     
     <div id="configurationDiv" ng-show="showMenuOption==2">
                <cabecera></cabecera>
                <filtrado ng-show="showMenufiltrado==1"></filtrado>
                <configuration ng-show="showMenuConfiguration==1"></configuration>
     </div>
     
     <div id="resultDiv" ng-show="showMenuOption==3">
               <result></result>
                <div class="left">
                	<visualizarjson></visualizarjson>
                </div>
                <div class="right">
                	<listadoresultados></listadoresultados>
                </div>
     </div>



    </div>
    </body>
    
    </html>


  