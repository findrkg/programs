<html>
<head>
</head>
<body>

<script type="text/javascript" >
function saveMovie() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8081/moviesrestservice/webapi/movies", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.setRequestHeader("Authorization", "Basic cmVzdG1vdmllc0BnbWFpbC5jb206cmVzdG1vdmllcw==");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            console.log(json);
        }
    };  
    var movie = {};
    movie["name"]=document.getElementById("name").value;
    movie["year"]=document.getElementById("year").value;
    movie['director']=document.getElementById('director').value;
    movie['leadActor']=document.getElementById('lead_actor').value;
    movie['leadActoress']=document.getElementById('lead_actoress').value;
    var moviejson = JSON.stringify(movie);    
    xhr.send(moviejson);
}
</script>
<form>
<div style="text-align:center">
<label><b>Movie Name : </b></label>
<input type="text" id="name" value="" placeholder="Enter movie name"/><br><br>
<label><b>Year Released : </b></label>
<input type="text" id="year" value="" placeholder="Enter released year"/><br><br>
<label><b>Director : </b></label>
<input type="text" id="director" value="" placeholder="Enter director name"/><br><br>
<label><b>Actor : </b></label>
<input type="text" id="lead_actor" value="" placeholder="Enter lead actor name"/><br><br>
<label><b>Actoress : </b></label>
<input type="text" id="lead_actoress" value="" placeholder="Enter lead actoress name"/><br><br>
<button type="submit" onclick="javascript:saveMovie()">Save</button>
</div>
</form>

</body>
</html>