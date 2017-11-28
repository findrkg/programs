<html>
<head>
</head>
<body>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css">
<script type="text/javascript" >
function saveMovie() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8081/moviesrestservice/webapi/movies", true);
    xhr.setRequestHeader("Content-type", "application/json");
    //xhr.setRequestHeader("Authorization", "Basic cmVzdG1vdmllc0BnbWFpbC5jb206cmVzdG1vdmllcw==");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            console.log(json);
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
function getMovies() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8081/moviesrestservice/webapi/movies", false);
    xhr.setRequestHeader("Content-type", "application/json");
    //xhr.setRequestHeader("Authorization", "Basic cmVzdG1vdmllc0BnbWFpbC5jb206cmVzdG1vdmllcw==");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var jsonData = JSON.parse(xhr.responseText);
             $("#movielist").DataTable({
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
             
             $("#movielist").show();
        }
    };  
    xhr.send(null);
}


</script>
<form>
<div style="text-align:center">
<label><b>Language : </b></label>
<input type="text" id="language" value="" placeholder="Enter language"/><br><br>
<label><b>Movie Name : </b></label>
<input type="text" id="title" value="" placeholder="Enter movie name"/><br><br>
<label><b>Year Released : </b></label>
<input type="text" id="year" value="" placeholder="Enter released year"/><br><br>
<label><b>Director : </b></label>
<input type="text" id="director" value="" placeholder="Enter director name"/><br><br>
<label><b>Actor : </b></label>
<input type="text" id="actor" value="" placeholder="Enter lead actor name"/><br><br>
<label><b>Actress : </b></label>
<input type="text" id="actress" value="" placeholder="Enter lead actress name"/><br><br>
<button type="button" onclick="javascript:saveMovie()">Save Movie</button>
<button type="button" onclick="javascript:getMovies()">List Movies</button>
</div>
</form>

<div>
<table id="movielist" class="display" style="display:none" cellspacing="1" width="100%">
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