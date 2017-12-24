<!doctype html>
<html lang="en">
<head>
<style>
    label, input { display:block; }
    input.text { margin-bottom:10px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
body {
	font-family: Arial, Helvetica, sans-serif;
}

table {
	font-size: 1em;
}

.ui-draggable, .ui-droppable {
	background-position: top;
}
  </style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.3/css/select.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css">
<script src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css">
<script>
$(function() {
  var dTable;
  listMovies();

  var addDialog = $("#add_movie_form").dialog({
	    autoOpen: false,
	    height: 500,
	    width: 550,
	    modal: true,
	    buttons: {
	    	
	      "Add Movie" : addMovie,
	      Cancel: function() {
	    	  addDialog.dialog("close");
	      }
	    },
	  });	  

  var editDialog = $("#edit_movie_form").dialog({
	    autoOpen: false,
	    height: 500,
	    width: 550,
	    modal: true,
	    buttons: {
	    	"Update Movie" : updateMovie,
	      Cancel: function() {
	    	  editDialog.dialog("close");
	      }
	    },
	  });	  


  $('#movielist tbody').on( 'click', 'tr', function () {
	  $('#movielist tr.selected').each(function() {
		  $(this).removeClass('selected');
	  });
	  $(this).addClass('selected');
	});

  $("#add_movie").on("click", function() {
	  addDialog.dialog("open");
  });

  $("#edit_movie").on("click", function() {	  
	  var rowData = dTable.row('.selected').data();
	  if(rowData) {		  
		  document.getElementById("language1").value = rowData.language;
		  document.getElementById("title1").value = rowData.title;
		  document.getElementById("year1").value = rowData.hints.year;
		  document.getElementById('director1').value = rowData.hints.director;
		  document.getElementById('actor1').value = rowData.hints.actor;
		  document.getElementById('actress1').value = rowData.hints.actress;
		  editDialog.dialog("open");
	  }
	  else {
		  alert('Please select a row');
	  }
  });

  $("#delete_movie").on("click", function() {
	  var rowData = dTable.row('.selected').data()
	  deleteMovie(rowData.id);

	  //Set the index based on the row that was clicked
	  var CurItemIndex = dTable.row('.selected').index();
	  //Get the indexes 
	  var CurTableIndexs = dTable.rows().indexes();
	  // Get the array key for the current index we have
	  var CurIndexArrayKey = CurTableIndexs.indexOf( CurItemIndex );
	  // Add 1 to get the next index number
	  var NextItemIndex = CurTableIndexs[ CurIndexArrayKey + 1];
	  $(dTable.rows(NextItemIndex).nodes()).addClass('selected');
  });

  function addMovie() {
	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", "http://localhost:8081/moviesrestservice/webapi/movies", true);
	    xhr.setRequestHeader("Content-type", "application/json");
	    xhr.onreadystatechange = function () {
	        if (xhr.readyState === 4 && xhr.status === 200) {
	             addDialog.dialog("close");
	             listMovies();
	        }
	    };  
	    var movie = {}; var hints = {};
	    movie["language"]=document.getElementById("language").value;
	    movie["title"]=document.getElementById("title").value;
	    hints["year"]=document.getElementById("year").value;
	    hints['director']=document.getElementById('director').value;
	    hints['actor']=document.getElementById('actor').value;
	    hints['actress']=document.getElementById('actress').value;
	    movie['hints'] = hints;
	    var moviejson = JSON.stringify(movie);    
	    xhr.send(moviejson);
	}

  function updateMovie(movieId) {
	    var xhr = new XMLHttpRequest();
	    xhr.open("PUT", "http://localhost:8081/moviesrestservice/webapi/movies/"+movieId, true);
	    xhr.setRequestHeader("Content-type", "application/json");
	    xhr.onreadystatechange = function () {
	        if (xhr.readyState === 4 && xhr.status === 200) {
	             editDialog.dialog("close");
	             listMovies();
	        }
	    };  
	    var movie = {}; var hints = {};
	    movie["language"]=document.getElementById("language").value;
	    movie["title"]=document.getElementById("title").value;
	    hints["year"]=document.getElementById("year").value;
	    hints['director']=document.getElementById('director').value;
	    hints['actor']=document.getElementById('actor').value;
	    hints['actress']=document.getElementById('actress').value;
	    movie['hints'] = hints;
	    var moviejson = JSON.stringify(movie);    
	    xhr.send(moviejson);
	}

  function deleteMovie(movieId) {
	    var xhr = new XMLHttpRequest();
	    xhr.open("DELETE", "http://localhost:8081/moviesrestservice/webapi/movies/"+movieId, true);
	    xhr.setRequestHeader("Content-type", "application/json");
	    xhr.onreadystatechange = function () {
	        if (xhr.readyState === 4 && xhr.status === 200) {
	        	 dTable.clear().draw();
	        	 listMovies();
	        }
	    };  
	    xhr.send(null);
	}

	function listMovies() {
	    var xhr = new XMLHttpRequest();
	    xhr.open("GET", "http://localhost:8081/moviesrestservice/webapi/movies", false);
	    xhr.setRequestHeader("Content-type", "application/json");
	    xhr.onreadystatechange = function () {
	        if (xhr.readyState === 4 && xhr.status === 200) {
	            var jsonData = JSON.parse(xhr.responseText);
	             if(dTable) {
	            	 dTable.clear().draw();
	            	 dTable.rows.add(jsonData).draw();
	             }
	             else {
		             dTable = $("#movielist").DataTable({
		            	 	"dom": 'ftip',
		            	 	select: true,
			             	data: jsonData,        
			             	"columns": [
			                     { data: "id" },
			                     { data: "language" },
			                     { data: "title" },
			                     { data: "hints.actor"},
			                     { data: "hints.actress"},
			                     { data: "hints.director"},
			                     { data: "hints.year"},
			                     { data: "version" }
			                 ]
			             });	            	 
	             }	             
	             $("#movielist").show();
	        }
	    };  
	    xhr.send(null);
	}

});

</script>
</head>
<body>
<div id="add_movie_form" title="Add movie" style="display:none">
  <form>
    <fieldset>
      <label for="title">Movie Title</label>
      <input type="text" name="title" id="title" value="" class="text ui-widget-content ui-corner-all">
      <label for="language">Language</label>
      <input type="text" name="language" id="language" value="" class="text ui-widget-content ui-corner-all">
      <label for="year">Year Released</label>
      <input type="text" name="year" id="year" value="" class="text ui-widget-content ui-corner-all">
      <label for="director">Director</label>
      <input type="text" name="director" id="director" value="" class="text ui-widget-content ui-corner-all">
      <label for="actor">Actor</label>
      <input type="text" name="actor" id="actor" value="" class="text ui-widget-content ui-corner-all">
      <label for="actress">Actress</label>
      <input type="text" name="actress" id="actress" value="" class="text ui-widget-content ui-corner-all">
    </fieldset>
  </form>
</div>

<div id="edit_movie_form" title="Edit movie" style="display:none">
  <form>
    <fieldset>
      <label for="title1">Movie Title</label>
      <input type="text" name="title1" id="title1" value="" class="text ui-widget-content ui-corner-all">
      <label for="language1">Language</label>
      <input type="text" name="language1" id="language1" value="" class="text ui-widget-content ui-corner-all">
      <label for="year1">Year Released</label>
      <input type="text" name="year1" id="year1" value="" class="text ui-widget-content ui-corner-all">
      <label for="director1">Director</label>
      <input type="text" name="director1" id="director1" value="" class="text ui-widget-content ui-corner-all">
      <label for="actor1">Actor</label>
      <input type="text" name="actor1" id="actor1" value="" class="text ui-widget-content ui-corner-all">
      <label for="actress1">Actress</label>
      <input type="text" name="actress1" id="actress1" value="" class="text ui-widget-content ui-corner-all">
    </fieldset>
  </form>
</div>

<button id="add_movie" class="btn btn-primary">Add</button>
<button id="edit_movie" class="btn btn-primary">Edit</button>
<button id="delete_movie" class="btn btn-primary">Delete</button>
<div style="margin:10px; width:90%">
	<table id="movielist" class="display" style="display:none" width="100%">
        <thead>
            <tr>
            	<th>Id</th>
            	<th>Language</th>
                <th>Title</th> 
	            <th>Actor</th>
	            <th>Actress</th>
	            <th>Director</th>
	            <th>Year</th>               
                <th>Version</th>
            </tr>
        </thead>
    </table>
</div>
</body>
</html>