<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleAmministratore.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>
<%@ include file="headerAmministratore.jsp"%>

<div class="container-cerca">
<div class="cerca">
  <form class="search-container">
    <input  type="text" id="search-bar" placeholder="Cerca libro">
    <a href="#"><i class="fas fa-search fa-lg"></i></a>
  </form>
</div>
<select >
  <option value="categorie"> Tutte le categorie</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</div>
<input type="submit" value="aggiungi libro">

<div class="container-inserimento">
<ul >
<li><form action="/action_page.php">
  <input type="file" name="pic" accept="image/*">
  <input type="submit">
</form></li>
<li>Isbn<input type="text" name="isbn" placeholder="isbn"></li>
<li>Titolo<input type="text" name="titolo" placeholder="titolo"></li>
<li>Trama<input type="text" name="trama" placeholder="trama"></li>
<li>CasaEditrice<input type="text" name="casaEditrice" placeholder="casa editrice"></li>
<li>Prezzo<input type="text" name="prezzo" placeholder="prezzo"></li>
<li style="display:-webkit-inline-box;">Quantita<input style="width:auto;"type="number" min="1" max="100"  class="form-control" id="" min="1" value="1"></li>
<li>Categoria<input type="text" name="categoria" placeholder="categoria"></li>
</ul>
</div>

</body>
</html>