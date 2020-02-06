<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<jsp:include page="/home/common/header.do" />

<script type="text/javascript" src="/static/home/js/jquery.js"></script>
<script type="text/javascript">
	
	
	
</script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
  <div id = "columnchart_values"style = "width : 900px; height : 300px;"></div>
	<form name="mainForm" id="mainForm" method="post" >
		기와니샵에 오신것을 환영합니다.
	</form>
	
	<script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "주유", { role: "style" } ],
        ["전월", 55000, "red"],
        ["이달", 68000, "blue"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { 
    	  				 calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" 
                         },
                       2]);

      var options = {
        title: "타이틀",
        subtitle: "서브타이틀",
        width: 600,
        height: 400,
        bar: {groupWidth: "55%"},
        legend: { position: "top" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }

// google.charts.load("current", {packages:['corechart']});

// google.charts.setOnLoadCallback(drawChart);

// function drawChart() {

// var data = google.visualization.arrayToDataTable([

// ['date', 'field1', 'field2', 'field3', 'field4', 'field5', 'field6', { role: 'annotation' } ],

// ['2010', 10, 24, 20, 32, 18, 5, ''],

// ['2011', 16, 22, 23, 30, 16, 9, ''],

//         ['2012', 10, 24, 20, 32, 18, 5, ''],

// ['2013', 16, 22, 23, 30, 16, 9, ''],

// ['2014', 28, 19, 29, 30, 12, 13, '']

// ]);

 

// var view = new google.visualization.DataView(data);

// view.setColumns([0, 1, 2, 3, 4, 5, 6, 7,

// { calc: "stringify",

// sourceColumn: 1,

// type: "string",

// role: "annotation" }

// ]);

// var options = {

// width: '100%',

// height: 768,

// legend: { position: 'top', maxLines: 3 },

// bar: { groupWidth: '75%' },

// isStacked: true,

// };

// var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));

// chart.draw(view, options);

// }
  </script>
<jsp:include page="/home/common/footer.do" />